public class Hospital {
    private String hospitalName;
    private int numberOfDoctors;
    private int numberOfPatients;
    private Doctor[] doctors;
    private Patient[] patients;
    private int sizeOfDoctors;
    private int sizeOfPatients;

    public Hospital(String hospitalName, int sizeOfDoctors, int sizeOfPatients) {
        this.hospitalName = hospitalName;
        this.sizeOfDoctors = sizeOfDoctors;
        this.sizeOfPatients = sizeOfPatients;
        this.numberOfDoctors = 0;
        this.numberOfPatients = 0;
        this.doctors = new Doctor[sizeOfDoctors];
        this.patients = new Patient[sizeOfPatients];
    }

   

    public void addDoctor(Doctor d) {
        if (d == null || numberOfDoctors >= sizeOfDoctors) {
            return;
        }
        doctors[numberOfDoctors] = new Doctor(d);
        numberOfDoctors++;
    }

    public void addPatient(Patient p) {
        if (p == null || numberOfPatients >= sizeOfPatients) {
            return;
        }
    
        int docIndex = -1;
        for (int i = 0; i < numberOfDoctors; i++) {
            Doctor d = doctors[i];
            if (d != null && d.isAvailable()) {
                docIndex = i;
                break; 
            }
        }
        if (docIndex < 0) {
            return;    
        }
    
        Patient admitted = new Patient(p);
        Doctor assigned = doctors[docIndex];
        admitted.setDoctor(assigned);
        assigned.assignPatient(admitted);
        patients[numberOfPatients] = admitted;
        numberOfPatients++;
    
    }

    public Patient findPatient(String name) {
        if (name == null) {
            return null;
        }
        for (int i = 0; i < numberOfPatients; i++) {
            Patient slot = patients[i];
            if (slot != null && name.equals(slot.getPatientName())) {
                return new Patient(slot);
            }
        }
        return null;
    }

    public Doctor findDoctor(String id) {
        if (id == null) {
            return null;
        }
        for (int i = 0; i < numberOfDoctors; i++) {
            Doctor slot = doctors[i];
            if (slot != null && id.equals(slot.getDoctorID())) {
                return new Doctor(slot);
            }
        }
        return null;
    }

    public void removePatient(Patient p) {
        if (p == null) {
            return;
        }
        String id = p.getPatientID();
        int index = -1;
        for (int i = 0; i < numberOfPatients; i++) {
            if (patients[i] != null && id.equals(patients[i].getPatientID())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        Patient stored = patients[index];
        Doctor dr = stored.getDoctor();
        if (dr != null) {
            String[] docPatients = dr.getPatients();
            int docCount = dr.getNoOfPatients();
            int found = -1;
            for (int k = 0; k < docCount; k++) {
                if (stored.getPatientID().equals(docPatients[k])) {
                    found = k;
                    break;
                }
            }
            if (found != -1) {
                for (int k = found; k < docCount - 1; k++) {
                    docPatients[k] = docPatients[k + 1];
                }
                docPatients[docCount - 1] = null;
                dr.setNoOfPatients(docCount - 1);
                if (docCount - 1 < 4) {
                    dr.setAvailable(true);
                }
            }
        }
        // --- THIS IS THE NEW PART: shift hospital patients array ---
        for (int j = index; j < numberOfPatients - 1; j++) {
            patients[j] = patients[j + 1];
        }
        patients[numberOfPatients - 1] = null;
        numberOfPatients--;
    }
}







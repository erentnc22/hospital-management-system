import java.util.Arrays;

public class Doctor {
    private String doctorName;
    private String doctorID;
    private String specialization;
    private String[] patients;
    private int noOfPatients;
    private boolean isAvailable;



public Doctor(){
    this.doctorName = "";
    this.doctorID = "";
    this.specialization = "";
    this.patients = new String[4];
    this.noOfPatients = 0;
    this.isAvailable = true;


}

public Doctor(String doctorName, String doctorID, String specialization){
    this.doctorName = doctorName;
    this.doctorID = doctorID;
    this.specialization = specialization;
    this.patients = new String[4];
    this.noOfPatients = 0;
    this.isAvailable = true;




}

public Doctor(Doctor other){
    this.doctorName = other.doctorName;
    this.doctorID = other.doctorID;
    this.specialization = other.specialization;
    this.patients = Arrays.copyOf(other.patients, 4);
    this.noOfPatients = other.noOfPatients;
    this.isAvailable = other.isAvailable;
}

public void assignPatient(Patient p) {
    if (p == null) {
        return;
    }
    if (!isAvailable) {
        return;
    }
    patients[noOfPatients] = p.getPatientID();
    noOfPatients++;
    if (noOfPatients == 4) {
        isAvailable = false;
    }
}



@Override
public String toString(){
    return "Doctor [Name: " + doctorName + ", ID: " + doctorID + ", Specialization: " + specialization + ", Patients: " + Arrays.toString(patients) + ", No of Patients: " + noOfPatients + ", Available: " + isAvailable + "]";
}

public boolean equals(Object obj){
    if(this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Doctor other = (Doctor) obj;
    return this.doctorID.equals(other.doctorID);
}





public String getDoctorName(){
    return doctorName;
}

public void setDoctorName(String doctorName){
    this.doctorName = doctorName;
}

public String getDoctorID(){
    return doctorID;
}

public void setDoctorID(String doctorID){
    this.doctorID = doctorID;
}

public String getSpecialization(){
    return specialization;
}

public void setSpecialization(String specialization){
    this.specialization = specialization;
}

public String[] getPatients(){
    return patients;
}

public void setPatients(String[] patients){
    this.patients = patients;
}

public int getNoOfPatients(){
    return noOfPatients;
}

public void setNoOfPatients(int noOfPatients){
    this.noOfPatients = noOfPatients;
}

public boolean isAvailable(){
    return isAvailable;
}

public void setAvailable(boolean isAvailable){
    this.isAvailable = isAvailable;
}





}









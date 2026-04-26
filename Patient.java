public class Patient {
    private String patientName;
    private String patientID;
    private String entryDate;
    private Doctor doctor;



public Patient(String patientName, String patientID, String entryDate, Doctor doctor ) {
    this.patientName = patientName;
    this.patientID = patientID;
    this.entryDate = entryDate;
    this.doctor = doctor;

}


public Patient(){
    this.patientName = "";
    this.patientID = "";
    this.entryDate = "";
    this.doctor = null; 
}

public Patient(Patient other) {

    this.patientName = other.patientName;
    this.patientID = other.patientID;
    this.entryDate = other.entryDate;
    this.doctor = other.doctor;

}

public String getPatientName(){
    return patientName;
}

public void setPatientName(String patientName){
    this.patientName = patientName;
}

@Override
public String toString(){
    String doctorName = (doctor != null) ? doctor.getDoctorName() : "No doctor assigned";
    return "Patient [Name: " + patientName + ", ID:  " + patientID + ", Entry Date:" + entryDate + ", Doctor: " + doctorName + "]";

}

public boolean equals(Object obj){
    if(this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Patient other = (Patient) obj;
    return this.patientID.equals(other.patientID);
}

public String getPatientID(){
    return patientID;
}

public void setPatientID(String patientID){
    this.patientID = patientID;
}


public String getEntryDate(){
    return entryDate;
}

public void setEntryDate(String entryDate){
    this.entryDate = entryDate;
}

public Doctor getDoctor(){
    return doctor;
}
public void setDoctor(Doctor doctor){
    this.doctor = doctor;
}

}











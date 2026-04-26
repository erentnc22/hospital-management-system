public class Main {

    public static void main(String[] args) {

        System.out.println("=== Assignment 1 Main ===\n");

    
        System.out.println("PART A: Patient");
        Patient p1 = new Patient("Ali", "P001", "2026-04-01", null);
        System.out.println(p1);

        Patient p2 = new Patient();
        System.out.println(p2);

        Patient p3 = new Patient(p1);
        System.out.println("Copy of p1: " + p3);
        System.out.println("p1 equals p3? " + p1.equals(p3));

        
        System.out.println("\nPART B: Doctor");
        Doctor d1 = new Doctor("Dr. Ayse", "D001", "Heart");
        System.out.println(d1);

        d1.assignPatient(p1);
        System.out.println("After assignPatient:");
        System.out.println(d1);

        Doctor d2 = new Doctor(d1);
        System.out.println("d1 equals d2? " + d1.equals(d2));

        
        System.out.println("\nPART C: Hospital");
        Hospital h = new Hospital("My Hospital", 3, 10);

        Doctor docA = new Doctor("Dr. One", "DA", "Surgery");
        Doctor docB = new Doctor("Dr. Two", "DB", "Eyes");
        h.addDoctor(docA);
        h.addDoctor(docB);
        System.out.println("Added two doctors.");

        Patient pat1 = new Patient("Zeynep", "Z1", "2026-04-10", null);
        Patient pat2 = new Patient("Can", "C1", "2026-04-11", null);
        h.addPatient(pat1);
        h.addPatient(pat2);
        System.out.println("Added two patients.");

        Patient found = h.findPatient("Zeynep");
        System.out.println("findPatient Zeynep: " + found);

        Doctor foundDoc = h.findDoctor("DA");
        System.out.println("findDoctor DA: " + foundDoc);

        h.removePatient(pat2);
        System.out.println("After removePatient(Can):");
        System.out.println(h.findPatient("Can"));
        System.out.println(h.findDoctor("DA"));

        System.out.println("\n=== End ===");
    }
}
































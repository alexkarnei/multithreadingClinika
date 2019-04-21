package by.itStep.karnei;

public class Doctor extends Thread {

    private int patientToServe;
    private final int maxQuantityPatientInDay = 10;

    public Doctor(int patientToServe) {
        this.patientToServe = patientToServe;
    }
}

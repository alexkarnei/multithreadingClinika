package by.itStep.karnei;

public class Doctor extends Thread {

    private int patientToServe;
    private final int maxQuantityPatientInDay = 10;

    public Doctor(int patientToServe) {
        this.patientToServe = patientToServe;
    }

    public void run(){

    }

    public int getPatientToServe() {
        return patientToServe;
    }

    public void setPatientToServe(int patientToServe) {
        this.patientToServe = patientToServe;
    }

    public int getMaxQuantityPatientInDay() {
        return maxQuantityPatientInDay;
    }
}

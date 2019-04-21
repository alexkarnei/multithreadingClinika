package by.itStep.karnei;

public class Patient extends Thread {

    private int orderNumber;
    private int timeToHeal;

    public Patient(int orderNumber, int timeToHeal) {
        this.orderNumber = orderNumber;
        this.timeToHeal = timeToHeal;
    }
}

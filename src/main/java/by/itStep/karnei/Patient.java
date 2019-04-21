package by.itStep.karnei;

public class Patient extends Thread {

    private int orderNumber;
    private int timeToHeal;

    public Patient(int orderNumber, int timeToHeal) {
        this.orderNumber = orderNumber;
        this.timeToHeal = timeToHeal;
    }

    public void run() {

    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getTimeToHeal() {
        return timeToHeal;
    }

    public void setTimeToHeal(int timeToHeal) {
        this.timeToHeal = timeToHeal;
    }
}

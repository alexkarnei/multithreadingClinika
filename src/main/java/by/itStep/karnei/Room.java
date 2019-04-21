package by.itStep.karnei;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Room {

    private Doctor doctor;
    private Lock lock;

    public Room(Doctor doctor) {
        this.doctor = doctor;
        this.lock = new ReentrantLock();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }
}
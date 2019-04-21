package by.itStep.karnei;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Room {

    private Doctor doctor;
    private Lock lock = new ReentrantLock();

    public Room(Doctor doctor, Lock lock) {
        this.doctor = doctor;
        this.lock = lock;
    }
}
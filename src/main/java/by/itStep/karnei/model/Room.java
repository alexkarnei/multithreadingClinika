package by.itStep.karnei.model;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Room {

    private Doctor doctor;
    private boolean availability;
    private Patient patient;
    private int roomNumber;
    private Lock lock;
    private static AtomicInteger counter = new AtomicInteger(0);


    public Room() {
        this.availability = true;
        this.doctor = null;
        this.patient = null;
        this.lock = new ReentrantLock();
        this.roomNumber = counter.incrementAndGet();

    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }
}
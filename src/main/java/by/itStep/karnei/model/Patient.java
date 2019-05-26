package by.itStep.karnei.model;

import by.itStep.karnei.Main;
import by.itStep.karnei.service.Clinica;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;

public class Patient extends Thread {

    private int orderNumber;
    private int timeToHealth;
    private Clinica clinica;
    private static AtomicInteger count = new AtomicInteger(0);

    public Patient(Clinica clinica) {
        this.clinica = clinica;
        this.timeToHealth = 500 * (10 + new Random().nextInt(9));
        this.orderNumber = count.incrementAndGet();
        Main.LOG.info("Patient number: " + this.orderNumber + " has coming");
    }

    @Override
    public void run() {
        if (!this.clinica.getDoctors().stream().filter(Thread::isAlive).collect(Collectors.toList()).isEmpty()) {
            if (this.clinica.getPatients().isEmpty()) {
                if (enterRoom()) {
                } else {
                    checkAddToQueue();
                }
            } else {
                checkAddToQueue();
            }
        }
    }

    private void checkAddToQueue() {
        if (addToQueue()) {
            if (this.timeToHealth != 0) {
                this.clinica.getPatients().remove(this);
                Main.LOG.info("Long wait patient number: " + this.orderNumber);
            }
        }
    }


    private boolean enterRoom() {
        for (Room room : this.clinica.getRooms()) {
            if (room.isAvailability()) {
                room.setPatient(this);
                room.setAvailability(false);
                Main.LOG.info("Patient number: " + this.orderNumber + "go to room number: " +
                        room.getRoomNumber());
                Lock lock = room.getLock();
                synchronized (lock) {
                    lock.notify();
                }
                try {
                    this.sleep(this.timeToHealth);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }

    private boolean addToQueue() {
        boolean add;
        try {
            if (add = this.clinica.getPatients().add(this)) {
                Main.LOG.info("Add to queue patient number: " + this.orderNumber);
            }
            try {
                sleep(1000 * (10 + new Random().nextInt(30)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IllegalStateException ex) {
            Main.LOG.info("Full clinic!!! " + this.orderNumber + " go away. Queue is full.");
            return false;
        }
        return add;
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getTimeToHealth() {
        return timeToHealth;
    }

    public void setTimeToHealth(int timeToHealth) {
        this.timeToHealth = timeToHealth;
    }
}

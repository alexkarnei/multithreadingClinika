package by.itStep.karnei.model;

import by.itStep.karnei.Main;
import by.itStep.karnei.service.Clinica;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public class Doctor extends Thread {

    private int patientToServe;
    private final int maxQuantityPatientInDay = 3;
    private int numberDoctor;
    private Room room;
    private Clinica clinica;
    private static final AtomicInteger count = new AtomicInteger(0);

    public Doctor(Clinica clinica) {
        this.patientToServe = 0;
        this.numberDoctor = count.incrementAndGet();
        this.clinica = clinica;
        Main.LOG.info("Started doctor number: " + this.numberDoctor);
    }

    @Override
    public void run() {
        while (patientToServe < maxQuantityPatientInDay) {
            if (this.room.isAvailability() && (this.clinica.getPatients().size() == 0)) {
                doctorWait();
            } else {
                if (this.room.isAvailability()) {
                    getQueue();
                }
            }
            System.out.println(currentThread());
            System.out.println(getPatientToServe());
            continue;
        }
        this.room.setAvailability(false);
        Main.LOG.info("Has finished work doctor number: " + this.numberDoctor);
    }


    public void doctorWait() {
        Lock lock = this.room.getLock();
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            healthPatient();
        }
    }

    public void getQueue() {
        Patient patient = this.clinica.getPatients().poll();
        if (patient != null) {
            this.room.setPatient(patient);
            Main.LOG.info(" Doctor number: " + numberDoctor + " take patient " +
                    room.getPatient().getOrderNumber() + " at queue in room number: "
                    + this.room.getRoomNumber());
            this.room.setAvailability(false);
            healthPatient();
        }
    }

    private void healthPatient() {
        int time = this.room.getPatient().getTimeToHealth();
        this.room.getPatient().setTimeToHealth(0);
        try {
            this.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.patientToServe++;
        this.room.setAvailability(true);
        Main.LOG.info("Patient number: " + this.room.getPatient().getOrderNumber() + " served!");
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
}


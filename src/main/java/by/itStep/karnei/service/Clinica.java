package by.itStep.karnei.service;

import by.itStep.karnei.Main;
import by.itStep.karnei.model.Doctor;
import by.itStep.karnei.model.Patient;
import by.itStep.karnei.model.Room;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Clinica {

    private Collection<Room> rooms;
    private Queue<Patient> patients;
    private static AtomicInteger count = new AtomicInteger(0);
    private Set<Doctor> doctors;

    public Clinica(int roomQuantity, int queueQuantity) {
        this.rooms = new ArrayList<Room>(roomQuantity);
        this.patients = new ArrayBlockingQueue<Patient>(queueQuantity);
        doctors = new HashSet<>();
        for (int i = 0; i < roomQuantity; i++) {
            rooms.add(new Room());
        }
        for (Room room : rooms) {
            Doctor doctor = new Doctor(this);
            doctors.add(doctor);
            doctor.setRoom(room);
            doctor.start();
        }
        Main.LOG.info("Clinic is open");
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public Queue<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Queue<Patient> patients) {
        this.patients = patients;
    }


    public void startPatient(Patient patient) {
        patient.start();
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}

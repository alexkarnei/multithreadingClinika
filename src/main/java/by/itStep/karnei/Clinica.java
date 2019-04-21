package by.itStep.karnei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Clinica {

    private Collection<Room> rooms;
    private Queue<Patient> patients;

    public Clinica(Collection<Room> rooms, Queue<Patient> patients) {
        this.rooms = new ArrayList<Room>(rooms.size());
        this.patients = new ArrayBlockingQueue<Patient>(patients.size());
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Queue<Patient> getPatients() {
        return patients;
    }
}

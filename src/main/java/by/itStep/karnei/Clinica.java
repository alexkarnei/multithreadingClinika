package by.itStep.karnei;

import java.util.Collection;
import java.util.Queue;

public class Clinica {

    private Collection <Room> rooms;
    private Queue <Patient> patients;

    public Clinica(Collection<Room> rooms, Queue<Patient> patients) {
        this.rooms = rooms;
        this.patients = patients;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Queue<Patient> getPatients() {
        return patients;
    }
}

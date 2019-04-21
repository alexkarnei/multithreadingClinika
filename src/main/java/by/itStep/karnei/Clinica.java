package by.itStep.karnei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Clinica {

    private Collection<Room> rooms;
    private Queue<Patient> patients;

    public Clinica(int roomQuantity, int queueQuantity) {
        this.rooms = new ArrayList<Room>(roomQuantity);
        this.patients = new ArrayBlockingQueue<Patient>(queueQuantity);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Queue<Patient> getPatients() {
        return patients;
    }
}

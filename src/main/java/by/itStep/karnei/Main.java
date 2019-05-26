package by.itStep.karnei;

import by.itStep.karnei.model.Patient;
import by.itStep.karnei.service.Clinica;

import java.util.logging.Logger;

public class Main {
    final static public Logger LOG = Logger.getLogger("logger");

    public static void main(String args[]) {

        Clinica clinica = new Clinica(4, 5);
        for (int i = 0; i < 25; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Patient patient = new Patient(clinica);
            clinica.startPatient(patient);
        }
    }
}

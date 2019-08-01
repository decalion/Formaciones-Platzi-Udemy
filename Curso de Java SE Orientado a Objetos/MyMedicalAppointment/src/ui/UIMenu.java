package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = {"Enero", "Febrero", "Marzo",
            "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
            "Octubre", "Noviembre", "Diciembre"};


    public static Doctor doctorLogged;
    public static Patient patientLogged;


    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opcion deseada");

        int response = 0;

        do {
            System.out.println("1. model.Doctor");
            System.out.println("2. model.Patient");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    //showPatientMenu();
                    authUser(2);
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Please select a Correct answer");
            }

        } while (response != 0);

    }


    private static void authUser(int userType) {
        //userType = 1 Doctor
        //userType= 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martinez", "amartinez@mail.com"));
        doctors.add(new Doctor("Karen Sosa", "ksosa@mail.com"));
        doctors.add(new Doctor("Rocio Gomez", "rgomez@mail.com"));


        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Anahi Salgado", "anahi@mail.com"));
        patients.add(new Patient("Roberto Rodrriguez", "roberto@mail.com"));
        patients.add(new Patient("Carlos Sanchez", "carlos@mail.com"));


        boolean emailCorrect = false;

        do {
            System.out.println("Insert yor email: [a@.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if (userType == 1) {

                for (Doctor d : doctors) {
                    if (d.getEmail().equals(email)) {
                        emailCorrect = true;
                        //Obtener el doctor logeado
                        doctorLogged = d;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }

            }

            if (userType == 2) {

                for (Patient p : patients) {
                    if (p.getEmail().equals(email)) {
                        emailCorrect = true;
                        //Obtener el paciente logeado
                        patientLogged = p;
                        //Mostrar el menu de pacientes
                    }
                }

            }

        } while (!emailCorrect);

    }




}

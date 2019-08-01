package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {


    public static void showPatientMenu() {
        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UIMenu.patientLogged);
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointment");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    showBookAppointmentMenu();
           
                    break;
                case 2:
                    System.out.println("::My appointment");
                    break;
                case 0:
                    response= 0;
                    UIMenu.showMenu();
                    break;
                default:
                    System.out.println("Please select a Correct answer");
            }


        } while (response != 0);


    }


    private static void showBookAppointmentMenu(){
        int response = 0;

        do{
            System.out.println("::Book an appointment");
            System.out.println("::Select  date: ");
            
            
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {

                ArrayList<Doctor.AvaliableAppointment> avaliableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvaliableAppointments();

                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();

                for (int j = 0; j < avaliableAppointments.size() ; j++) {
                    k++;
                    System.out.println(k + ". " + avaliableAppointments.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j),UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointment);

                }
                
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for(Map.Entry<Integer,Doctor> doc : doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: " +
                    doctorSelected.getAvaliableAppointments().get(indexDate).getDate() +
                    " . Time: " +
                    doctorSelected.getAvaliableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n1. yes \n2. Change Data");

            response = Integer.valueOf(sc.nextLine());

            if(response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(doctorSelected,
                        doctorSelected.getAvaliableAppointments().get(indexDate).getDate(),
                        doctorSelected.getAvaliableAppointments().get(indexDate).getTime());

            }


        }while(response !=0) ;
    }






}

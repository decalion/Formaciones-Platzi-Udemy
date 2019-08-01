package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();


    public static void showDoctorMenu() {

        int response = 0;

        do {

            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. add available Appointment");
            System.out.println("2. My Scheduled appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());


            switch (response) {

                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;

                case 0:
                    UIMenu.showMenu();
                    break;
                default:
                    break;

            }


        } while (response != 0);


    }


    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;

        do{

            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a Month");

            for (int i = 0; i < 3 ; i++) {

                int j = i +1;

                System.out.println(j + ". "+UIMenu.MONTHS[i]);
            }

            System.out.println("0. Return");
            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            if(response > 0 && response < 4){

                int monthSeleced = response;
                System.out.println(monthSeleced + ". " + UIMenu.MONTHS[monthSeleced - 1]);

                System.out.println("Insert the date available: [dd/mm/yyy]");
                String date = sc.nextLine();

                System.out.println("Your date is: "+ date + "\n1. Coorect \n2.Change Date");

                int responseDate = Integer.parseInt(sc.nextLine());
                if(response == 2) continue;

                int responseTime = 0;
                String time = "";
                do{
                    System.out.println("Insert the Time available for date " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: "+ time + "\n1. Coorect \n2.Change Time");
                    responseTime = Integer.parseInt(sc.nextLine());

                }while (responseTime == 2);


                    UIMenu.doctorLogged.addAvliableAppointment(date,time);
                    checkDoctorAvailableAppointment(UIMenu.doctorLogged);

            }else if(response == 0){
                showDoctorMenu();
            }


        }while(response != 0);


    }


    private static void checkDoctorAvailableAppointment(Doctor doctor){

        if(doctor.getAvaliableAppointments().size() >0
            && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }



    }






}

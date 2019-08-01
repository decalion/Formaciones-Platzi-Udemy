package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;

    private ArrayList<AvaliableAppointment> avaliableAppointments = new ArrayList<>();


    public Doctor(String name, String email) {
        super(name,email);
    }



    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }



    public void addAvliableAppointment(String date, String time){



        avaliableAppointments.add(new AvaliableAppointment(date,time));

    }

    public ArrayList<AvaliableAppointment> getAvaliableAppointments(){
        return avaliableAppointments;
    }


    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality + "\nAvaliable :" + avaliableAppointments.toString();
    }

    @Override
    public void showDataUser() {

    }

    public static class AvaliableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvaliableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public String getDate(String date) {
            return format.format(date);
        }


        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Avaliable Appointmenr \nDate: "+date+ "\nTime: " +time;
        }
    }


}

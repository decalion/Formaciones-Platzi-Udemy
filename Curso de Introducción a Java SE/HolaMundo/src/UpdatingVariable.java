public class UpdatingVariable {


    public static void main(String[] args) {
        int salary = 1000;

        //bono de 200
        salary = salary + 200;
        System.out.println(salary);

        // descuento de 50
        salary = salary -50;
        System.out.println(salary);

        //2 horas extras 30
        //comida 45
        salary = salary +(30*2) -45;
        System.out.println(salary);


        //Actualizando cadenas de texto
        String employeeName = "Ismael Caballero";

        employeeName = employeeName + " Hernandez";

        System.out.println(employeeName);

    }
}

package lesson_5;

import java.text.DecimalFormat;

/**
 * Сделал всё в одном файле, хотя, можно было бы и отдельно класс Employee прописать,
 * но тогда бы было 2 файла...
 * Лишние сеттеры/геттеры не добавлял.
 * telNumber стринговый так как может быть переполнение
 * добавил форматированный вЫвод зарплаты
 * --как сделать форматированный ввод - не разобрался:(
 */
class Employee{
    private String fullName = "not_set";
    private String post = "not_set";
    private String email = "not_set";
    private String telNumber = "not_set";
    private double salary;
    private int age;

    DecimalFormat dF = new DecimalFormat( "#.00" );

    public Employee(String fullName, String post, String email,
                        String telNumber1, double salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.telNumber = telNumber1;
        this.salary = salary;
        this.age = age;

    }
    public void getInfo(){
        System.out.println("ФИО: " + this.fullName);
        System.out.println("Должность: " + this.post);
        System.out.println("email: " + this.email);
        System.out.println("Номер телефона: " + this.telNumber);
        System.out.println("Заработная плата: " + dF.format(this.salary) +" тугриков"  );
        System.out.println("Возраст: "+ this.age);
        System.out.println();//разделитель
    }
    public int getAge() {
        return age;
    }
}
public class Lesson_5 {
    public static void main(String[] args) {
        Employee[] persArry = new Employee[5];
        persArry[0] = new Employee(
                "Макс Планк",
                "Физик - теоретик",
                "horns@hooves1.com",
                "88002000600",
                300000.30,
                25);
        persArry[1] = new Employee(
                "Мария Кюри",
                "Физик - практик",
                "horns@hooves2.com",
                "88002000601",
                350000.05,
                26);
        persArry[2] = new Employee(
                "Нильс Бор",
                "Физик - теоретик",
                "horns@hooves3.com",
                "88002000602",
                360000.66,
                55);
        persArry[3] = new Employee(
                "Эрвин Шредингер",
                "Физик - теоретик",
                "horns@hooves4.com",
                "88002000603",
                300000,
                41);
        persArry[4] = new Employee(
                "Вольфганг Паули",
                "Физик - теоретик",
                "horns@hooves5.com",
                "88002000604",
                390000.90,
                60);

        for (int i = 0; i < persArry.length; i++) {
            if(persArry[i].getAge() > 40) persArry[i].getInfo();
        }
    }
}

package lesson_6;

public class Cat extends Animals {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(double runMetre){
        if(Math.abs(runMetre) > 200) System.out.println("Кот/кошка "+ name +
                " устанет" + " и не пробежит столько");
        else System.out.println("Кот/кошка "+ name +
                " пробежал(а) " + Math.abs(runMetre)+ " метров.");
    }

    @Override
    public void swim(double swimMetre){
        System.out.println("Кот/кошка "+ name + " не умеет плавать!!!");

    }





}


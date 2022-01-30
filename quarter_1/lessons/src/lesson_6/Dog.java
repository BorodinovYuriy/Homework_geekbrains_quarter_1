package lesson_6;

public class Dog extends Animals{

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(double runMetre){
      if(Math.abs(runMetre) > 500) System.out.println("Собака "+ name +
              " устанет" + " и не пробежит столько");
      else System.out.println("Собака "+ name +
              " пробежала " + Math.abs(runMetre)+ " метров.");
    }

    @Override
    public void swim(double swimMetre){
        if(Math.abs(swimMetre) > 10) System.out.println("Собака "+ name +
                " устанет" + " и не проплывёт столько");
        else System.out.println("Собака "+ name +
                " проплыла " + Math.abs(swimMetre)+ " метров.");
    }





}

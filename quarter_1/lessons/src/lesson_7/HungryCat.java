package lesson_7;

public class HungryCat {

    private String name;
    private int appetite;
    private boolean satiety = false;

    public HungryCat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        if (appetite > p.getFood()) {
            System.out.println("Котику " + "\"" + name + "\"" + " этого мало!!!");
            p.printInfo();
            System.out.println("Нужно: "+ appetite);
            satiety = false;
        }
        else{
            System.out.println("Котик "+"\""+name+"\""+" скушал: "+ appetite);
            p.decreaseFood(appetite);
            p.printInfo();
            satiety = true;
        }
    }
    public boolean isSatiety(){
        return satiety;
    }
    public String getName() {
        return name;
    }
    //альтернативная реализация метода info (без печати)
    String catFullInfo(){
        return "Кличка: " + this.name + ". " +
                "Аппетит: " + this.appetite + ". ";
    }
}

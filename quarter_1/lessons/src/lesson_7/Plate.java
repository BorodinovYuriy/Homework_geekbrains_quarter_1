package lesson_7;

public class Plate {
    private int food;
    private String foodName;

    public Plate (int food, String foodName) {
        this.foodName = foodName;
        this.food = food;
    }
    public void decreaseFood(int n) {
        food -= n;
    }
    public void printInfo() {
        if (food <= 0) System.out.println(foodName+" пуста!");
        else System.out.println("plate " +"\""+foodName + "\": " + food);
    }
    public int getFood(){
        return food;
    }

    public void addFood(int food) {
        this.food += food;
    }
    //альтернативная реализация метода info (без печати)
    String plateFullInfo(){
        return "Название миски: "+ this.foodName +". "+
                " Наполненность миски: " + this.food+". ";
    }
}

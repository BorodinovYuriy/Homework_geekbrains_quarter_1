package lesson_1;

public class HomeWorkApp {
    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    //Методы сделал сразу с "инициализацией"
    //Переменные задаются в main
    public static void checkSumSign(int a, int b){
        if ((a+b) >= 0) System.out.println("Сумма положительная");
        if ((a+b) < 0) System.out.println("Сумма отрицательная");
    }
    public static void printColor(int value){
        if (value <= 0 ){
            System.out.println("Красный");
        }
        else if (value > 0 && value <= 100){
            System.out.println("Желтый");
        }
        else System.out.println("Зелёный");
    }
    public static void compareNumbers(int a, int b){
        if (a >= b) System.out.println("a >= b");
        if (a < b) System.out.println("a < b");
    }

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(34,-500);
        printColor(0);
        compareNumbers(300,2);

    }
}

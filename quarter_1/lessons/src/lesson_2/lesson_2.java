package lesson_2;

public class lesson_2 {
    public static void main(String[] args) {

        System.out.println(ten_twenty(10,10));    //1
        positive(4);                            //2
        System.out.println(negativeTF(3));     //3
        strPrint("five", 5);                   //4
        System.out.println(visokos(2001));      //5

    }
    public static boolean ten_twenty (int a, int b){
        boolean check = false;
        if ((a + b) >= 10 && (a + b) <= 20) check = true;
        return check;
    }
    public static void positive (int number){
        if (number >= 0) System.out.println("Число "+number+" - положительное.");
        else System.out.println("Число "+number+" - отрицательное.");

    }
    public static boolean negativeTF(int number){
        boolean check = false;
        if (number < 0) check = true;
        return check;
    }
    public static void strPrint(String str, int n){
        for (int i = 0; i < n; i++) System.out.println(str);
    }
    public static boolean visokos (int year){
        boolean check = false;
        if ((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 > 0)) check = true;
        return check;

    }
}

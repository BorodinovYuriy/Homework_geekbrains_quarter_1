package lesson_3;
import java.util.Arrays;
import java.util.Random;
public class Lesson_3 {
    public static void main(String[] args) {
        Random random = new Random();
        //Задание_1
        //...пробовал оптимизировать через тернарный - не получилось ничего, оставил так.
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задание_1\nНачальный массив:\n"+Arrays.toString(arr));
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == 0) arr[a] = 1;
            else if (arr[a] == 1) arr[a] = 0;
        }
        System.out.println("Измененный массив:\n"+Arrays.toString(arr));
        //Задание_2
        int[] arr_2 = new int[100];
        for (int i = 0, a = 1; i < arr_2.length; i++, a++) {
            arr_2[i] = a;
        }
        System.out.println("Задание_2\n"+Arrays.toString(arr_2));
        //Задание_3
        int[] arr_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int a = 0; a < arr_3.length; a++) {
            if (arr_3[a] < 6) {
                arr_3[a] = arr_3[a] * 2;
            }
        }
        System.out.println("Задание_3\n"+Arrays.toString(arr_3));
        //Задание_4
        System.out.println("Задание_4");
        int[][] arr_4 = new int[9][9];
        for (int i = 0, a = arr_4.length - 1; i < arr_4.length; i++, a--) {
            for (int j = 0, b = 0; j < arr_4[i].length; j++, b++) {
                if (i == j || a == b) arr_4[i][j] = 1;
                //else arr_4[i][j] = 0;//можно не писать
            }
        }
        for (int i = 0; i < arr_4.length; i++) {
            for (int j = 0; j < arr_4[i].length; j++) {
                System.out.print(arr_4[i][j] + " ");
            }
            System.out.println();
        }
        //Задание_5
        int[] arr_5 = makeArr(5, 100);
        System.out.println("Задание_5\n"+Arrays.toString(arr_5));
        //Задание_6
        int[] arr_6 = new int[20];
        for (int i = 0; i < arr_6.length; i++) {
            arr_6[i] = random.nextInt(100);
        }
        System.out.println("Задание_6\n"+Arrays.toString(arr_6));
        min_max_arr(arr_6);//в задании не было сказанно, каким именно методом...
        //Задание_7
        int[] arr_7 = {9, 5, 1, 1, 1, 3, 4, 4};
        System.out.println("Задание_7\n"+Arrays.toString(arr_7));
        System.out.println(arrСomparSum(arr_7));
        //Задание_8
        int[] arr_8 = {1, 2, 3, 4, 5};
        System.out.println("Задание_8\n"+Arrays.toString(arr_8));
        arrModShuffle(arr_8, 32);
        System.out.println(Arrays.toString(arr_8));
    }
    public static int[] makeArr(int len, int initialValue) {
                int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
    public static void min_max_arr(int Arr[]) {
        Arrays.sort(Arr);
        int min = Arr[0];
        int max = Arr[Arr.length - 1];
        System.out.println("Минимальное значение: " + min + "\nМаксимальное значение: " + max);
    }
    public static boolean arrСomparSum(int Arr[]) {
        int arrSum = 0;
        int tmp = Arr[0];
        boolean tf = false;
        for (int i = 0; i < Arr.length; i++) {
            arrSum += Arr[i];//Общая сумма чисел в массиве
        }
        for (int count = 1; count < Arr.length; count++) {
            if (tmp == (arrSum - tmp)) tf = true;//Разница (общей суммы - tmp) и tmp
            tmp += Arr[count];
        }
        return tf;
    }
    public static int[] arrModShuffle(int arr[], int mod) {
        int shuffle = Math.abs(mod % arr.length);
        if (mod > 0) {
            for (int i = shuffle; i > 0; i--) {
                for (int j = 1; j < arr.length; j++) {
                    int temp = arr[0];
                    arr[0] = arr[j];
                    arr[j] = temp;
                }
            }

        } else if (mod < 0) {
            for (int i = shuffle; i > 0; i--) {
                for (int j = arr.length - 2; j >= 0; j--) {
                    int temp = arr[arr.length - 1];
                    arr[arr.length - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
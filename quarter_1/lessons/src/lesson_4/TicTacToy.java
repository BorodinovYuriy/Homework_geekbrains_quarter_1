package lesson_4;
import java.util.Random;
import java.util.Scanner;
//**************************Крестики-нолики в процедурном стиле**************************//
public class TicTacToy {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';   // 8226 UTF
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final int DANGER_FOR_AI = 3;


    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X, DOTS_TO_WIN)) {
                System.out.println("Победил человек");
                break;
            } if (isMapFull()) {
                System.out.println("Ничья");
                break;
            } aiTurn();
            printMap();
            if (checkWin(DOT_O, DOTS_TO_WIN)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            } if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    public static void printMap(){    //Убрал координату "0", добавил пробелы для наглядности
        for (int i = 0; i <= SIZE; i++) {
            if(i == 0) System.out.print(" " + "    ");
            else System.out.print(i + "    ");

        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1)+"    ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void humanTurn(){
        int x,y;
        do {
            System.out.println("Введите координаты в формате: "+"\"строка/столбец\"");
            x = sc.nextInt() -1;
            y = sc.nextInt() -1;
        } while (!isCellValid(x, y));
        map [x][y] = DOT_X;
    }
    public static boolean isCellValid(int x, int y){
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[x][y] == DOT_EMPTY;
    }
    public static void aiTurn(){
        //Ставим виртуальные крестики/нолики и проверяем....
        int x = -1;
        int y = -1;
        boolean aiWin = false;
        boolean humanWin = false;
        boolean humanCheck = false;
        boolean dangerAI = false;
        boolean rnd = false;
//1
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)){
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O, DOTS_TO_WIN)){
                        x = i;
                        y = j;
                        aiWin = true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
//2
        if (!aiWin){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)){
                        map[i][j] = DOT_X;
                        if (checkWin(DOT_X, DOTS_TO_WIN)){
                            x = i;
                            y = j;
                            humanWin = true;
                        }
                        map [i][j] = DOT_EMPTY;
                    }
                }
            }
        }
//3
        if (!humanWin){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)){
                        map[i][j] = DOT_O;
                        if (checkWin(DOT_O, DANGER_FOR_AI)){
                            x = i;
                            y = j;
                            humanCheck = true;
                        }
                        map [i][j] = DOT_EMPTY;
                    }
                }
            }
        }
//4
        if (!humanCheck){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)){
                        map[i][j] = DOT_X;
                        if (checkWin(DOT_X, DANGER_FOR_AI)){
                            x = i;
                            y = j;
                            dangerAI = true;
                        }
                        map [i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        if (!dangerAI){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)){
                        map[i][j] = DOT_O;
                        if (checkWin(DOT_O, DANGER_FOR_AI-1)){
                            x = i;
                            y = j;
                            rnd = true;
                        }
                        map [i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        if (!aiWin && !humanWin && !humanCheck && !dangerAI && !rnd){
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }while (!isCellValid(x, y));
        }
        map[x][y] = DOT_O;
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
    }
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        } return true;
    }
    public static boolean checkWin(char symb, int dot) {    //Переделано циклом for
        boolean win = false;
        int count_1;
        int count_2;
        int count_3 = 0;
        int count_4 = 0;
        int count_5 = 0;
        int count_6 = 0;
        int count_7 = 0;
        int count_8 = 0;

        for (int i = 0, a = SIZE - 1; i < SIZE && a >= 0; i++, a--) {
//1
            if (map[i][i] == symb) count_3++;
            else count_3 = 0;
            if (count_3 == dot) win = true;
//2
            if (map[a][i] == symb) count_4++;
            else count_4 = 0;
            if (count_4 == dot) win = true;
        }
        for (int i = 0, z = 1, a = SIZE - 1; i < SIZE && z < SIZE && a >= 0 ; i++, z++, a--) {
            count_1 = 0;
            count_2 = 0;
//3
            if (map[i][z] == symb) count_5++;
            //else count_5 = 0;
            if (count_5 == dot) win = true;
//4
            if (map[z][i] == symb) count_6++;
            //else count_6 = 0;
            if (count_6 == dot) win = true;
//5
            if (map[i][a-1] == symb) count_7++;
            //else count_7 = 0;
            if (count_7 == dot) win = true;
//6
            if (map[a][z] == symb) count_8++;
            //else count_8 = 0;
            if (count_8 == dot) win = true;

            for (int j = 0; j < SIZE; j++) {
//7
                if (map[i][j] == symb) count_1++;
                else count_1 = 0;
                if (count_1 == dot) win = true;
//8
                if (map[j][i] == symb) count_2++;
                else count_2 = 0;
                if (count_2 == dot) win = true;
            }
        }
        return win;
    }


}

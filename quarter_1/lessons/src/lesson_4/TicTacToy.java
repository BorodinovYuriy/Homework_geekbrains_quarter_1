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


    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            } if (isMapFull()) {
                System.out.println("Ничья");
                break;
            } aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
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

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)){
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O)){
                        x = i;
                        y = j;
                        aiWin = true;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        if (!aiWin){
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (isCellValid(i, j)){
                        map[i][j] = DOT_X;
                        if (checkWin(DOT_X)){
                            x = i;
                            y = j;
                            humanWin = true;
                        }
                        map [i][j] = DOT_EMPTY;
                    }
                }
            }
        }
        if (!aiWin && !humanWin){
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
    public static boolean checkWin(char symb) {//Переделано циклом for,ужас:(
        boolean win = false;
        int winCount1;
        int winCount2;
        int winCount3 = 0;
        int winCount4 = 0;
        int winCount5 = 0;
        int winCount6 = 0;
        int winCount7 = 0;
        int winCount8 = 0;
        for (int i = 0; i < SIZE; i++) {
            winCount1 = 0;
            winCount2 = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) winCount2++;
                if (map[j][i] == DOT_EMPTY) winCount2 = 0;
                if (winCount2 == DOTS_TO_WIN) win = true;
                if (map[i][j] == symb) winCount1++;
                if (map[i][j] == DOT_EMPTY) winCount1 = 0;
                if (winCount1 == DOTS_TO_WIN) win = true;
            }
        }
//диагональ 1
        int lp_1 = 0;
        for (int i = 0; i < SIZE; i++, lp_1++) {
            if (map[i][lp_1] == symb) winCount3++;
            if (map[i][lp_1] == DOT_EMPTY) winCount3 = 0;
            if (winCount3 == DOTS_TO_WIN) win = true;
        }
//диагональ 2
        int lp_2 = 0;
        for (int r = SIZE-1; r >= 0; r--, lp_2++) {
            if (map[r][lp_2] == symb) winCount4++;
            if (map[r][lp_2] == DOT_EMPTY) winCount4 = 0;
            if (winCount4 == DOTS_TO_WIN) win = true;
        }
//диагональ 3*
        int lp_3 = 1;
        for (int i = 0; i < SIZE && lp_3 < SIZE; i++, lp_3++) {
            if (map[i][lp_3] == symb) winCount5++;
            if (winCount5 == DOTS_TO_WIN) win = true;
        }
//диагональ 4*
        int lp_4 = 0;
        for (int i = 1; i < SIZE && lp_4 < SIZE; i++, lp_4++) {
            if (map[i][lp_4] == symb) winCount6++;
            if (winCount6 == DOTS_TO_WIN) win = true;
        }
//диагональ 5*
        int lp_5 = SIZE - 2;
        for (int i = 0; i < SIZE && lp_5 >= 0; i++, lp_5--) {
            if (map[i][lp_5] == symb) winCount7++;
            if (winCount7 == DOTS_TO_WIN) win = true;
        }
//диагональ 6*
        int lp_6 = SIZE - 1;
        for (int i = 1; i < SIZE && lp_6 >= 0; i++, lp_6--) {
            if (map[i][lp_6] == symb) winCount8++;
            if (winCount8 == DOTS_TO_WIN) win = true;
        }
        return win;
    }
}


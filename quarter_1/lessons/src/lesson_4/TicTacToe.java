package lesson_4;
import java.util.Random;
import java.util.Scanner;
//**************************Крестики-нолики в процедурном стиле**************************//
/**
 * -проверка разбивает массив 5х5 на подмассивы 4х4 и проверяет их, т.е. проверяет
 * не только основные диагонали, а вообще - все...
 * ии научил только блокировать при больше 3х,
 * думаю можно за недельку и красивый ии сделать, пока не знаю как лучше...
 * */
public class TicTacToe {
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
//1
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
//2
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
    public static boolean checkDiagonal(char symb, int shuffle_x, int shuffle_y) {
        boolean to_right, to_left;
        to_right = true;
        to_left = true;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            to_right &= (map[i + shuffle_x][i + shuffle_y] == symb);
            to_left &= (map[DOTS_TO_WIN+shuffle_y-i-1][i+shuffle_x] == symb);
        }
        if (to_right || to_left) return true;
        return  false;
    }
    public static boolean checkLines (char symb, int shuffle_x, int shuffle_y) {
        boolean cols, rows;
        for (int col = shuffle_x; col < DOTS_TO_WIN + shuffle_x; col++) {//col/row
            cols = true;
            rows = true;
            for (int row = shuffle_y; row < DOTS_TO_WIN + shuffle_y; row++) {
                cols &= (map[col][row] == symb);
                rows &= (map[row][col] == symb);
            }
            if (cols || rows) return true;
        }
        return false;
    }
    public static boolean checkWin(char symb){
        for (int col = 0; col <= SIZE - DOTS_TO_WIN; col++) {// factor = 1 - for 5x5
            for (int row = 0; row <= SIZE - DOTS_TO_WIN; row++) {
                if (checkDiagonal(symb, col, row) || checkLines(symb, col, row)) return true;
            }
        }
        return false;
    }



}


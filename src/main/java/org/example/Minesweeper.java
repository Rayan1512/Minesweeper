package org.example;

import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    private final int[][] tile;
    private final boolean[][] revealed;
    private final int size;
    private final int mines;
    private boolean gameOver;
    private int remaining;

    public Minesweeper(int size, int mines) {
        this.size = size;
        this.mines = mines;
        tile = new int[size][size];
        revealed = new boolean[size][size];
        gameOver = false;
        remaining = size * size - mines;
        generateField();
    }

    private void generateField() {
        Random rand = new Random();
        int count = 0;
        while (count < mines) {
            int x = rand.nextInt(size);
            int y = rand.nextInt(size);
            if (tile[x][y] != -1) {
                tile[x][y] = -1;
                count++;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tile[i][j] != -1) {
                    tile[i][j] = adjacency(i, j);
                }
            }
        }
    }

    private int adjacency(int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if (nx >= 0 && nx < size && ny >= 0 && ny < size && tile[nx][ny] == -1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void printField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (revealed[i][j]) {
                    if (tile[i][j] == -1) {
                        System.out.print("* ");
                    } else {
                        System.out.print(tile[i][j] + " ");
                    }
                } else {
                    System.out.print("[] ");
                }
            }
            System.out.println();
        }
    }

    public void reveal(int x, int y) {
        if (gameOver || revealed[x][y]) {
            return;
        }

        revealed[x][y] = true;
        remaining--;

        if (tile[x][y] == -1) {
            gameOver = true;
            System.out.println("Game Over!");
        } else if (tile[x][y] == 0) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int nx = x + i;
                    int ny = y + j;
                    if (nx >= 0 && nx < size && ny >= 0 && ny < size) {
                        reveal(nx, ny);
                    }
                }
            }
        }

        if (remaining == 0) {
            gameOver = true;
            System.out.println("You Win!");
            System.out.println("\n" +
                    " ___ ___  ____  ____     ___  _____ __    __    ___    ___  ____   ___  ____  \n" +
                    "|   |   ||    ||    \\   /  _]/ ___/|  |__|  |  /  _]  /  _]|    \\ /  _]|    \\ \n" +
                    "| _   _ | |  | |  _  | /  [_(   \\_ |  |  |  | /  [_  /  [_ |  o  )  [_ |  D  )\n" +
                    "|  \\_/  | |  | |  |  ||    _]\\__  ||  |  |  ||    _]|    _]|   _/    _]|    / \n" +
                    "|   |   | |  | |  |  ||   [_ /  \\ ||  `  '  ||   [_ |   [_ |  | |   [_ |    \\ \n" +
                    "|   |   | |  | |  |  ||     |\\    | \\      / |     ||     ||  | |     ||  .  \\\n" +
                    "|___|___||____||__|__||_____| \\___|  \\_/\\_/  |_____||_____||__| |_____||__|\\_|\n" +
                    "                                                                              ");
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);


        System.out.print("Enter the size of the field: ");
        int size = getPositiveInt(reader);
        System.out.print("Enter the number of mines: ");
        int mines = getPositiveInt(reader);

        Minesweeper minesweeper = new Minesweeper(size, mines);

        while (!minesweeper.gameOver) {
            minesweeper.printField();
            System.out.print("Enter row and column numbers: ");
            int x = getPositiveInt(reader);
            int y = getPositiveInt(reader);
            minesweeper.reveal(x, y);
        }

        minesweeper.printField();
        reader.close();

    }
        public static int getPositiveInt(Scanner reader){
            int value;
            while (true) {
                while (!reader.hasNextInt()) {
                    System.out.println("That's not a number!");
                    reader.next();
                }
                value = reader.nextInt();
                if (value <= 0) {
                    System.out.println("Please enter a positive number");
                } else {
                    break;
                }
            }
            return value;
    }
}




package org.example;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
public class minesweeper {
    public static final int Size = 10;
    public static final int Mines = 10;

    public char[][] board;
    public boolean[][] mines;
    public boolean[][] revealed;

    public minesweeper() {
        board = new char[Size][Size];
        mines = new boolean[Size][Size];
        revealed = new boolean[Size][Size];
        initialiseBoard();
        mineSelect();

    }

    public void initializeBoard() {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                board[i][j] = '-';
            }
        }
    }


    public void placeMines() {
        for (int i = 0; i < Mines; i++) {
            int row, col;
            do {
                row = (int) (Math.random() * Size);
                col = (int) (Math.random() * Size);
            } while (mines[row][col]);

            mines[row][col] = true;
        }


        public static void displayBoard () {
            for (int i = 0; i < Size; i++) {
                for (int j = 0; j < Size; j++) {
                    if (revealed[i][j]) {
                        System.out.print(board[i][j] + " ");
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }


        }

    }
}
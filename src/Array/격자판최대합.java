package Array;

import java.util.Scanner;

// README.md 참고
/*
9. 격자판 최대합

[예시 입력]
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

[예시 출력]
155
 */
public class 격자판최대합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[][] board = new int[size][size];

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = sc.nextInt();

        int max = 0;
        int diagonalScore = 0; //대각선
        int reDiagonalScore = 0; //역대각선

        for (int i = 0; i < size; i++) {
            int rowScore = 0; // 가로 합
            int colScore = 0; // 세로 합

            for (int j = 0; j < size; j++) {
                rowScore += board[i][j];
                colScore += board[j][i];
            }

            diagonalScore += board[i][i];
            reDiagonalScore += board[i][size-1-i];

            max = Math.max(Math.max(max, rowScore), colScore);
        }

        max = Math.max(Math.max(diagonalScore, reDiagonalScore), max);
        System.out.println(max);
    }
}

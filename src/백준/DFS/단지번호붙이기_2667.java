package 백준.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 단지번호붙이기_2667 {
    static int N, cnt, tmpCnt;
    static int[] disX = {-1, 0, 1, 0};
    static int[] disY = {0, 1, 0, -1};
    static List<Integer> houseCnt = new ArrayList<>();
    static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //지도의 크기(가로 세로 동일)
        board = new int[N][N];

        //보드판 입력
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == '0') board[i][j] = 0;
                else board[i][j] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    cnt++; //단지수 증가
                    tmpCnt = 1;
                    DFS(i, j);
                    houseCnt.add(tmpCnt);
                }
            }
        }

        Collections.sort(houseCnt);

        System.out.println(cnt);
        for (Integer i : houseCnt) {
            System.out.println(i);
        }
    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < disX.length; i++) {
            int afterX = x + disX[i];
            int afterY = y + disY[i];

            if (afterX >= 0 && afterY >= 0 && afterX < N && afterY < N && board[afterX][afterY] == 1) {
                tmpCnt++;
                board[afterX][afterY] = 0;
                DFS(afterX, afterY);
            }
        }
    }
}

package 백준.DFS;

import java.util.Scanner;

public class 유기농배추_1012 {
    static int[] disX = {-1, 0, 1, 0};
    static int[] disY = {0, 1, 0, -1};
    static int[][] board;
    static int M, N, K ,cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); //테스트 케이스의 개수

        for (int i = 0; i < T; i++) {
            M = sc.nextInt(); //가로 길이
            N = sc.nextInt(); //세로 길이
            K = sc.nextInt(); //배추가 심어져 있는 개수
            board = new int[M][N];
            cnt = 0;

            //배추 입력
            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                board[x][y] = 1;
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (board[x][y] == 1) {
                        board[x][y] = 0;
                        cnt++;
                        DFS(x, y);
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < disX.length; i++) {
            int afterX = x + disX[i];
            int afterY = y + disY[i];
            if (afterX >= 0 && afterY >= 0 && afterX < M && afterY < N && board[afterX][afterY] == 1) {
                board[afterX][afterY] = 0;
                DFS(afterX, afterY);
            }
        }
    }
}

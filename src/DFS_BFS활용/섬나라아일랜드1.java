package DFS_BFS활용;

import java.util.Scanner;

/*
//README.md 참고..

13. 섬나라 아일랜드(DFS)

[입력]
첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
두 번째 줄부터 격자판 정보가 주어진다.

[출력]
첫 번째 줄에 섬의 개수를 출력한다.

[예시 입력]
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

[예시 출력]
5
 */
public class 섬나라아일랜드1 {
    static int N, count = 0;
    static int[][] board;
    static int[] disX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] disY = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    DFS(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void DFS(int x, int y) {
        for (int i = 0; i < disX.length; i++) {
            int afterX = x + disX[i];
            int afterY = y + disY[i];

            if (afterX >= 0 && afterY >= 0 && afterX < N && afterY < N && board[afterX][afterY] == 1) {
                board[afterX][afterY] = 0;
                DFS(afterX, afterY);
            }
        }
    }
}

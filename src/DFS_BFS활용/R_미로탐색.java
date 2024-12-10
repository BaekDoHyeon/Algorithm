package DFS_BFS활용;

import java.util.Scanner;

/*
10. 미로 탐색(DFS)

7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.

출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.

격자판의 움직임은 상하좌우로만 움직인다.

[입력]
7*7 격자판의 정보가 주어집니다.

[출력]
첫 번째 줄에 경로의 가지수를 출력한다.

[예시 입력]
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0

[예시 출력]
8
 */
public class R_미로탐색 {
    static int[][] board;
    static int result = 0;
    static int[] disX = {-1, 0, 1, 0};
    static int[] disY = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[8][8];
        for (int i = 1; i < board.length; i++)
            for (int j = 1; j < board[0].length; j++)
                board[i][j] = sc.nextInt();

        board[1][1] = 1;
        DFS(1, 1);
        System.out.println(result);
    }

    public static void DFS(int x, int y) {
        if (x == 7 && y == 7) result++;
        else {
            for (int i = 0; i < disX.length; i++) {
                int afterX = x + disX[i];
                int afterY = y + disY[i];
                if (afterX > 0 && afterY > 0 && afterX < 8 && afterY < 8 && board[afterX][afterY] == 0) {
                    board[afterX][afterY] = 1;
                    DFS(afterX, afterY);
                    board[afterX][afterY] = 0;
                }
            }
        }
    }
}

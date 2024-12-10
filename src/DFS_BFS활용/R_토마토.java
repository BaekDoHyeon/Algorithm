package DFS_BFS활용;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
// README.md 참고...

12. 토마토 (BFS 활용)

[입력]
첫 줄에는 상자의 크기를 나타내는 두 정수 M, N이 주어진다. M은 상자의 가로 칸의 수,
N 은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M, N ≤ 1,000 이다
둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

[출력]
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다.
만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.

[예시 입력]
6 4
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1

[예시 출력]
4
 */
class Pos2 {
    int x;
    int y;

    Pos2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class R_토마토 {
    static int N, M;
    static int[][] board, dis;
    static Queue<Pos2> queue = new LinkedList<>();
    static int[] disX = {-1, 0, 1, 0};
    static int[] disY = {0, 1, 0, -1};
    static int result = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[N][M];
        dis = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) queue.add(new Pos2(i, j));
            }
        }

        BFS();
        boolean flag = false; //안익은 토마토가 존재 한다면 true.. 토마토가 전부 익었다면 false..
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (board[i][j] == 0) flag = true;


        if (!flag)
            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    result = Math.max(result, dis[i][j]);

        System.out.println(result);
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pos2 cur = queue.poll();
                for (int j = 0; j < disX.length; j++) {
                    int afterX = cur.x + disX[j];
                    int afterY = cur.y + disY[j];
                    if (afterX >= 0 && afterY >= 0 && afterX < N && afterY < M && board[afterX][afterY] == 0) {
                        dis[afterX][afterY] = dis[cur.x][cur.y] + 1;
                        board[afterX][afterY] = 1;
                        queue.add(new Pos2(afterX, afterY));
                    }
                }
            }
        }
    }
}

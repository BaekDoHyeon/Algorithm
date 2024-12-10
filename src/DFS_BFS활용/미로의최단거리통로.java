package DFS_BFS활용;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
11. 미로의 최단거리 통로(BFS)

[설명]
7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
격자판의 움직임은 상하좌우로만 움직인다.

[입력]
첫 번째 줄부터 7*7 격자의 정보가 주어집니다.

[출력]
첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.

[예시 입력]
0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 1 0 0 0
1 0 0 0 1 0 0
1 0 1 0 0 0 0

[예시 출력]
12
 */
class Pos {
    int x;
    int y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 미로의최단거리통로 {
    static int[][] board = new int[8][8];
    static int[][] ch = new int[8][8];
    static int minValue = -1;
    static int[] disX = {-1, 0, 1, 0};
    static int[] disY = {0, 1, 0, -1};
    static Queue<Pos> queue = new LinkedList<>();
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i < 8; i++)
            for (int j = 1; j < 8; j++)
                board[i][j] = sc.nextInt();

        ch[1][1] = 1;
        board[1][1] = 1;
        queue.add(new Pos(1, 1));
        BFS(1, 1);
        System.out.println(minValue);
    }

    public static void BFS(int x, int y) {
        int L = 1;

        while (!queue.isEmpty() && !flag) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pos cur = queue.poll();

                for (int j = 0; j < disX.length; j++) {
                    int afterX = cur.x + disX[j];
                    int afterY = cur.y + disY[j];
                    if (afterX == 7 && afterY == 7) {
                        minValue = L;
                        flag = true;
                        break;
                    }

                    if (afterX > 0 && afterY > 0 && afterX < 8 && afterY < 8 && board[afterX][afterY] == 0) {
                        ch[afterX][afterY] = L;
                        board[afterX][afterY] = 1;
                        queue.add(new Pos(afterX, afterY));
                    }
                }
            }
            L++;
        }
    }
}

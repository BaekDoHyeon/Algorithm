package DFS_BFS활용;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
//README.md 참고..

14. 섬나라 아일랜드(BFS)

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
class Pos3 {
    int x;
    int y;
    Pos3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class 섬나라아일랜드2 {
    static int N, count = 0;
    static int[][] board;
    static int[] disX = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] disY = {0, 1, 1, 1, 0, -1, -1, -1};
    static Queue<Pos3> queue = new LinkedList<>();
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
                    queue.add(new Pos3(i, j));
                    board[i][j] = 0;
                    BFS();
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Pos3 cur = queue.poll();

                for (int j = 0; j < disX.length; j++) {
                    int afterX = cur.x + disX[j];
                    int afterY = cur.y + disY[j];

                    if (afterX >= 0 && afterY >= 0 && afterX < N && afterY < N && board[afterX][afterY] == 1) {
                        queue.add(new Pos3(afterX, afterY));
                        board[afterX][afterY] = 0;
                    }
                }
            }
        }
    }
}

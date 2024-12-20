package 백준.DFS;

import java.util.*;

public class DFS와BFS_1260 {
    static int N, M, V;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        board = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            board[a][b] = 1;
            board[b][a] = 1;
        }

        int[] ch = new int[N+1];
        ch[V] = 1; // V부터 시작할 것이기 때문 V 값은 1로 체크해준다.
        DFS(V, ch);
        sb.append("\n");
        ch = new int[N+1];
        ch[V] = 1; // V부터 시작할 것이기 때문 V 값은 1로 체크해준다.
        BFS(V, ch);
        System.out.println(sb);
    }

    public static void DFS(int startNum, int[] ch) {
        sb.append(startNum).append(" ");
        for (int i = 1; i < N+1; i++) {
            if (board[startNum][i] == 1&& ch[i] == 0) { //현재 숫자에서 다음 숫자로 이동할 수 있으면서 아직 이동하지 않은 숫자라면...
                ch[i] = 1;
                DFS(i, ch);
            }
        }
    }

    public static void BFS(int startNum, int[] ch) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNum);
        sb.append(startNum).append(" ");

        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 1; i < N+1; i++) {
                if (board[tmp][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    queue.add(i);
                    sb.append(i).append(" ");
                }
            }
        }
    }
}

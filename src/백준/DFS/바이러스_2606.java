package 백준.DFS;

import java.util.Scanner;

public class 바이러스_2606 {
    static int N, M, cnt;
    static int[] ch;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt(); //간선의 개수
        ch = new int[N+1];
        graph = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        ch[1] = 1;
        DFS(1);
        System.out.println(cnt);
    }

    public static void DFS(int startNum) {
        for (int i = 2; i <= N; i++) {
            if (graph[startNum][i] == 1 && ch[i] == 0) {
                cnt++;
                ch[i] = 1;
                DFS(i);
            }
        }
    }
}

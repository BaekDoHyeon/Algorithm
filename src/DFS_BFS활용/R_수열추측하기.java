package DFS_BFS활용;

import java.util.Scanner;

/*
8. 수열 추측하기

[입력]
첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.

[출력]
첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
답이 존재하지 않는 경우는 입력으로 주어지지 않는다.

[예시 입력]
4 16

[예시 출력]
3 1 2 4
 */
public class R_수열추측하기 {
    static int N, F;
    static int[] pm, b, ch;
    static int[][] combiCh;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        F = sc.nextInt();
        pm = new int[N];
        b = new int[N];
        ch = new int[N+1];
        combiCh = new int[N+1][N+1];
        for (int i = 0; i < N; i++)
            b[i] = combination(N-1, i);
        int sum = 0;
        DFS(0, sum);
    }

    private static void DFS(int L, int sum) {
        if (flag) return;

        if (L == N && sum == F) {
            for (int i : pm) System.out.print(i + " ");
            flag = true;
        } else {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0) {
                    pm[L] = i;
                    ch[i] = 1;
                    DFS(L+1, sum + (b[L] * pm[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    private static int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        else {
            if (combiCh[n][r] != 0) return combiCh[n][r];
            else return combiCh[n][r] = combination(n-1, r-1) + combination(n-1, r);
        }
    }
}

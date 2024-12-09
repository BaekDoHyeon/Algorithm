package DFS_BFS활용;

import java.util.Scanner;

/*
7. 조합의 경우수(메모이제이션)

[입력]
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.

[출력]
첫째 줄에 조합수를 출력합니다.

[예시 입력1]
5 3

[예시 출력1]
10

[예시 입력2]
33 19

[예시 출력2]
818809200
 */
public class R_조합의경우의수 {
    static int[][] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        ch = new int[n+1][r+1];

        System.out.println(DFS(n, r));
    }

    public static int DFS(int n, int r) {
        int result = 0;

        if (n == r || r == 0) return 1;
        if (ch[n][r] != 0) return ch[n][r];

        result = DFS(n-1, r-1) + DFS(n-1, r);
        ch[n][r] = result;

        return result;
    }
}

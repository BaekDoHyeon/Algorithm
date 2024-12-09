package DFS_BFS활용;

import java.util.Scanner;

/*
5. 동전교환
[설명]
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.

[입력]
첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.

[출력]
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.

[예시 입력]
3
1 2 5
15

[예시 출력]
3

[힌트]
출력 설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다.
 */
public class 동전교환 {
    static int N, M, minCnt = Integer.MAX_VALUE;
    static int[] coins;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        coins = new int[N];
        for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
        M = sc.nextInt();

        int sum = 0;
        DFS(0, sum);
        System.out.println(minCnt);
    }

    public static void DFS(int cnt, int sum) {
        if (sum > M || cnt > minCnt) return;

        if (sum == M) minCnt = cnt;
        else {
            for (int i = N-1; i >= 0; i--) {
                DFS(cnt + 1, sum + coins[i]);
            }
        }
    }
}

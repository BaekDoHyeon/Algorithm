package DFS_BFS활용;

import java.util.Scanner;

/*
6. 순열 구하기(채점 지원 X)

10개 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.

[입력 설명]
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.

[출력 설명]
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

[입력 예제]
3 2
3 6 9

[출력 예제]
3 6
3 9
6 3
9 3
9 6
 */
public class R_순열구하기 {
    static int N, M;
    static int[] arr, pm, ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        ch = new int[N];
        pm = new int[M];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        DFS(0);
    }

    public static void DFS(int L) {
        if (L == M) {
            for (int i = 0; i < M; i++) System.out.print(pm[i] + " ");
            System.out.println();
        } else {
            for (int i = 0; i < N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L+1);
                    ch[i] = 0;
                }
            }
        }
    }
}

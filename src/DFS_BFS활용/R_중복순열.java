package DFS_BFS활용;

import java.util.Scanner;

/*
4. 중복순열 구하기(채점 지원X)

1부터 N까지 번호가 적히 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.

[입력 설명]
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.

[출력 설명]
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

[입력 예제]
3 2

[출력 예제]
1 1
1 2
1 3
2 1
2 2
2 3
3 1
3 2
3 3
 */
public class R_중복순열 {

    static int N, M;
    static int[] pm;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        pm = new int[M];

        DFS(0);
    }

    public static void DFS(int L) {
        if (L == M) {
            for (int i = 0; i < L; i++) System.out.print(pm[i] + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }
}

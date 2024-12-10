package DFS_BFS활용;

import java.util.Scanner;

/*
9. 조합 구하기(채점 지원X)

1부터 N까지 번호가 적인 구슬이 있습니다. 이 중 M개를 뽑는 방법의 수를 출력하는 프로그램을 작성하세요.

[입력 설명]
첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.

[출력 설명]
첫 번째 줄에 결과를 출력합니다.
출력순서는 사전순으로 오름차순으로 출력합니다.

[입력 예제]
4 2

[출력 예제]
1 2
1 3
1 4
2 3
2 4
3 4
 */
public class R_조합구하기 {
    static int N, M;
    static int[] pm;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        pm = new int[M];
        DFS(0, 1);
    }

    public static void DFS(int L, int n) {
        if (L == M) {
            for (int i : pm) System.out.print(i + " ");
            System.out.println();
        } else {
            for (int i = n; i <= N; i++) {
                pm[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
}

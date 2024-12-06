package Recursive_Tree_Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
6. 부분집합 구하기(DFS)

자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.

[입력 설명]
첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.

[출력 설명]
첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
단 공집합은 출력하지 않습니다.

[입력 예제]
3

[출력 예제]
1 2 3
1 2
1 3
1
2 3
2
3
 */
public class R_부분집합구하기 {

    static int N;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        ch = new int[N+1];

        DFS(1);
    }

    public static void DFS(int L) {
        if (L > N) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= N; i++)
                if (ch[i] == 1) list.add(i);

            if (!list.isEmpty()) {
                for (Integer i : list)
                    System.out.print(i + " ");
                System.out.println();
            }
        } else {
            ch[L] = 1;
            DFS(L+1);
            ch[L] = 0;
            DFS(L+1);
        }
    }
}

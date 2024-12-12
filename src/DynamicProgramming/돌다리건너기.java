package DynamicProgramming;

import java.util.Scanner;

/*
2. 돌다리 건너기

[설명]
철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
철수가 개울을 건너는 방법은 몇 가지일까요?

[입력]
첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.

[출력]
첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.

[예시 입력]
7

[예시 출력]
34
 */
public class 돌다리건너기 {
    static int N, cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        DFS(0);
        System.out.println(cnt);
    }

    public static void DFS(int sum) {
        if (sum >= N) cnt++;
        else {
            for (int i = 1; i < 3; i++) {
                sum += i;
                DFS(sum);
                sum -= i;
            }
        }
    }
}

package DynamicProgramming;

import java.util.Scanner;

/*
1. 계단오르기

[설명]
철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.

[입력]
첫째 줄은 계단의 개수인 자연수 N(3≤N≤35)이 주어집니다.

[출력]
첫 번째 줄에 올라가는 방법의 수를 출력합니다.

[예시 입력]
7

[예시 출력]
21
 */
public class 계단오르기 {
    static int N, cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        DFS(0);

        System.out.println(cnt);
    }

    public static void DFS(int sum) {
        if (sum > N) return;

        if (sum == N) cnt++;
        else {
            for (int i = 1; i < 3; i++) {
                sum+=i;
                DFS(sum);
                sum-=i;
            }
        }
    }
}

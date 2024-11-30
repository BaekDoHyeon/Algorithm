package TwoPointers_SlidingWindow;

import java.util.Scanner;

/*
5. 연속된 자연수의 합

[설명]
N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
만약 N=15이면
7+8=15
4+5+6=15
1+2+3+4+5=15
와 같이 총 3가지의 경우가 존재한다.

[입력]
첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.

[출력]
첫 줄에 총 경우수를 출력합니다.

[예시 입력]
15

[예시 출력]
3
 */
public class R_연속된자연수의합 {
    public static void main(String[] args) {

        // 문제 풀이 1 => 투 포인터로 문제 풀이
        /*
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i+1;

        int cnt = 0, sum = 0, lt = 0;

        for (int rt = 0; rt < n/2 + 1; rt++) {
            sum += arr[rt];
            if (sum == n) cnt++;

            while (sum >= n) {
                sum -= arr[lt++];

                if (sum == n) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
        */

        //문제 풀이 2 => 수학 관점으로 문제 풀이 해보기..
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0, cnt = 1;
        n--;

        while (n > 0) {
            cnt++;
            n = n - cnt;
            if (n % cnt == 0) result++;
        }

        System.out.println(result);
    }
}

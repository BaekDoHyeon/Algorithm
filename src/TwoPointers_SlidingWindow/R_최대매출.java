package TwoPointers_SlidingWindow;

import java.util.Scanner;

/*
3. 최대 매출(슬라이딩 윈도우 기법)

[설명]
현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
12 15 11 20 25 10 20 19 13 15
연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
여러분이 현수를 도와주세요.

[입력]
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.

[출력]
첫 줄에 최대 매출액을 출력합니다.

[예시 입력]
10 3
12 15 11 20 25 10 20 19 13 15

[예시 출력]
56
 */
public class R_최대매출 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int result = 0;

        for (int i = 0; i < k; i++) result += arr[i]; //초기값 세팅

        int sum = result;

        for (int i = k; i < n; i++) {
            sum += (arr[i] - arr[i-k]);
            result = Math.max(result, sum);
        }

        System.out.println(result);
    }
}

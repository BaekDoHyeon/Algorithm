package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*
5. 동전교환(냅색 알고리즘)
=> 냅색 알고리즘은 한정된 용량의 가방(배낭)에 최대한 가치 있는 물건을 담는 방법을 찾는 문제를 해결해요.


[설명]
다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
각 단위의 동전은 무한정 쓸 수 있다.

[입력]
첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.
두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.
각 동전의 종류는 100원을 넘지 않는다.

[출력]
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.

[예시 입력1]
3
1 2 5
15

[예시 출력1]
3

[예시 입력2]
5
1 8 20 25 50
129

[예시 출력2]
5

[힌트]
출력설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다.
 */
public class R_동전교환 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= m; j++)
                arr[j] = Math.min(arr[j], arr[j-coins[i]] + 1);

        System.out.println(arr[m]);
    }
}

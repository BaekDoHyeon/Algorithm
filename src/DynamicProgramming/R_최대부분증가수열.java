package DynamicProgramming;

import java.util.Scanner;

/*
3. 최대 부분 증가수열(LIS)

[설명]
N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.
예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어
길이가 5인 최대 부분 증가수열을 만들 수 있다.

[입력]
첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고,
둘째 줄은 N개의 입력데이터들이 주어진다.

[출력]
첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.

[예시 입력1]
8
5 3 7 8 6 2 9 4

[예시 출력1]
4

[예시 입력2]
11
5 2 18 3 4 7 10 9 11 8 15

[예시 출력2]
7
 */
public class R_최대부분증가수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dy = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int maxLen = 0;
        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            int dyMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dy[j] > dyMax) dyMax = dy[j];
            }
            dy[i] = dyMax + 1;
            maxLen = Math.max(dy[i], maxLen);
        }

        System.out.println(maxLen);
    }
}

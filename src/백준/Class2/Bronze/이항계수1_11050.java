package 백준.Class2.Bronze;

import java.util.Scanner;

// 이항계수란 주어진 집합에서 원하는 개수만큼 순서없이 뽑는 조합의 개수를 의미한다. => 중복으로는 못 뽑는듯..
public class 이항계수1_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int result = DFS(N, K);
        System.out.println(result);
    }

    public static int DFS(int n, int k) {
        if (n == k || k == 0) return 1;
        else {
            return DFS(n-1, k-1) + DFS(n-1, k);
        }
    }
}

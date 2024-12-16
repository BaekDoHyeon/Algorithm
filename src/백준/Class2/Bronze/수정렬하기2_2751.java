package 백준.Class2.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 카운팅 정렬 + 절댓값 해결 문제
public class 수정렬하기2_2751 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sc.nextInt();
        int[] cnt = new int[2000001];

        for (int i = 0; i < N; i++) {
            cnt[sc.nextInt() + 1000000]++;
        }

        for (int i = 0; i < 2000001; i++) {
            if (cnt[i] != 0) sb.append(i - 1000000).append("\n");
        }

        System.out.println(sb);
    }
}

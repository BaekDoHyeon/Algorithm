package 백준.Class2.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 시간 초과...
public class 달팽이는올라가고싶다_2869 {
    public static void main(String[] args) throws IOException {
//        === 시간 초과 코드 ===
//        Scanner sc = new Scanner(System.in);
//        int A = sc.nextInt();
//        int B = sc.nextInt();
//        int V = sc.nextInt();
//        int sum = 0;
//        int day = 0;
//        while(true) {
//            sum += A;
//            day++;
//            if (sum >= V) break;
//            sum -= B;
//        }
//
//        System.out.println(day);
//        === 시간 초과 코드 ===

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) day++;

        System.out.println(day);
    }
}

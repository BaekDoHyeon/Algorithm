package 백준.Class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// '유클리드 호제법' 알고리즘 사용
// https://st-lab.tistory.com/154
public class 최대공약수와최소공배수_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = GCD(a, b);
        int lcm = a * b / gcd;

        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int GCD(int a, int b) {
        if (b == 0) return a;

        return GCD(b, a % b);
    }
}

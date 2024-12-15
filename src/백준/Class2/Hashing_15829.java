package 백준.Class2;

import java.io.IOException;
import java.util.Scanner;

// 매우 어렵다..
/*
    Math.pow 를 사용 하지 않고 pow 변수를 사용 하여 직접 31을 계속 곱해주는 이유는
    Math.pow() 는 double 타입 이므로 값이 커질 수록 실수를 표현하는 데 제한이 생기기 때문이다.
 */
public class Hashing_15829 {
    final static long M = 1234567891;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int L = sc.nextInt();
        String str = sc.next();
        long result = 0;
        long pow = 1;
        for (int i = 0; i < L; i++) {
            result += ((str.charAt(i) - 96) * pow);
            pow = (pow * 31) % M;
        }

        System.out.println(result % M);
    }
}

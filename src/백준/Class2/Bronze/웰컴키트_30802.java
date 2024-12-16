package 백준.Class2.Bronze;

import java.util.Scanner;

public class 웰컴키트_30802 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt(); //23
        int[] tShirts = new int[6];
        for (int i = 0; i < tShirts.length; i++)
            tShirts[i] = sc.nextInt();
        double T = sc.nextDouble(); //5
        double P = sc.nextDouble(); //7

        //티셔츠 묶음 구하기.
        int tShirtsBundleCnt = 0;
        for (int tShirt : tShirts) tShirtsBundleCnt += (int) Math.ceil(tShirt/T);
        sb.append(tShirtsBundleCnt).append("\n");

        //펜 최대 묶음과 몇 자루 주문 구하기.
        sb.append((int) (N/P)).append(" ");
        sb.append((int) (N%P)).append(" ");

        System.out.println(sb);
    }
}

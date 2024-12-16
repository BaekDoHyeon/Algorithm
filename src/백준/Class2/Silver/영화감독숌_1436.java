package 백준.Class2.Silver;

import java.util.Scanner;

//브루트포스 알고리즘 사용하여 풀이...
public class 영화감독숌_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int num = 666;
        int cnt = 1;

        while (cnt != N) {
            num++;
            if (String.valueOf(num).contains("666"))
                cnt++;
        }

        System.out.println(num);
    }
}

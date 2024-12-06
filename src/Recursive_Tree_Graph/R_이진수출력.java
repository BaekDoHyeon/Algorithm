package Recursive_Tree_Graph;

import java.util.Scanner;

/*
2, 재귀함수를 이용한 이진수 출력

10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.
단, 재귀함수를 이용해서 출력해야 합니다.

[입력 설명]
첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.

[출력 설명]
첫 번째 줄에 이진수를 출력하세요.

[입력 예제]
11

[출력 예제]
1011

 */
public class R_이진수출력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        recursive(n);
    }

    public static void recursive(int n) {
        if (n == 0) return;
        else {
            recursive(n/2);
            System.out.print(n%2);
        }
    }
}

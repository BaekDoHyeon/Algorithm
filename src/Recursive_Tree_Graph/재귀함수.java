package Recursive_Tree_Graph;

import java.util.Scanner;

/*
1. 재귀함수(스택프레임)

자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.

[입력설명]
첫 번째 줄은 정수 (3<=N<=10)이 입력된다.

[출력설명]
첫째 줄에 출력한다.

[입력예제]
3

[출력예제]
1 2 3
 */
public class 재귀함수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        recursive(n);
    }

    public static void recursive(int n) {
        if (n != 1)
            recursive(n-1);

        System.out.print(n + " ");
    }
}

package Recursive_Tree_Graph;

import java.util.Scanner;

/*
3. 팩토리얼

자연수 N이 입력되면 N!를 구하는 프로그램을 작성하세요.
예를 들어 5! = 5*4*3*2*1 = 120 입니다.

[입력 설명]
첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

[출력 설명]
첫 번째 줄에 N 팩토리얼 값을 출력합니다.

[입력 예제]
5

[출력 예제]
120
 */
public class 팩토리얼 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(recursive(n));
    }

    public static int recursive(int n) {
        if (n == 1) return 1;
        else return  n * recursive(n-1);
    }
}

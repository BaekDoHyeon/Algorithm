package Array;

import java.util.Scanner;

// 3. 가위 바위 보
// README.md 참고
// 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보
/*
[예시 입력]
5
2 3 3 1 3
1 1 2 2 3

[예시 출력]
A
B
A
B
D
 */
public class 가위바위보 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();

        int[] a = new int[cnt];
        int[] b = new int[cnt];

        //a의 정보 입력
        for (int i = 0; i < cnt; i++)
            a[i] = sc.nextInt();

        //b의 정보 입력
        for (int i = 0; i < cnt; i++)
            b[i] = sc.nextInt();

        for (int i = 0; i < cnt; i++) {

            // 문제 풀이 1. -> 내가 혼자 푼 풀이.
            /*
            if (a[i] == 1) {
                if (b[i] == 2) System.out.println("B");
                else if (b[i] == 3) System.out.println("A");
                else System.out.println("D");
            } else if (a[i] == 2) {
                if (b[i] == 2) System.out.println("D");
                else if (b[i] == 3) System.out.println("B");
                else System.out.println("A");
            } else {
                if (b[i] == 2) System.out.println("A");
                else if (b[i] == 3) System.out.println("D");
                else System.out.println("B");
            }
            */

            //문제 풀이 2. -> A가 이기는 상황면 else if 문제 작성하여 코드 수 줄이기
            if (a[i] == b[i]) System.out.println("D");
            else if (a[i] == 1 && b[i] == 3) System.out.println("A");
            else if (a[i] == 2 && b[i] == 1) System.out.println("A");
            else if (a[i] == 3 && b[i] == 2) System.out.println("A");
            else System.out.println("B");
        }
    }
}

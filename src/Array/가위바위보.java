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
        }
    }
}

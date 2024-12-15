package 백준.Class2;

import java.util.Scanner;

/*
[예제 입력]
216

[예제 출력]
198
 */
public class 분해합_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sNum = sc.next();
        int N = Integer.parseInt(sNum);
        int result = 0;

        for (int i = N-(sNum.length()*9); i < N; i++) {
            int num = i;
            int sum = 0; //각 자리 수의 합

            while(num > 0) { //num 의 각 자리 수의 합을 sum 에 더한다.
                sum += num % 10;
                num /= 10;
            }

            if ((i + sum) == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}

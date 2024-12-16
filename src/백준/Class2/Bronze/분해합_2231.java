package 백준.Class2.Bronze;

import java.util.Scanner;

/*
// 브루트포스 알고리즘
=> 브루트포스(Brute Force) 알고리즘은 문제를 해결하기 위해 가능한 모든 경우의 수를 탐색하는 기법입니다. 가장 단순하고 직관적인 방법이지만, 효율성은 낮을 수 있습니다.

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

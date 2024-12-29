package 코딩테스트;

import java.util.Scanner;

/*
문제 #3. 소수의 합
양의 정수인 a값이 주어질 때 1부터 a값 이하에 존재하는 모든 소수의 합을 리턴하는 solution 함수를 작성해주세요.

🚩 [제한사항]
- 소수란 1과 자기 자신으로만 나눠지는 수 입니다. ( 1인 소수가 아닙니다. ) - a는 최소 4부터 주어집니다.

🚩 [입출력 예]
a : 5 → 10
a : 10 → 17
a : 30 → 129
 */
public class Coding3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        System.out.println(solution(a));
    }

    //소수 판별 메소드
    // 소수 판별 시, n을 검사할 때 2부터 n의 제곱근 까지만 확인 해도 되기 때문에, Math.sqrt()를 흔히 사용 한다.
    static boolean isPrime(int n) {
        if (n < 2) return false;
        int limit = (int) Math.sqrt(n);
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    static int solution(int a) {
        int sum = 0;
        for (int i = 2; i <= a; i++) {
            if (isPrime(i)) sum += i;
        }
        return sum;
    }
}

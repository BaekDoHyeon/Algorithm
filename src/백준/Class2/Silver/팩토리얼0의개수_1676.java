package 백준.Class2.Silver;

import java.util.Scanner;

/*
[문제 해결 방법]
N!에서 5의 배수의 개수를 세어야 한다.
5, 10, 15, 20, ... 처럼 5의 배수가 등장할 때마다 0이 하나 추가된다.
5의 제곱 배수인 25, 125, 625, ... 에서는 추가로 5가 더 곱해지므로, 그만큼 더 많은 0이 생성된다.

1. N을 5로 나눈다. N / 5는 5의 배수의 개수이다.
2. N을 5^2 = 25로 나눈다. N / 25는 5가 추가로 곱해지는 개수를 더해준다.
3. N을 5^3 = 125 , 5^4 = 625 로 나눈다. 5의 제곱 배수 이상의 영향도 고려한다.
4. 이 과정을 N / 5^k 가 0이 될 때까지 반복한다.
 */
public class 팩토리얼0의개수_1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int zeroCnt = 0;

        for (int i = 5; i <= n; i *= 5)
            zeroCnt += n / i;

        System.out.println(zeroCnt);
    }
}

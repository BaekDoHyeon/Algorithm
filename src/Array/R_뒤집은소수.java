package Array;

/*
6. 뒤집은 소수

[설명]
N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
첫 자리부터의 연속된 0은 무시한다.

[입력]
첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
각 자연수의 크기는 100,000를 넘지 않는다.

[출력]
첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.

[예시 입력]
9
32 55 62 20 250 370 200 30 100

[예시 출력]
23 2 73 2 3
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 숫자를 뒤집는 공식 외워두기!
public class R_뒤집은소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[] arr = new int[cnt];

        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        int[] reverseArr = new int[cnt];
        List<Integer> list = new ArrayList<>();

        //숫자 뒤집기
        for (int i = 0; i < arr.length; i++) {
            //일의자리 숫자, 십의자리 숫자, 백의자리 숫자순으로 빼내기
            int tmp = arr[i];
            int res = 0;
            while(tmp > 0) {         // 1)250일때..              2) 25일때..             3) 2일때...
                int t = tmp % 10;    //   t는 0                     t는 5                  t는 2
                res = res * 10 + t; //   0 * 10 + 0 = 0            0 * 10 + 5 = 5         5 * 10 + 2 = 52
                tmp = tmp/10;        //   tmp는 25                  tmp = 2                tmp = 0
            }

            reverseArr[i] = res;
        }

        //뒤집은 숫자가 소수인지 판별하기
        for(int num : reverseArr) {
            if(isPrime(num)) list.add(num);
        }

        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    private static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i < num; i++)
            if (num % i == 0) return false;

        return true;
    }
}

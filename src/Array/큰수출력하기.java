package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
1. 큰 수 출력하기

[설명]
N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
(첫 번째 수는 무조건 출력한다)

[입력]
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

[출력]
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

[예시 입력]
6
7 3 9 5 6 12

[예시 출력]
7 9 6 12
 */
public class 큰수출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[] nums = new int[cnt+1];
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.length; i++)
            nums[i] = sc.nextInt();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1])
                list.add(nums[i]);
        }

        for (Integer i : list)
            System.out.print(i + " ");

    }
}

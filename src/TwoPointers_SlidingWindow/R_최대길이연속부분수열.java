package TwoPointers_SlidingWindow;

import java.util.Scanner;

/*
11. 최대 길이 연속부분수열

[예시 입력]
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1

[예시 출력]
8
 */
public class R_최대길이연속부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int max = 0;
        int cnt = 0; //지금 까지의 1의 개수
        int chance = 0; //0을 1로 바꾼 횟수
        int lt =  0;

        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                if (chance < k) { //0을 1로 바꿀 수 있음
                    chance++;
                } else { //0을 1로 바꿀 수 없음
                    while (arr[lt] != 0) {
                        lt++;
                    } //0을 만나면 종료
                    lt++;
                }
            }

            cnt = rt - lt + 1;
            max = Math.max(max, cnt);
        }

        System.out.println(max);

    }
}

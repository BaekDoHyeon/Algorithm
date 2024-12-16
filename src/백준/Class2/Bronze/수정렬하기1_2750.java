package 백준.Class2.Bronze;

import java.util.Scanner;

//선택 정렬 사용하여 풀이..
public class 수정렬하기1_2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

        for (int i = 0; i < N-1; i++) {
            int tmp = arr[i];
            int minIdx = i;
            for (int j = i+1; j < N; j++) {
                if (tmp > arr[j]) {
                    tmp = arr[j];
                    minIdx = j;
                }
            }

            tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }

        for (int i : arr) System.out.print(i + " ");
    }
}

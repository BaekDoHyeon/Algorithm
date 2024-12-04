package SortingAndSearching;

import java.util.Scanner;

/*
//READEME.md 참고

4. Least Recently Used

[예시 입력]
5 9
1 2 3 2 6 2 3 5 7

[예시 출력]
7 5 3 2 6
 */
public class R_LRU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt(); //캐시의 크기
        int n = sc.nextInt(); //작업 번호의 처리순

        int[] cache = new int[s];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int pos = -1;
            for (int j = 0; j < s; j++) if (cache[j] == arr[i]) pos = j; //Hit 체크

            if (pos == -1) { //Cache Miss
                for (int j = s-1; j > 0; j--) {
                    cache[j] = cache[j-1];
                }
            } else { //Cache Hit
                for (int j = pos; j > 0; j--) {
                    cache[j] = cache[j-1];
                }
            }

            cache[0] = arr[i];
        }

        for (int i : cache)
            System.out.print(i + " ");
    }
}

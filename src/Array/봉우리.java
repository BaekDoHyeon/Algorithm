package Array;

import java.util.Scanner;

//README.md 참고
/*
10. 봉우리

[예시 입력]
5
5 3 7 2 3
3 7 1 6 1
7 2 5 3 4
4 3 6 4 1
8 7 3 5 2

[예시 출력]
10
 */
public class 봉우리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        int cnt = 0;

        int n = sc.nextInt();

        int[][] board = new int[n+2][n+2];

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++)
                board[i][j] = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                boolean isOK = true;

                for (int p = 0; p < x.length; p++) {
                    int afterX = i + x[p];
                    int afterY = j + y[p];

                    if (board[i][j] <= board[afterX][afterY]) {
                        isOK = false;
                        break;
                    }
                }

                if (isOK) cnt++;
            }
        }

        System.out.println(cnt);
    }
}

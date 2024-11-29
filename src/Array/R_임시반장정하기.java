package Array;

import java.util.Scanner;

/*
README.md 참고

11. 임시 반장 정하기

[예시 입력]
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2

[예시 출력]
4
 */
public class R_임시반장정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //학생 수
        int cnt = sc.nextInt();

        int max = 0;
        int maxStudent = 1;

        int[][] board = new int[cnt][5];
        int[] students = new int[cnt];
        int[][] check = new int[cnt][cnt];

        for (int i = 0; i < cnt; i++)
            for (int j = 0; j < 5; j++)
                board[i][j] = sc.nextInt();

        for (int i = 0; i < 5; i++) { // column(학년)
            for (int s = 0; s < cnt-1; s++) { //student(OO번 학생)
                for (int j = s+1; j < cnt; j++) { //row(s학생과 j학생을 비교)
                    if (board[s][i] == board[j][i]) {
                        if (check[s][j] == 0 ) {
                            check[s][j]++;
                            check[j][s]++;
                            students[s]++;
                            students[j]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] > max) {
                max = students[i];
                maxStudent = i+1;
            }
        }

        System.out.println(maxStudent);
    }
}

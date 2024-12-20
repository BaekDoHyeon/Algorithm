package Array;

import java.util.Scanner;

/*
12. 멘토링

[설명]
현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.

[입력]
첫 번째 줄에 반 학생 수 N(1<=N<=20)과 M(1<=M<=10)이 주어진다.
두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.

[출력]
첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.

[예시 입력]
4 3
3 4 1 2
4 3 2 1
3 1 4 2

[예시 출력]
3

[힌트]
출력설명
(3, 1), (3, 2), (4, 2)와 같이 3가지 경우의 (멘토, 멘티) 짝을 만들 수 있다.
 */
public class R_멘토링 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int studentCnt = sc.nextInt(); //학생수
        int cnt = sc.nextInt(); //횟수

        int[][] board = new int[cnt][studentCnt];
        int[][] students = new int[studentCnt+1][studentCnt+1]; // 0: 기본값, -1: 멘토가 될 수 없음, 1: 멘토가 될 수 있음

        for (int i = 0; i < cnt; i++)
            for (int j = 0; j < studentCnt; j++)
                board[i][j] = sc.nextInt();

        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < studentCnt-1; j++) {
                for (int n = j + 1; n < studentCnt; n++) {
                    if (students[board[i][j]][board[i][n]] != -1)  //멘토가 될 수 있다면...
                        students[board[i][j]][board[i][n]] = 1;

                    students[board[i][n]][board[i][j]] = -1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < studentCnt+1; i++) {
            for (int j = 0; j < studentCnt+1; j++) {
                if (students[i][j] == 1)
                    result++;
            }
        }

        System.out.println(result);
    }
}

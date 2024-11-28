package Array;

import java.util.Scanner;

// README.md 참고
// 7. 점수 계산
/*
[예시 입력]
10
1 0 1 1 1 0 0 1 1 0

[예시 출력]
10
 */
public class 점수계산 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int[] scoring = new int[cnt];
        int totalScore = 0;
        int bonusScore = 0;

        for (int i = 0; i < scoring.length; i++)
            scoring[i] = sc.nextInt();

        for (int s : scoring) {
            if (s == 1) {
                bonusScore++;
                totalScore += bonusScore;
            } else
                bonusScore = 0;
        }

        System.out.println(totalScore);
    }
}

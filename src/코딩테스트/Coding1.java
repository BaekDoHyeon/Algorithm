package 코딩테스트;

import java.util.ArrayList;
import java.util.List;
/*
문제 #1. 찍신 찾기
{ answer : 정답 번호 (1~5), score : number }로 이루어진 배열 arr이 정답지로 넘어갈 때,
가장 점수가 높은 수포자의 이름과 점수를 “이름 : 점수” 형태로 리턴해 주세요.

 시험 응시자는 1번으로 모두 찍은 a, 3번으로 모두 찍은 b, 5번으로 모두 찍은 c가 있습니다.

🚩 [입출력 예]
[ { answer : 1, score : 5 }, { answer : 3, score : 3 }, { answer : 2, score : 4 } ] → a : 5

[ { answer : 1, score : 5 }, { answer : 5, score : 5 }, { answer : 2, score : 4 } ] → a : 5, c : 5
 */
class Exam {
    int answer;
    int score;

    Exam(int answer, int score) {
        this.answer = answer;
        this.score = score;
    }
}

public class Coding1 {
    public static void main(String[] args) {
        //첫 번째 케이스
        List<Exam> arr1 = new ArrayList<>();
        arr1.add(new Exam(1, 5));
        arr1.add(new Exam(3, 3));
        arr1.add(new Exam(2, 4));
        System.out.println(findTopScores(arr1));

        //두 번째 케이스
        List<Exam> arr2 = new ArrayList<>();
        arr2.add(new Exam(1, 5));
        arr2.add(new Exam(5, 5));
        arr2.add(new Exam(2, 4));
        System.out.println(findTopScores(arr2));
    }

    static String findTopScores(List<Exam> arr) {
        int aScore = 0;
        int bScore = 0;
        int cScore = 0;

        for (Exam exam : arr) {
            if (exam.answer == 1) aScore += exam.score;
            else if (exam.answer == 3) bScore += exam.score;
            else if (exam.answer == 5) cScore += exam.score;
        }

        int maxScore = Math.max(aScore, Math.max(bScore, cScore));

        List<String> result = new ArrayList<>();
        if (maxScore == aScore) result.add("a:" + aScore);
        if (maxScore == bScore) result.add("b:" + bScore);
        if (maxScore == cScore) result.add("c:" + cScore);

        return String.join(",", result);
    }
}



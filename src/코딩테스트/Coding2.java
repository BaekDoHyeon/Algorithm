package 코딩테스트;

/*
문제 #2. 최소 공배수의 합
양의 정수의 배열 arr이 주어질 때 모든 원소들이 둘 씩 짝지어 생기는 최소공배수를 합한 값을 리턴하는 solution 함수를 작성해주세요.

🚩 [제한사항]
- arr 내 원소들은 중복되지 않습니다.
- arr 배열의 길이는 최소 3입니다.
- 입출력 예 : [ 1 , 2 , 3 ] → ( {1 | 2} → 2 + { 1 | 3 } → 3 + { 2 | 3 } → 6 ) = 11
 */
public class Coding2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(solution(arr));
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    static int solution(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += lcm(arr[i], arr[j]);
            }
        }

        return sum;
    }
}

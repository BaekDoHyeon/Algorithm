package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/*
// README.md 참고
5. 쇠막대기

[예시 입력 1]
()(((()())(())()))(())

[예시 출력 1]
17

[예시 입력 2]
(((()(()()))(())()))(()())

[예시 출력 2]
24

[힌트]
출처 : 한국정보올림피아드
 */
public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        Stack<Character> stack = new Stack<>();
        int cnt = 0; //잘려진 조각의 개수

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(str.charAt(i));
            else { //닫는 괄호라면..
                //바로 닫히는 괄호냐..
                if (str.charAt(i-1) == '(') {
                    stack.pop();
                    cnt += stack.size();
                } else { //바로 닫힌 괄호가 아니냐...
                    stack.pop();
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

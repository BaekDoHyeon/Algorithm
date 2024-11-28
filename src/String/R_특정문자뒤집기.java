package String;

import java.util.Scanner;

/*
특정 문자 뒤집기

[설명]
영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

[입력]
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.

[출력]
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.

[예시 입력]
a#b!GE*T@S

[예시 출력]
S#T!EG*b@a
 */
public class R_특정문자뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.next();

        char[] charArray = str.toCharArray();

        int lt = 0;
        int rt = charArray.length-1;

        while (lt <= rt) {
            if (!Character.isAlphabetic(charArray[lt]))
                lt++;
            else if (!Character.isAlphabetic(charArray[rt]))
                rt--;
            else { //둘다 알파벳이 맞다면..
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
        }

        for (char c : charArray)
            sb.append(c);

        System.out.println(sb);
    }
}

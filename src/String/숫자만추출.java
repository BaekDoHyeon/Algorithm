package String;

import java.util.Scanner;

/*
9. 숫자만 추출

[설명]
문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.

[입력]
첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.

[출력]
첫 줄에 자연수를 출력합니다.

[예시 입력]
g0en2T0s8eSoft

[예시 출력]
208
 */
public class 숫자만추출 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.nextLine();

        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c))
                sb.append(c);
        }

        int num = Integer.parseInt(sb.toString());
        System.out.println(num);

    }
}

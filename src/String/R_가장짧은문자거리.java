package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
10. 가장 짧은 문자거리

[설명]
한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

[입력]
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
문자열의 길이는 100을 넘지 않는다.

[출력]
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

[예시 입력]
teachermode e

[예시 출력]
1 0 1 2 1 0 1 2 2 1 0
 */

//이 문제 같은 경우는 공식을 그냥 외워야 할 듯하다.
public class R_가장짧은문자거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str, " ");

        String s = st.nextToken();
        String t = st.nextToken();

        char[] charArray = s.toCharArray();
        int[] intArray = new int[charArray.length];

        int p = 1000;
        for(int i = 0; i < charArray.length; i++) {
            String s1 = String.valueOf(charArray[i]);
            if (s1.equals(t)) {
                p=0;
                intArray[i] = p;
            } else {
                p++;
                intArray[i] = p;
            }
        }

        p = 1000;
        for(int i = charArray.length-1; i >= 0; i--) {
            String s1 = String.valueOf(charArray[i]);
            if (s1.equals(t)) p=0;
            else {
                p++;
                intArray[i] = Math.min(intArray[i], p);
            }
        }

        for (int i : intArray)
            System.out.print(i + " ");

    }
}

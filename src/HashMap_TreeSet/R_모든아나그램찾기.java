package HashMap_TreeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
4. 모든 아나그램 찾기

[설명]
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.

[입력]
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.

[출력]
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.

[예시 입력]
bacaAacba
abc

[예시 출력]
3

[힌트]
출력설명 : {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 */
public class R_모든아나그램찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String target = sc.next();

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        int result = 0;
        int lt = 0;

        for (int i = 0; i < target.length(); i++) targetMap.put(target.charAt(i), targetMap.getOrDefault(target.charAt(i), 0) + 1);
        for (int i = 0; i < target.length() - 1; i++) map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);

        for (int rt = target.length() - 1; rt < str.length(); rt++) {
            map.put(str.charAt(rt), map.getOrDefault(str.charAt(rt), 0) + 1);
            if (targetMap.equals(map)) result++;
            map.put(str.charAt(lt), map.get(str.charAt(lt)) - 1);
            if (map.get(str.charAt(lt)) == 0) map.remove(str.charAt(lt));
            lt++;
        }

        System.out.println(result);
    }
}

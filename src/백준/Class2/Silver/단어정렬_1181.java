package 백준.Class2.Silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Comparator 를 사용하여 문자열 정렬 풀이
public class 단어정렬_1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++)
            arr[i] = sc.next();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) { //단어의 길이가 같지 않다면...
                    return s1.length() - s2.length();
                } else { //단어의 길이가 같다면...
                    return s1.compareTo(s2);
                }
            }
        });

        System.out.println(arr[0]);

        //중복 되지 않는 단어만 출력
        for (int i = 1; i < N; i++) {
            if (!arr[i].equals(arr[i-1]))
                System.out.println(arr[i]);
        }
    }
}

package 백준.Class2.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 카운팅 정렬(Counting Sort) 사용.. (시간 복잡도 O(n))
// 카운팅 정렬은 새로운 배열(counting)을 선언해 주어야 하기 때문에, 수의 범위가 매우 크다면 메모리를 매우 낭비할 가능성이 크다.
// https://st-lab.tistory.com/107
public class 수정렬하기3_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] counting = new int[10001];

        for (int i = 0; i < N; i++) {
            //해당 인덱스의 값을 1 증가 시킨다.
            counting[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i < 10001; i++) {
            while (counting[i] > 0) {
                sb.append(i).append("\n");
                counting[i]--;
            }
        }

        System.out.println(sb);
    }
}

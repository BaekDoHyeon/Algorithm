package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
// README.md 참고

6. 공주 구하기

[예시 입력]
8 3

[예시 출력]
7
 */
public class 공주구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1 ; i <= n; i++)
            queue.add(i);

        while(queue.size() != 1) {
            cnt++;
            int p = queue.poll();
            if (cnt != k) {
                queue.add(p);
                continue;
            }
            cnt = 0;
        }

        System.out.println(queue.peek());
    }
}

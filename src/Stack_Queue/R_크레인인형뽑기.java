package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/*
3. 크레인 인형뽑기(카카오)

[예시 입력]
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4

[예시 출력]
4
 */
public class R_크레인인형뽑기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = sc.nextInt();

        int cnt = sc.nextInt();
        int[] moves = new int[cnt];
        for (int i = 0; i < cnt; i++)
            moves[i] = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        int currentNum = 0; //현재 뽑은 인형의 번호
        int boomCnt = 0; //터트린 횟수

        for (int move : moves) {
            int num = move - 1;
            for (int i = 0; i < n; i++) { //인형을 집는다..
                if (board[i][num] != 0) {
                    currentNum = board[i][num];
                    board[i][num] = 0;

                    if (stack.isEmpty() || stack.peek() != currentNum) {
                        stack.push(currentNum);
                        currentNum = 0;
                    } else if (stack.peek() == currentNum) {
                        boomCnt++;
                        stack.pop();
                        currentNum = 0;
                    }

                    break;
                }
            }
        }

        System.out.println(boomCnt*2);
    }
}

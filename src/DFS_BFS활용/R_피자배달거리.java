package DFS_BFS활용;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
// 자세한 건 README.md 참고..

14. 피자 배달 거리(삼성 SW역량평가 기출문제 : DFS활용 + 조합 구하기 참고)

[입력]
첫째 줄에 N(2 ≤ N ≤ 50)과 M(1 ≤ M ≤ 12)이 주어진다.
둘째 줄부터 도시 정보가 입력된다.

[출력]
첫째 줄에 M개의 피자집이 선택되었을 때 도시의 최소 피자배달거리를 출력한다.

[예시 입력]
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2

[예시 출력]
6
 */
class Pos4 {
    int x;
    int y;
    Pos4 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class R_피자배달거리 {
    static int N, M, result = Integer.MAX_VALUE;
    static int[][] board;
    static int[] combi;
    static List<Pos4> hs = new ArrayList<>();
    static List<Pos4> pz = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        combi = new int[M];
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) hs.add(new Pos4(i, j));
                if (tmp == 2) pz.add(new Pos4(i, j));
            }
        }

        DFS(0, 0);
        System.out.println(result);
    }

    public static void DFS(int L, int n) {
        if (L == M) { //조합이 완성되었다면...
            int sum = 0;
            for (int i = 0; i < hs.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j : combi) {
                    min = Math.min(Math.abs(hs.get(i).x - pz.get(j).x) + Math.abs(hs.get(i).y - pz.get(j).y), min);
                }
                sum += min;
            }
            result = Math.min(result, sum);
        } else {
            for (int i = n; i < pz.size(); i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}

package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
4. 가장 높은 탑 쌓기

[설명]
밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.
아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.
(조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.
(조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.
(조건3) 벽돌들의 높이는 같을 수도 있다.
(조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.
(조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.

[입력]
입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대 100개이다.
둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높이 그리고 무게가 차례대로 양의 정수로 주어진다.
각 벽돌은 입력되는 순서대로 1부터 연속적인 번호를 가진다. 벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.

[출력]
첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.

[예시 입력]
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

[예시 출력]
10

[예시 입력2]
10
114 96 290
65 74 201
261 19 105
181 60 275
90 145 254
286 118 64
16 24 205
288 128 299
96 36 74
182 5 35

[예시 출력2]
443

 */
class Brick implements Comparable<Brick> {
    int bottom;
    int height;
    int weight;

    Brick(int bottom, int height, int weight) {
        this.bottom = bottom;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
        return o.bottom - this.bottom;
    }
}
public class R_가장높은탑쌓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Brick> bricks = new ArrayList<>();
        int[] heightArr = new int[n];
        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            bricks.add(new Brick(b, h, w));
        }

        Collections.sort(bricks);

        heightArr[0] = bricks.get(0).height;
        int maxHeight = heightArr[0];
        for (int i = 1; i < bricks.size(); i++) {
            Brick curBrick = bricks.get(i);
            int tmpMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks.get(j).weight > curBrick.weight && heightArr[j] >= tmpMax) tmpMax = heightArr[j];
            }

            heightArr[i] = tmpMax + curBrick.height;
            maxHeight = Math.max(maxHeight, heightArr[i]);
        }

        System.out.println(maxHeight);
    }
}

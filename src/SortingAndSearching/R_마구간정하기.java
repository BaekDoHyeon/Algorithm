package SortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

/*
10. 마구간 정하기(결정알고리즘)

[설명]
N개의 마구간이 수직선상에 있습니다. 각 마구간은 x1, x2, x3, ......, xN의 좌표를 가지며, 마구간간에 좌표가 중복되는 일은 없습니다.
현수는 C마리의 말을 가지고 있는데, 이 말들은 서로 가까이 있는 것을 좋아하지 않습니다. 각 마구간에는 한 마리의 말만 넣을 수 있고,
가장 가까운 두 말의 거리가 최대가 되게 말을 마구간에 배치하고 싶습니다.
C마리의 말을 N개의 마구간에 배치했을 때 가장 가까운 두 말의 거리가 최대가 되는 그 최대값을 출력하는 프로그램을 작성하세요.

[입력]
첫 줄에 자연수 N(3<=N<=200,000)과 C(2<=C<=N)이 공백을 사이에 두고 주어집니다.
둘째 줄에 마구간의 좌표 xi(0<=xi<=1,000,000,000)가 차례로 주어집니다.

[출력]
첫 줄에 가장 가까운 두 말의 최대 거리를 출력하세요.

[예시 입력]
5 3
1 2 8 4 9

[예시 출력]
3
 */
public class R_마구간정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);

        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt();
        int result = 0;

        while (lt <= rt) {
            int mid = (lt+rt) / 2;
            if (count(mid, arr) >= c) {
                lt = mid + 1;
                result = mid;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(result);
    }

    //유효한지 안하는지 체크하는 함수, 결정 알고리즘에서는 이러한 유효성 검사를 하는 함수를 잘 만드는 게 핵심 뽀인트다!
    public static int count(int mid, int[] arr) {
        int cnt = 1;
        int endP = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - endP >= mid) {
                cnt++;
                endP = arr[i];
            }
        }

        return cnt;
    }
}

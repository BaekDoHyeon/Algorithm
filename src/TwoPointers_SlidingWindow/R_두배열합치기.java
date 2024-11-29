package TwoPointers_SlidingWindow;

import java.util.Scanner;

/*
1. 두 배열 합치기

[설명]
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

[입력]
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

[출력]
오름차순으로 정렬된 배열을 출력합니다.

[예시 입력]
3
1 3 5
5
2 3 6 7 9

[예시 출력]
1 2 3 3 5 6 7 9
 */
public class R_두배열합치기 {
    public static void main(String[] args) {
        /*
        // 문제 풀이 1 => 내가 푼 풀이... 투 포인터 풀이를 잘 모르겠따...
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int cnt1 = sc.nextInt();
        for (int i = 0; i < cnt1; i++)
            list.add(sc.nextInt());
        int cnt2 = sc.nextInt();
        for (int i = 0; i < cnt2; i++)
            list.add(sc.nextInt());
        Collections.sort(list);
        for (Integer i : list)
            System.out.print(i + " ");
        */

        //문제 풀이 2 => 투 포인터 풀이...
        Scanner sc = new Scanner(System.in);

        int cnt1 = sc.nextInt();
        int[] a = new int[cnt1];
        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();

        int cnt2 = sc.nextInt();
        int[] b = new int[cnt2];
        for (int i = 0; i < b.length; i++)
            b[i] = sc.nextInt();

        int p1 = 0;
        int p2 = 0;
        int idx = 0;
        int[] result = new int[cnt1 + cnt2];

        while (p1 < cnt1 && p2 < cnt2) {
            if (a[p1] > b[p2]) result[idx++] = b[p2++];
            else if (b[p2] > a[p1]) result[idx++] = a[p1++];
            else result[idx++] = a[p1++];
        }

        while (p1 < cnt1) result[idx++] = a[p1++];
        while (p2 < cnt2) result[idx++] = b[p2++];

        for (int i : result)
            System.out.print(i + " ");
    }
}

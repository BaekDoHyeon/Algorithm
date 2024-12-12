package GreedyAlgorithm;

import java.util.*;

/*
// 자세한 내용은 README.md 참고

7. 원더랜드(최소 스패닝 트리 - 크루스칼 : Union&Find 이용)
=> 트리에서 정점이 n개면 간선의 개수는 n-1개 이다.

[입력]
첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.

[출력]
모든 도시를 연결하면서 드는 최소비용을 출력한다.

[예시 입력]
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

[예시 출력]
196
 */
class Road implements Comparable<Road> {
    int v1;
    int v2;
    int cost;

    Road (int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}

public class R_원더랜드1 {
    static int V, E, result = 0;
    static int[] arr;
    static List<Road> roads = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt(); //도시의 개수
        E = sc.nextInt(); //도로의 개수
        arr = new int[V+1];
        for (int i = 1 ; i <= V; i++) arr[i] = i;
        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            roads.add(new Road(v1, v2, cost));
        }
        Collections.sort(roads);
        for (Road road : roads) {
            Union(road);
        }

        System.out.println(result);
    }

    public static int Find(int v) {
        if (arr[v] == v) return v;
        else return arr[v] = Find(arr[v]);
    }

    public static void Union(Road road) {
        int value1 = Find(road.v1);
        int value2 = Find(road.v2);
        if (value1 != value2) {
            arr[value1] = arr[value2];
            result += road.cost;
        }
    }
}

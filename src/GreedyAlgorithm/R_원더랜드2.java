package GreedyAlgorithm;

import java.util.*;

/*
// 자세한 내용은 README.md 참고

8. 원더랜드(최소 스패닝 트리 - 프림 : PriorityQueue 활용)

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
class Road2 implements Comparable<Road2> {
    int v;
    int cost;

    Road2(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road2 o) {
        return this.cost - o.cost;
    }
}
public class R_원더랜드2 {
    static int result = 0;
    static int[] ch;
    static List<List<Road2>> graph = new ArrayList<>();
    static Queue<Road2> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        ch = new int[V+1];
        for (int i  = 0; i <= V; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(v1).add(new Road2(v2, cost));
            graph.get(v2).add(new Road2(v1, cost));
        }

        pq.add(new Road2(1, 0));
        while(!pq.isEmpty()) {
            Road2 cur = pq.poll();
            if (ch[cur.v] == 0)  {
                result += cur.cost;
                ch[cur.v] = 1;
            }

            for (Road2 r : graph.get(cur.v))
                if (ch[r.v] == 0) pq.add(new Road2(r.v, r.cost));
        }

        System.out.println(result);
    }
}

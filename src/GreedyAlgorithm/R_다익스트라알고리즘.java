package GreedyAlgorithm;

import java.util.*;

/*
5. 다익스트라 알고리즘 (채점 지원 X)
=> 그래프에서 최단거리 또는 최소거리는 다익스트라 알고리즘을 사용하여 풀이, 최소스패닝트리(최소비용트리)에서는 크루스칼 알고리즘을 사용하여 풀이

[다익스트라 알고리즘이란?]
다익스트라 알고리즘은 그래프에서 하나의 시작점에서 다른 모든 정점까지의 최단 경로를 찾는 알고리즘이에요.
간단히 말해, "가장 빠르게 목적지에 도착할 수 있는 길을 찾는 방법"을 알려주는 도구라고 생각하면 됩니다.

=> 어떻게 작동하나요?
1. 출발점에서 시작합니다.
  - 출발점에서 모든 정점까지의 거리를 기록하는데, 처음엔 출발점은 0, 나머지는 최고값으로 설정해요.
  - 예: "우리 집에서 목적지까지의 거리"를 찾는다고 생각해보세요. 처음에는 목적지가 얼마나 멀리 있는지 모르니까 무한대라고 가정하는 거예요.

2. 방문한 정점과 방문하지 않은 정점을 나눕니다.
  - 출발점부터 시작해서 가장 가까운 정점부터 차례대로 방문해요.

3. 최단 거리 업데이트
  - 방문한 정점에서 연결된 정점을 확인하며, 새로운 경로로 이동하는 것이 더 짧다면 거리를 업데이트해요.
  - 예: A → C로 가는 최단 거리가 10이라고 기록되어 있었는데, A → B → C로 가면 8이 된다면, 기록을 8로 바꿔요.

4. 모든 정점을 방문할 때까지 반복
  - 이 과정을 모든 정점에 대해 반복해서 최단 거리를 계산해요.


[입력 설명]
첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보와 거리비용이 주어진다.

[출력 설명]
1번 정점에서 각 정점으로 가는 최소비용을 2번 정점부터 차례대로 출력하세요.

[입력 예제]
// ex.) 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

[출력 예제]
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible
 */
class Eage implements Comparable<Eage> {
    int vex;
    int cost;

    Eage(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Eage o) {
        return this.cost - o.cost;
    }

    @Override
    public String toString() {
        return "Eage{" +
                "vex=" + vex +
                ", cost=" + cost +
                '}';
    }
}
public class R_다익스트라알고리즘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<List<Eage>> graph = new ArrayList<>();
        Queue<Eage> pq = new PriorityQueue<>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int e = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            graph.get(e).add(new Eage(v, c));
        }

        //로직 작성
        pq.add(new Eage(1, 0));
        dis[1] = 0;
        while(!pq.isEmpty()) {
            Eage curEage = pq.poll();
            System.out.println(curEage);
            for (Eage e : graph.get(curEage.vex)) {
                int nowVex = e.vex;
                int nowCost = e.cost;
                if (dis[nowVex] < nowCost) continue;
                if (dis[nowVex] > dis[curEage.vex] + nowCost) {
                    dis[nowVex] = dis[curEage.vex] + nowCost;
                    pq.add(new Eage(nowVex, nowCost));
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dis[i] != Integer.MAX_VALUE) System.out.print(i + " : " + dis[i]);
            else System.out.print(i + " : impossible");
            System.out.println();
        }
    }
}

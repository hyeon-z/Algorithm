package src.algorithm_study.week9;

/*
    [Gold4] 백준 1504 특정한 최단 경로 (https://www.acmicpc.net/problem/1504)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight < o.weight) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    static int N, E;
    static int v1, v2;
    static int[] shortestW;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static long shortestLen1, shortestLen2;

    public static void main(String[] args) throws IOException {
        input();

        // 1 -> v1 -> v2 -> N
        shortestLen1 = (long) dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N
        shortestLen2 = (long) dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향 그래프 입력
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
    }

    static void init() {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        shortestW = new int[N + 1];
        Arrays.fill(shortestW, INF);

        // 시작노드 처리
        pq.offer(new Node(start, 0));
        shortestW[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nowIndex = node.index;

            // 이미 확인 완료한 노드일 경우
            if (shortestW[nowIndex] < node.weight) {
                if (nowIndex == end) {
                    return shortestW[end];
                }
                continue;
            }

            for (int i = 0; i < graph.get(nowIndex).size(); i++) {
                Node nearNode = graph.get(nowIndex).get(i);
                int nearIndex = nearNode.index;
                int totalW = shortestW[nowIndex] + nearNode.weight;

                // 최단거리 갱신된 경우
                if (shortestW[nearIndex] > totalW) {
                    shortestW[nearIndex] = totalW;
                    pq.offer(new Node(nearIndex, totalW));
                }
            }
        }
        return shortestW[end];
    }

    static void output() {
        if (shortestLen1 >= INF && shortestLen2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(shortestLen1, shortestLen2));
        }
    }
}

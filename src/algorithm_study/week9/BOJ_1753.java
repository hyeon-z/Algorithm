package src.algorithm_study.week9;

/*
    [Gold4] 백준 1753 최단 경로 (https://www.acmicpc.net/problem/1753)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
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

    static int V, E, K;
    static int[] shortestW;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        dijkstra(K);
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        shortestW = new int[V + 1];
        K = Integer.parseInt(br.readLine());

        init();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }
    }

    static void init() {
        // 최단 거리 배열 INF로 초기화
        Arrays.fill(shortestW, INF);

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작노드 처리
        pq.offer(new Node(start, 0));
        shortestW[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nowIndex = node.index;

            // 이미 확인 완료한 노드일 경우
            if (shortestW[nowIndex] < node.weight) {
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
    }

    static void output() {
        for (int i = 1; i <= V; i++) {
            if (shortestW[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(shortestW[i]);
            }
        }
    }
}

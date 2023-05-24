package src.algorithm_study.week10;
/*
    [Gold4] 백준 10282 해킹 (https://www.acmicpc.net/problem/10282)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10282 {
    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int t, n, d, c;
    static ArrayList<ArrayList<Node>> graph;
    static int[] shortest;
    static final int INF = Integer.MAX_VALUE;
    static int maxSec, cnt;

    public static void main(String[] args) throws IOException {
        inputT();

        for (int i = 0; i < t; i++) {
            input();
            solution();
            output();
        }
        System.out.println(sb);
    }

    static void inputT() throws IOException {
        t = Integer.parseInt(br.readLine());
    }

    static void init() {
        // 결과 변수 초기화
        cnt = 0;
        maxSec = 0;

        graph = new ArrayList<>();

        // graph 초기화
        for (int j = 0; j <= n; j++) {
            graph.add(new ArrayList<>());
        }
    }

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());  // 컴퓨터 개수
        d = Integer.parseInt(st.nextToken());  // 의존성 개수
        c = Integer.parseInt(st.nextToken());  // 해킹당한 컴퓨터 번호 - 출발 노드 index

        init();

        // 간선 정보 저장
        for (int j = 0; j < d; j++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            graph.get(b).add(new Node(a, s));
        }
    }

    static void solution() {
        shortest = new int[n + 1];

        // 최단 거리 배열 무한으로 초기화
        Arrays.fill(shortest, INF);

        dijkstra(c);

        for (int i = 1; i <= n; i++) {
            if (shortest[i] == INF) {
                continue;
            }

            cnt++;
            maxSec = Math.max(maxSec, shortest[i]);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        shortest[start] = 0;

        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();

            int nowIndex = node.index;
            int dist = node.distance;

            // 현재 노드가 이미 처리된 적 있는 노드라면 무시
            if (shortest[nowIndex] < dist) {
                continue;
            }

            // 현재 노드와 연결된 다른 인접한 노드들 확인
            for (int i = 0; i < graph.get(nowIndex).size(); i++) {
                Node nearNode = graph.get(nowIndex).get(i);
                int totalDist = shortest[nowIndex] + nearNode.distance;

                // 현재 노드를 거쳐, 다른 노드로 이동하는 거리가 더 짧을 경우
                if (totalDist < shortest[nearNode.index]) {
                    shortest[nearNode.index] = totalDist;
                    pq.offer(new Node(nearNode.index, nearNode.distance));
                }
            }
        }
    }

    static void output() {
        sb.append(cnt).append(" ").append(maxSec).append("\n");
    }
}

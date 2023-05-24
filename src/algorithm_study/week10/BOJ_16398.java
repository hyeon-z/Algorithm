package src.algorithm_study.week10;
/*
    [Gold4] 백준 16398 행성 연결 (https://www.acmicpc.net/problem/16398)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16398 {
    static class Edge implements Comparable<Edge> {
        int cost;
        int nodeA;
        int nodeB;

        public Edge(int cost, int nodeA, int nodeB) {
            this.cost = cost;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        // 비용이 짧은 것이 높은 우선순위를 가지도록 설정
        @Override
        public int compareTo(Edge o) {
            if (this.cost < o.cost) {
                return -1;
            } else if (this.cost == o.cost) {
                return 0;
            }
            return 1;
        }
    }

    static int N;
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();
    static int[][] map;
    static long result;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        map = new int[N + 1][N + 1];

        // 간선 정보 map에 저장하기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 부모 배열 자기 자신으로 초기화
    static void makeParent() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    // 특정 원소가 속한 집합을 찾기
    static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static void solution() {
        makeParent();

        // 간선에 대한 정보 edges 배열에 저장
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                edges.add(new Edge(map[i][j], i, j));
            }
        }

        // 간선을 비용순으로 정렬
        Collections.sort(edges);

        for (Edge edge : edges) {
            int cost = edge.cost;
            int a = edge.nodeA;
            int b = edge.nodeB;

            // 사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }
    }

    static void output() {
        System.out.println(result);
    }
}

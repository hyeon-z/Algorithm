package src.algorithm_study.week12;

/*
    [Silver1] 백준 2468 안전 영역 (https://www.acmicpc.net/problem/2468)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468 {
    static int N;
    static int[][] map;
    static int minHeight = 101, maxHeight = 0;
    static int result = 1;  // 아무 지역도 물에 안잠긴 경우
    static Queue<Node> q;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1}; // 상하좌우

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) {
                    maxHeight = map[i][j];
                }

                if (map[i][j] < minHeight) {
                    minHeight = map[i][j];
                }
            }
        }
    }

    static void solution() {
        for (int i = minHeight; i < maxHeight; i++) {
            q = new LinkedList<>();
            visited = new boolean[N][N];

            result = Math.max(result, getSafetyArea(i));
        }
    }


    private static int getSafetyArea(int height) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 이미 방문했거나 영역이 잠긴 경우
                if (visited[i][j] || (map[i][j] - height) <= 0) {
                    continue;
                }

                dfs(i, j, height);
//                bfs(i, j, height);
                count++;
            }
        }
        return count;
    }

    static void dfs(int x, int y, int height) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 벗어남
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (!visited[nx][ny] && (map[nx][ny] - height) > 0) {
                dfs(nx, ny, height);
            }
        }
    }

    static void bfs(int x, int y, int height) {
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int nodeX = node.x;
            int nodeY = node.y;

            for (int l = 0; l < 4; l++) {
                int nx = nodeX + dx[l];
                int ny = nodeY + dy[l];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (!visited[nx][ny] && (map[nx][ny] - height) > 0) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void output() {
        System.out.println(result);
    }
}

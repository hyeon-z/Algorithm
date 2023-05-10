package src.algorithm_basics.week3.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    백준 2178 미로탐색 문제로 대체
 */
class Pos {
    int x;
    int y;
    int dis;

    public Pos(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

public class Grid {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startX, int startY) {
        Queue<Pos> q = new LinkedList<>();
        int result = 0;

        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[N][M];

        q.offer(new Pos(startX, startY, 1));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Pos pos = q.poll();

            int x = pos.x;
            int y = pos.y;
            int dis = pos.dis;

            if (x == N - 1 && y == M - 1) {
                result = dis;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 범위 벗어남
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    q.offer(new Pos(nx, ny, dis + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return result;
    }
}

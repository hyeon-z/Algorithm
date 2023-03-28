package src.this_is_coding_test.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    이것이 코딩테스트다 5-2
    미로 탈출 (https://hyeon-z.tistory.com/27)

    # 시간 제한
    1초

    # 문제
    동빈이는 N X M 크기의 직사각형 형태의 미로에 갇혀 있다.
    미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다.
    동빈이의 위치는 (1, 1)이고 미로의 출구는(N, M)의 위치에 존재하며 한 번에 한 칸씩 이동할 수 있다.
    이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시되어 있다.
    미로는 반드시 탈출할 수 있는 형태로 제시된다.
    이때 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하시오.
    칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.

    # 입력
    첫째 줄에 두 장수 N, M（4 < N, M < 200）이 주어집니다.
    다음 N개의 줄에는 각각 M개의 장수（0 혹은 1）로 미로의 정보가 주어진다.
    각각의 수들은 공백 없이 붙어서 입력으로 제시된다.
    또한 시작 칸과 마지막 칸은 항상 1이다.

    # 출력
    첫째 줄에 최소 이동 칸의 개수를 출력한다.
 */

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class TC_5_2 {
    static int[][] maze;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(split[j]);
            }
        }

        bfs();
        System.out.println(count);
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        // 처음 좌표 큐에 삽입 후 방문 처리
        queue.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;

            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (maze[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                // 출구를 발견한 경우 bfs 함수 종료
                if (nx == N - 1 && ny == M - 1) {
                    count = maze[x][y] + 1;
                    return;
                }

                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
                maze[nx][ny] = maze[x][y] + 1;
            }
        }
    }
}

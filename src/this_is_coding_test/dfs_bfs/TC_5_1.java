package src.this_is_coding_test.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    이것이 코딩테스트다 5-1
    음료수 얼려 먹기 (https://hyeon-z.tistory.com/26)

    # 시간 제한
    1초

    # 문제
    N x M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
    구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
    이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.

    # 입력
    - 첫 번째 줄에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다. (1 < N, M < 1,000)
    - 두 번째 줄부터 N + 1번째 줄까지 얼음 틀의 형태가 주어진다.
    - 이때 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1이다.

    # 출력
    한 번에 만들 수 있는 아이스크림의 개수를 출력한다.
 */

public class TC_5_1 {
    static int[][] ice;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ice = new int[N][M];
        visited = new boolean[N][M];

        // 얼음 틀 정보 입력받기
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(split[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || ice[i][j] == 1) {
                    continue;
                }

                dfs(i, j);
                count += 1;
            }
        }
        System.out.println(count);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (visited[nx][ny] || ice[nx][ny] == 1) {
                continue;
            }

            dfs(nx, ny);
        }
    }
}

package src.this_is_coding_test.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    이것이 코딩테스트다 4-2
    게임 개발 (https://hyeon-z.tistory.com/5)

    # 시간 제한
    1초

    # 문제
    현민이는 게임 캐릭터가 맵 안에서 움직이는 시스템을 개발 중이다.
    캐릭터가 있는 장소는 1 x 1 크기의 정사각형으로 이뤄진 N x M 크기의 직사각형으로, 각각의 칸은 육지 또는 바다이다.
    캐릭터는 동서남북 중 한 곳을 바라본다.

    맵의 각 칸은 (A, B)로 나타낼 수 있고, A는 북쪽으로부터 떨어진 칸의 개수, B는 서쪽으로부터 떨어진 칸의 개수이다.
    캐릭터는 상하좌우로 움직일 수 있고, 바다로 되어 있는 공간에는 갈 수 없다.
    캐릭터의 움직임을 설정하기 위해 정해 놓은 매뉴얼은 이러하다.

    1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 방향으로 90도 회전한 방향)부터 차례대로 갈 곳을 정한다.
    2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다. 왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
    3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는, 바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단계로 돌아간다. 단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.

    현민이는 위 과정을 반복적으로 수행하면서 캐릭터의 움직임에 이상이 있는지 테스트하려고 한다.
    매뉴얼에 따라 캐릭터를 이동시킨 뒤에, 캐릭터가 방문한 칸의 수를 출력하는 프로그램을 만드시오.

    # 입력
    - 첫째 줄에 맵의 세로 크기 N과 가로 크기 M을 공백으로 구분하여 입력한다. (3 <= N, M <= 50)
    - 둘째 줄에 게임 캐릭터가 있는 칸의 좌표 (A, B)와 바라보는 방향 d가 각각 서로 공백으로 구분하여 주어진다.
      방향 선의 값으로는 다음과 같이 4가지가 존재한다.(0: 북쪽 , 1: 동쪽 , 2: 남쪽 , 3: 서쪽)
    - 셋째 줄부터 맵이 육지인지 바다인지에 대한 정보가 주어진다.
      N개의 줄에 맵의 상태가 북쪽부터 남쪽 순서대로, 각 줄의 데이터는 서쪽부터 동쪽 순서대로 주어진다.
      맵의 외곽은 항상 바다로 되어 있다. (0: 육지 , 1: 바다)
    - 처음에 게임 캐릭터가 위치한 칸의 상태는 항상 육지이다.

    # 출력
    첫째 줄에 이동을 마친 후 캐릭터가 방문한 칸의 수를 출력한다.
 */

public class TC_4_2 {
    static int d;

    // 왼쪽 방향으로 회전
    static void turnLeft() {
        d -= 1;
        if (d == -1) {
            d = 3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 맵 배열에 저장
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int turnCount = 0;
        int moveCount = 1;

        // 처음 있었던 곳 방문한 칸으로 체크
        map[A][B] = -1;

        while (true) {
            turnCount++;

            turnLeft();

            int nx = A + dx[d];
            int ny = B + dy[d];

            // 육지이면서 방문하지 않은 칸인 경우
            if (map[nx][ny] == 0) {
                map[nx][ny] = -1;
                A = nx;
                B = ny;
                moveCount++;
                turnCount = 0;
                continue;
            }

            // 네 방향 모두 확인
            if (turnCount == 4) {
                nx = A - dx[d];
                ny = B - dy[d];

                // 한 칸 뒤가 바다인 경우
                if (map[nx][ny] == 1) {
                    break;
                }
                A = nx;
                B = ny;
                turnCount = 0;
            }
        }
        System.out.println(moveCount);
    }
}

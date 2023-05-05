package src.algorithm_study.week8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    프로그래머스 Level 2 81302 거리두기 확인하기 (https://school.programmers.co.kr/learn/courses/30/lessons/81302)
 */

public class PG_81302 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places)));
    }

    public static int[] solution(String[][] places) {
        int[] result = new int[5];

        for (int i = 0; i < 5; i++) {
            String[] place = places[i];  // ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"]
            boolean isRuled = true;

            for (int j = 0; j < 5 && isRuled; j++) {
                for (int k = 0; k < 5 && isRuled; k++) {
                    if (place[j].charAt(k) == 'P') {
                        if (!bfs(j, k, place)) {
                            isRuled = false;
                        }
                    }
                }
            }
            result[i] = isRuled ? 1 : 0;
        }

        return result;
    }

    public static boolean bfs(int startX, int startY, String[] place) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int i = 0; i < dx.length; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (nx < 0 || nx > 4 || ny < 0 || ny > 4 || (startX == nx && startY == ny)) {  // 범위를 벗어나는 경우 or 시작점을 다시 탐색하는 경우
                    continue;
                }

                int d = Math.abs(startX - nx) + Math.abs(startY - ny);

                // 거리가 2까지 P인 경우 체크
                if (place[nx].charAt(ny) == 'P' && d <= 2) {
                    return false;
                }

                // 거리가 2인 경우는 O이어도 더이상 탐색하지 않기 때문에 1까지만 탐색
                if (place[nx].charAt(ny) == 'O' && d < 2) {
                    q.offer(new int[]{nx, ny});
                }
            }

        }

        return true;
    }
}

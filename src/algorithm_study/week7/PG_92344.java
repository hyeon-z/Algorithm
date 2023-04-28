package src.algorithm_study.week7;

/*
    프로그래머스 92344 파괴되지 않는 건물 (https://school.programmers.co.kr/learn/courses/30/lessons/92344)
 */

public class PG_92344 {
    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};

        System.out.println(solution(board, skill));
    }


    public static int solution(int[][] board, int[][] skill) {
        // board배열 index
        int x = board.length - 1;
        int y = board[0].length - 1;

        // 누적합 구할 배열
        int[][] map = new int[x + 1][y + 1];

        for (int[] sk : skill) {
            int type = sk[0];

            int r1 = sk[1];
            int c1 = sk[2];

            int r2 = sk[3];
            int c2 = sk[4];

            int degree = sk[5];

            // type이 1이면 공격, 아니면 방어
            int n = (type == 1) ? -1 : 1;
            n *= degree;

            // r1, c1
            map[r1][c1] += n;

            // r2 + 1, c2 + 1
            if ((r2 + 1) <= x && (c2 + 1) <= y) {
                map[r2 + 1][c2 + 1] += n;
            }

            // r1, c2 + 1
            if ((c2 + 1) <= y) {
                map[r1][c2 + 1] += -n;
            }

            // r2 + 1, c1
            if ((r2 + 1) <= x) {
                map[r2 + 1][c1] += -n;
            }
        }

        // map 행으로 쭉 더하기
        for (int j = 0; j <= x; j++) {
            for (int k = 1; k <= y; k++) {
                map[j][k] += map[j][k - 1];
            }
        }

        // map 열로 쭉 더하기
        for (int j = 0; j <= y; j++) {
            for (int k = 1; k <= x; k++) {
                map[k][j] += map[k - 1][j];
            }
        }

        for (int j = 0; j <= x; j++) {
            for (int k = 0; k <= y; k++) {
                board[j][k] += map[j][k];
            }
        }

        int count = 0;
        for (int j = 0; j <= x; j++) {
            for (int k = 0; k <= y; k++) {
                if (board[j][k] > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

package src.algorithm_study.week13;

import java.util.LinkedList;
import java.util.Queue;

/*
    프로그래머스 Level3 87694 아이템 줍기 (https://school.programmers.co.kr/learn/courses/30/lessons/87694)
 */

public class PG_87694 {
    static class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    static boolean[][] map = new boolean[110][110];
    static int result;

    public static void main(String[] args) {
        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};

        System.out.println(solution(rectangle, 1, 3, 7, 8));
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        findBorder(rectangle);
        bfs(characterX, characterY, itemX, itemY);

        return result;
    }

    static void findBorder(int[][] rectangle) {
        for (int[] re : rectangle) {

            // 포함 좌표 전부 true
            for (int i = re[0] * 2; i <= re[2] * 2; i++) {
                for (int j = re[1] * 2; j <= re[3] * 2; j++) {
                    map[i][j] = true;
                }
            }

            // 빈 공간 모두 false
            for (int i = re[0] * 2 + 1; i < re[2] * 2; i++) {
                for (int j = re[1] * 2 + 1; j < re[3] * 2; j++) {
                    map[i][j] = false;
                }
            }
        }
    }

    static void bfs(int characterX, int characterY, int itemX, int itemY) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] visited = new boolean[110][110];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(characterX * 2, characterY * 2, 0));
        visited[characterX * 2][characterY * 2] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            int x = node.x;
            int y = node.y;

            // 타겟 발견
            if (itemX * 2 == x && itemY * 2 == y) {
                result = node.depth / 2;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 테두리일 떄
                if (map[nx][ny] && !visited[nx][ny]) {
                    q.add(new Node(nx, ny, node.depth + 1));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

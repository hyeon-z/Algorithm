package src.algorithm_study.week2;

/*
    백준 1780 종이의 개수 (https://www.acmicpc.net/problem/1780)

    # 시간 제한
    2초

    # 문제
    N × N 크기의 행렬로 표현되는 종이가 있다.
    종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다.
    우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.

    만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
    (1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
    이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

    # 입력
    첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

    # 출력
    첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {
    static int[][] paperMap;
    static int[] count;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        paperMap = new int[N][N];
        count = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paperMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }

    }

    static void divide(int r, int c, int n) {
        // 종이가 모두 같은 수로 되어있는 경우
        if (checkNum(r, c, n)) {
            count[paperMap[r][c] + 1]++;
            return;
        }

        // 그렇지 않은 경우
        int quot = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(r + i * quot, c + j * quot, quot);
            }
        }
    }

    static boolean checkNum(int r, int c, int n) {
        int num = paperMap[r][c];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (num != paperMap[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

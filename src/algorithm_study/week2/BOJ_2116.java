package src.algorithm_study.week2;

/*
    백준 2116 주사위 쌓기 (https://www.acmicpc.net/problem/2116)

    # 시간 제한
    2초

    # 문제
    천수는 여러 종류의 주사위를 가지고 쌓기 놀이를 하고 있다.
    주사위의 모양은 모두 크기가 같은 정육면체이며 각 면에는 1부터 6까지의 숫자가 하나씩 적혀있다.
    그러나 보통 주사위처럼 마주 보는 면에 적혀진 숫자의 합이 반드시 7이 되는 것은 아니다.

    주사위 쌓기 놀이는 아래에서부터 1번 주사위, 2번 주사위, 3번 주사위, … 의 순서로 쌓는 것이다.
    쌓을 때 다음과 같은 규칙을 지켜야 한다: 서로 붙어 있는 두 개의 주사위에서 아래에 있는 주사위의 윗면에 적혀있는 숫자는 위에 있는 주사위의 아랫면에 적혀있는 숫자와 같아야 한다.
    다시 말해서, 1번 주사위 윗면의 숫자는 2번 주사위 아랫면의 숫자와 같고, 2번 주사위 윗면의 숫자는 3번 주사위 아랫면의 숫자와 같아야 한다.
    단, 1번 주사위는 마음대로 놓을 수 있다.

    이렇게 쌓아 놓으면 긴 사각 기둥이 된다.
    이 사각 기둥에는 4개의 긴 옆면이 있다.
    이 4개의 옆면 중에서 어느 한 면의 숫자의 합이 최대가 되도록 주사위를 쌓고자 한다.
    이렇게 하기 위하여 각 주사위를 위 아래를 고정한 채 옆으로 90도, 180도, 또는 270도 돌릴 수 있다.
    한 옆면의 숫자의 합의 최댓값을 구하는 프로그램을 작성하시오.

    # 입력
    줄에는 주사위의 개수가 입력된다.
    그 다음 줄부터는 한 줄에 하나씩 주사위의 종류가 1번 주사위부터 주사위 번호 순서대로 입력된다.
    주사위의 종류는 각 면에 적혀진 숫자가 그림1에 있는 주사위의 전개도에서 A, B, C, D, E, F 의 순서로 입력된다.
    입력되는 숫자 사이에는 빈 칸이 하나씩 있다.
    주사위의 개수는 10,000개 이하이며 종류가 같은 주사위도 있을 수 있다.

    # 출력
    첫줄에 한 옆면의 숫자의 합이 가장 큰 값을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116 {
    static int[] diceNum;
    static final int diceCount = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] dice = new int[N][6];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        diceNum = new int[]{5, 3, 4, 1, 2, 0}; // A - F, B - D, C - E
        int result = 0;

        if (N < 1) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < diceCount; i++) {
            int bottom = i;
            int max = findMax(dice, 0, bottom);
            int totalMax = max;
            int topNum = dice[0][diceNum[bottom]];

            for (int j = 1; j < N; j++) {
                bottom = findBottom(dice, j, topNum);
                topNum = dice[j][diceNum[bottom]];

                max = findMax(dice, j, bottom);
                totalMax += max;
            }
            result = Math.max(result, totalMax);
        }

        System.out.println(result);
    }

    // 옆면의 최댓값 찾기
    public static int findMax(int[][] dice, int i, int bottom) {
        int max = 0;

        for (int j = 0; j < 6; j++) {
            if (j == bottom || j == diceNum[bottom]) {
                continue;
            }
            if (dice[i][j] > max) {
                max = dice[i][j];
            }
        }
        return max;
    }

    // 윗면의 숫자와 같은 아랫면 숫자의 index 찾기
    public static int findBottom(int[][] dice, int i, int topNum) {
        int bottom = 0;

        for (int j = 0; j < 6; j++) {
            if (dice[i][j] == topNum) {
                bottom = j;
                break;
            }
        }
        return bottom;
    }
}

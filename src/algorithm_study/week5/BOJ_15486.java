package src.algorithm_study.week5;

/*
    백준 15486 퇴사 2 (https://www.acmicpc.net/problem/15486)

    # 시간 제한
    2초

    # 문제
    상담원으로 일하고 있는 백준이는 퇴사를 하려고 한다.
    오늘부터 N+1일째 되는 날 퇴사를 하기 위해서, 남은 N일 동안 최대한 많은 상담을 하려고 한다.
    백준이는 비서에게 최대한 많은 상담을 잡으라고 부탁을 했고, 비서는 하루에 하나씩 서로 다른 사람의 상담을 잡아놓았다.
    각각의 상담은 상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi로 이루어져 있다.

    상담을 적절히 했을 때, 백준이가 얻을 수 있는 최대 수익을 구하는 프로그램을 작성하시오.

    # 입력
    첫째 줄에 N (1 ≤ N ≤ 1,500,000)이 주어진다.
    둘째 줄부터 N개의 줄에 Ti와 Pi가 공백으로 구분되어서 주어지며, 1일부터 N일까지 순서대로 주어진다. (1 ≤ Ti ≤ 50, 1 ≤ Pi ≤ 1,000)

    # 출력
    첫째 줄에 백준이가 얻을 수 있는 최대 이익을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N + 1];
        int[] price = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i <= N; i++) {
            max = Math.max(max, dp[i]);

            int doneTime = i + time[i];

            if (doneTime <= N) {
                dp[doneTime] = Math.max(max + price[i], dp[doneTime]);
            }
        }

        System.out.println(max);
    }
}

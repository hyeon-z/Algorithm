package src.algorithm_study.week3;

/*
    백준 12865 평범한 배낭 (https://www.acmicpc.net/problem/12865)

    # 시간 제한
    2초

    # 문제
    이 문제는 아주 평범한 배낭에 관한 문제이다.
    한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다.
    세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.
    준서가 여행에 필요하다고 생각하는 N개의 물건이 있다.
    각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
    아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
    준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.

    # 입력
    첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.
    두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
    입력으로 주어지는 모든 수는 정수이다.

    # 출력
    한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] knapsack = new int[N + 1][2];

        // 배낭에 넣을 수 있는 물건 정보 저장
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            knapsack[i][0] = Integer.parseInt(st.nextToken());
            knapsack[i][1] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] : 최대 무게가 j인 배낭에 1~i번째 까지의 물건들을 담아서 만들 수 있는 가치의 최댓값
        int dp[][] = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int w = knapsack[i][0];
                int v = knapsack[i][1];

                // 무게가 남거나 딱 맞는 경우
                if (j - w >= 0) {
                    dp[i][j] = Math.max(v + dp[i - 1][j - w], dp[i - 1][j]);
                } else {
                    // 무게가 부족한 경우
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}

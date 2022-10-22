package src.do_it_algorithm.data_structure.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    Do It 알고리즘 코딩 테스트 003
    백준 11659 구간 합 구하기 4 (https://www.acmicpc.net/problem/11659)

    #문제
    수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

    #입력
    첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

    #출력
    M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

    #제한
    1 ≤ N ≤ 100,000
    1 ≤ M ≤ 100,000
    1 ≤ i ≤ j ≤ N
 */
public class BOJ_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기값 0으로 채워짐
        int[] S = new int[N+1];

        int s, e;

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++){
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            System.out.println(S[e] - S[s-1]);
        }
    }
}

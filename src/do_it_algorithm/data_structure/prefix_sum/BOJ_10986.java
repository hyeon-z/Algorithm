package src.do_it_algorithm.data_structure.prefix_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    Do It 알고리즘 코딩 테스트 005
    백준 10986 나머지 합 (https://www.acmicpc.net/problem/10986)

    #문제
    수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.

    즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

    #입력
    첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)

    둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)

    #출력
    첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
 */
public class BOJ_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N];
        long[] C = new long[M];
        int remainder;
        long result = 0;

        st = new StringTokenizer(bf.readLine());

        // 합 배열
        S[0] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++){
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            remainder = (int) (S[i] % M);
            if(remainder == 0) result += 1;
            C[remainder] += 1;
        }

        for(int i = 0; i < M; i++) {
            if(C[i] > 1) result = result + C[i] * (C[i] - 1) / 2;
        }

        System.out.println(result);
    }
}
package src.algorithm_study.week2;

/*
    백준 2878 캔디캔디 (https://www.acmicpc.net/problem/2878)

    # 시간 제한
    1초

    # 문제
    오늘 사탕 M개를 가득 담은 박스가 택배로 택희네 집에 도착했다. 택희는 이 사탕을 N명의 친구들에게 나누어 주려고 한다.
    택희의 친구들은 문자로 사탕을 몇 개 받고 싶은지 보냈다. 만약 받고 싶은 개수만큼 사탕을 받지 못한다면, 그 친구는 분노하게 되고, 못 받는 개수가 많아질 수록 더욱 분노하게 된다.
    놀랍게도 택희는 친구들의 분노를 수치화 할 수 있는데, 이것은 못 받는 사탕 개수의 제곱이다.
    예를 들어, 택희의 친구 백준이가 받고 싶은 사탕의 개수가 32개였을 때, 사탕을 29개 받아 3개를 받지 못한다면, 그의 분노는 3의 제곱 9가 된다.
    택희가 받은 사탕의 개수와 친구의 수, 그리고 그 친구들이 받고 싶어하는 사탕의 개수가 주어졌을 때, 사탕을 적절히 나누어 주어 친구들의 분노의 합을 최소화해 그 값을 출력하는 프로그램을 작성하시오.

    # 입력
    첫째 줄에 M(1 ≤ M ≤ 2×10^9)와 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 친구들이 받고 싶어하는 사탕의 개수가 주어진다.
    이 개수는 2×10^9보다 작으며, 친구들이 받고 싶어하는 사탕의 개수의 합은 항상 M을 넘는다.

    # 출력
    첫째 줄에 택희 친구들의 분노의 합의 최솟값을 2^64로 나눈 나머지를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2878 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] friends = new long[N];
        long sum = 0;

        for (int i = 0; i < N; i++) {
            friends[i] = Integer.parseInt(br.readLine());
            sum += friends[i];
        }

        Arrays.sort(friends);

        long count = sum - M;
        long anger = 0;

        // 최대한 균등하게 분배
        for (long friend : friends) {
            long candy = Math.min(friend, count / N--);
            anger += candy * candy;
            count -= candy;
        }

        System.out.println(anger % (long) Math.pow(2, 64));
    }
}

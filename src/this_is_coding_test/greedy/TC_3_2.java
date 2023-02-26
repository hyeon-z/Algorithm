package src.this_is_coding_test.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    이것이 코딩테스트다 3-2
    숫자 카드 게임 (https://hyeon-z.tistory.com/2)

    # 시간 제한
    1초

    # 문제
    숫자 카드 게임은 여러 개의 숫자 카드 중에서 가장 높은 숫자가 쓰인 카드 한 장을 뽑는 게임이다.
    단，게임의 룰을 지키며 카드를 뽑아야 하고 룰은 다음과 같다.

    1. 숫자가 쓰인 카드들이 N X M 형태로 놓여 있다. 이때 N은 행의 개수를 의미하며, M은 열의 개수를 의미한다.
    2. 먼저 뽑고자 하는 카드가 포함되어 있는 행을 선택한다.
    3. 그다음 선택된 행에 포함된 카드들 중 가장 숫자가 낮은 카드를 뽑아야 한다.
    4. 따라서 처음에 카드를 골라낼 행을 선택할 때，이후에 해당 행에서 가장 숫자가 낮은 카드를 뽑을 것을 고려하여 최종적으로 가장 높은 숫자의 카드를 뽑을 수 있도록 전략을 세워야 한다.

    카드들이 N x M 형태로 놓여 있을 때，게임의 룰에 맞게 카드를 뽑는 프로그램을 만드시오.

    # 입력
    - 첫째 줄에 숫자 카드들이 놓인 행의 개수 N과 열의 개수 M이 공백을 기준으로 하여 각각 자연수로 주어진다. (1 < N,M < 100)
    - 둘째 줄부터 N개의 줄에 걸쳐 각 카드에 적힌 숫자가 주어진다. 각 숫자는 1 이상 10,000 이하의 자연수이다

    # 출력
    첫째 줄에 게임의 룰에 맞게 선택한 카드에 적힌 숫자를 출력한다.
 */

public class TC_3_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nMin = 10001;

            for (int j = 0; j < M; j++) {
                nMin = Math.min(nMin, Integer.parseInt(st.nextToken()));
            }
            max = Math.max(max, nMin);
        }

        System.out.println(max);
    }
}
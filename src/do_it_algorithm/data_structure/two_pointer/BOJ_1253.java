package src.do_it_algorithm.data_structure.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    Do It 알고리즘 코딩 테스트 008
    백준 1253 좋다 (https://www.acmicpc.net/problem/1253)

    #시간 제한
    2초

    #문제
    N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
    N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
    수의 위치가 다르면 값이 같아도 다른 수이다.

    #입력
    첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

    #출력
    좋은 수의 개수를 첫 번째 줄에 출력한다.

    #주의 사항
    문제 조건 잘 확인하기!!
    Ai의 조건은 |Ai| ≤ 1,000,000,000로 음수가 가능하다. 또한 수의 위치가 다르면 값이 같아도 다른 수이므로 같은 수가 여러번 나올 수 있다.
    ex) -2 0 3 5 인 경우 (-2 + 5 = 3) 이렇게 이미 좋은 수인지 판별한 수도 다른 수의 합이 될 수 있다.
    처음에는 같은 값이 존재하는 경우를 생각하지 않아서 틀렸고 그 다음은 모두 양수일 것이라고 생각하고 좋은 수로 판별한 수를 그 다음 연산에서 제외시켜서 틀렸다.
 */
public class BOJ_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] A = new int[N];

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int target, s, e;
        int cnt = 0;

        for(int i = 0; i < N; i++){
            target = A[i];
            s = 0;
            e = N-1;

            while(s < e) {
                if (A[s] + A[e] == target) {
                    if (s == i) {
                        s++;
                    }
                    else if (e == i) {
                        e--;
                    }
                    else {
                        cnt++;
                        break;
                    }
                } else if (A[s] + A[e] < target) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println(cnt);
    }
}

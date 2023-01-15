package src.do_it_algorithm.data_structure.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    Do It 알고리즘 코딩 테스트 009
    백준 12891 DNA 비밀번호 (https://www.acmicpc.net/problem/12891)

    #시간 제한
    2초

    #문제
    평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다. 예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.
    하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다. 그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
    임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자. 이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
    민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.

    #입력
    첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
    두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
    세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다. 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.

    #출력
    첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.

    #주의 사항
    P와 S의 길이가 1,000,000으로 매우 크기 때문에 O(n)의 시간 복잡도 알고리즘으로 문제를 해결해야한다.
    매번 DNA 문자열의 문자 개수를 구하는 것이 아니라 앞 뒤의 문자만 빼고 더하면 된다.
 */
public class BOJ_12891 {
    static int myCount[];
    static int limitCount[];
    static int checkLimit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] dnaArr = br.readLine().toCharArray();
        limitCount = new int[4];  // 부분 문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수 배열
        myCount = new int[4];

        st = new StringTokenizer(br.readLine());

        checkLimit = 0;  // 몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수
        int result = 0;

        for (int i = 0; i < 4; i++) {
            limitCount[i] = Integer.parseInt(st.nextToken());
            if (limitCount[i] == 0) {
                checkLimit++;
            }
        }

        for (int i = 0; i < p; i++) {
            add(dnaArr[i]);
        }

        if (checkLimit == 4) {
            result++;
        }

        for (int i = p; i < s; i++) {
            int j = i - p;

            add(dnaArr[i]);
            remove(dnaArr[j]);

            if (checkLimit == 4) {
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void remove(char ch) {
        if (ch == 'A') {
            if (myCount[0] == limitCount[0]) {
                checkLimit--;
            }
            myCount[0] -= 1;
        } else if (ch == 'C') {
            if (myCount[1] == limitCount[1]) {
                checkLimit--;
            }
            myCount[1] -= 1;
        } else if (ch == 'G') {
            if (myCount[2] == limitCount[2]) {
                checkLimit--;
            }
            myCount[2] -= 1;
        } else if (ch == 'T') {
            if (myCount[3] == limitCount[3]) {
                checkLimit--;
            }
            myCount[3] -= 1;
        }
    }

    private static void add(char ch) {
        if (ch == 'A') {
            myCount[0] += 1;
            if (myCount[0] == limitCount[0]) {
                checkLimit++;
            }
        } else if (ch == 'C') {
            myCount[1] += 1;
            if (myCount[1] == limitCount[1]) {
                checkLimit++;
            }
        } else if (ch == 'G') {
            myCount[2] += 1;
            if (myCount[2] == limitCount[2]) {
                checkLimit++;
            }
        } else if (ch == 'T') {
            myCount[3] += 1;
            if (myCount[3] == limitCount[3]) {
                checkLimit++;
            }
        }
    }
}

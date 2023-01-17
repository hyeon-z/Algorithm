package src.do_it_algorithm.data_structure.sliding_window;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
    Do It 알고리즘 코딩 테스트 0010
    백준 11003 최솟값 찾기 (https://www.acmicpc.net/problem/11003)

    #시간 제한
    2.6초

    #문제
    N개의 수 A1, A2, ..., AN과 L이 주어진다.
    Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.

    #입력
    첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
    둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)

    #출력
    첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.

    #주의 사항
    일반적으로 정렬은 nlog(n)의 시간 복잡도를 가지므로 O(n)의 시간 복잡도를 가져야하는 이번 문제에서는 사용할 수 없다.
 */
public class BOJ_11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.getLast().value > now) {
                deque.removeLast();
            }

            deque.addLast(new Node(i, now));

            if (i - deque.getFirst().index >= l) {
                deque.removeFirst();
            }

            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

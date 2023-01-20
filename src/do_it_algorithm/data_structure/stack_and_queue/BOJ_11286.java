package src.do_it_algorithm.data_structure.stack_and_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
    Do It 알고리즘 코딩 테스트 014
    백준 11286 절댓값 힙 (https://www.acmicpc.net/problem/11286)

    #시간 제한
    2초

    #문제
    댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
    1. 배열에 정수 x (x ≠ 0)를 넣는다.
    2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
       절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
    프로그램은 처음에 비어있는 배열에서 시작하게 된다.

    #입력
    첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
    만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
    x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
    입력되는 정수는 -2^31보다 크고, 2^31보다 작다.

    #출력
    입력에서 0이 주어진 회수만큼 답을 출력한다.
    만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.

    # 중요 개념
    우선 순위 큐, Comparator(T o1, T o2)
 */
public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            // 절댓값이 작은 데이터 우선
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);

            if (firstAbs != secondAbs) {
                return firstAbs - secondAbs;
            }

            // 절대값이 같은 경우 음수 우선
            else {
                return o1 > o2 ? 1 : -1;
            }
        }
        ));

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            /*
                절댓값이 가장 작은 값(같다면 작은 수)출력, 배열에서 제거
                배열이 비어있는 경우는 0 출력
             */
            if (x == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
            }
            // 배열에 x라는 값 추가
            else {
                priorityQueue.add(x);
            }
        }
        System.out.println(sb);
    }
}
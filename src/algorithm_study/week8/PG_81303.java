package src.algorithm_study.week8;

import java.util.Stack;

/*
    프로그래머스 Level3 81303 표 편집 (https://school.programmers.co.kr/learn/courses/30/lessons/81303)
 */

public class PG_81303 {
    public static void main(String[] args) {
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        System.out.println(solution(8, 2, cmd));
    }

    public static String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleteOrder = new Stack<>();
        boolean[] delete = new boolean[n];
        int lastIndex = n - 1;

        for (String st : cmd) {
            String[] split = st.split(" ");

            if (split[0].equals("U")) {
                int num = Integer.parseInt(split[1]);
                int count = 0;

                while (count < num) {
                    if (!delete[--k]) {
                        count++;
                    }
                }

                continue;
            }

            if (split[0].equals("D")) {
                int num = Integer.parseInt(split[1]);
                int count = 0;

                while (count < num) {
                    if (!delete[++k]) {
                        count++;
                    }
                }

                continue;
            }

            if (split[0].equals("C")) {
                delete[k] = true;
                deleteOrder.push(k);

                // 마지막 행
                if (k == lastIndex) {
                    while (delete[k]) {
                        k--;
                    }
                    lastIndex = k;
                } else {
                    while (delete[k]) {
                        k++;
                    }
                }

                continue;
            }

            if (split[0].equals("Z")) {
                int recentDelete = deleteOrder.pop();

                lastIndex = Math.max(lastIndex, recentDelete);

                delete[recentDelete] = false;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (boolean del : delete) {
            if (!del) {
                sb.append("O");
                continue;
            }

            sb.append("X");
        }

        return sb.toString();
    }
}

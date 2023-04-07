package src.algorithm_study.week4;

import java.util.ArrayList;
import java.util.Scanner;

/*
    프로그래머스 84512 모음사전 (https://school.programmers.co.kr/learn/courses/30/lessons/84512)

    # 문제
    사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
    단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.

    # 제한 사항
    - word의 길이는 1 이상 5 이하입니다.
    - word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
 */

public class PG_84512 {
    static ArrayList<String> dic = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(solution(s));
    }

    public static int solution(String word) {
        dfs("", 0);

        return dic.indexOf(word);
    }

    public static void dfs(String word, int depth) {
        String[] alphabet = {"A", "E", "I", "O", "U"};
        dic.add(word);

        for (int i = 0; i < 5; i++) {
            if (depth == 5) {
                return;
            }

            dfs(word + alphabet[i], depth + 1);
        }
    }
}

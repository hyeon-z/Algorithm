package src.algorithm_study.week7;

import java.util.*;

/*
    프로그래머스 92334 신고 결과 받기 (https://school.programmers.co.kr/learn/courses/30/lessons/92334)
 */

public class PG_92334 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        // 한 사람 여러번 신고하는 경우 제외
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        Map<String, Set<String>> user = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();

        for (String re : reportSet) {
            String[] splitRe = re.split(" ");

            String reporter = splitRe[0];  // 신고한 사람
            String reported = splitRe[1];  // 신고 당한 사람

            // 신고 당한 횟수 count
            reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);

            // 신고 당한 사람에 따른 신고자 리스트 업데이트
            Set<String> reportedSet = user.getOrDefault(reporter, new HashSet<>());
            reportedSet.add(reported);

            user.put(reporter, reportedSet);
        }

        int[] result = new int[id_list.length];

        // id별 신고 메일 횟수 체크
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            Set<String> reported = user.getOrDefault(id, new HashSet<String>());

            int count = 0;

            for (String name : reported) {
                if (reportCount.getOrDefault(name, 0) >= k) {
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }
}

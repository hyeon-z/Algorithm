package src.algorithm_study.week7;

import java.util.*;

/*
    프로그래머스 92341 주차요금 계산 (https://school.programmers.co.kr/learn/courses/30/lessons/92341)
 */

public class PG_92341 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> carTime = new HashMap<>();
        Map<String, Integer> carTotalTime = new HashMap<>();

        int basicTime = fees[0];
        int basicMoney = fees[1];
        int divideTime = fees[2];
        int divideMoney = fees[3];


        for (String record : records) {
            String[] r = record.split(" ");

            String time = r[0];  // 시각
            String carNum = r[1];  // 차량 번호
            String info = r[2];  // 내역


            // 입차하는 경우 (IN)
            if (info.equals("IN")) {
                carTime.put(carNum, time);
                continue;
            }

            // 출차하는 경우 (OUT)
            int outMin = timeToMinute(time);  // 출차시간
            int inMin = timeToMinute(carTime.get(carNum));  // 입차시간

            int parkingTime = outMin - inMin;

            // 이미 주차장을 사용한 경우
            if (carTotalTime.containsKey(carNum)) {
                carTotalTime.put(carNum, carTotalTime.get(carNum) + parkingTime);
            }

            // 처음 주차장을 사용하는 경우
            else {
                carTotalTime.put(carNum, parkingTime);
            }

            // 출차한 경우 - carTime HashMap에서 제거
            carTime.remove(carNum);
        }

        // 출차된 내역이 없는 차량 - 23:59에 출차
        for (String carNum : carTime.keySet()) {
            int outMin = timeToMinute("23:59");
            int inMin = timeToMinute(carTime.get(carNum));

            int parkingTime = outMin - inMin;

            // 이미 주차장을 사용한 경우
            if (carTotalTime.containsKey(carNum)) {
                carTotalTime.put(carNum, carTotalTime.get(carNum) + parkingTime);
            }

            // 처음 주차장을 사용하는 경우
            else {
                carTotalTime.put(carNum, parkingTime);
            }
        }

        // 주차 요금 계산
        Map<String, Integer> sortCarTotalTime = new TreeMap<>(carTotalTime);  // 차량번호 정렬
        List<Integer> result = new ArrayList<>();

        for (String carNum : sortCarTotalTime.keySet()) {
            int totalTime = sortCarTotalTime.get(carNum);

            // 주차시간이 기본시간보다 적을 때
            if (totalTime <= basicTime) {
                result.add(basicMoney);
            }


            // 주차시간이 기본시간을 초과할 때
            else {
                result.add(basicMoney + (int) Math.ceil((double) (totalTime - basicTime) / divideTime) * divideMoney);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    public static int timeToMinute(String time) {
        String[] splitTime = time.split(":");  // 05:34

        int hour = Integer.parseInt(splitTime[0]);  // 5
        int minute = Integer.parseInt(splitTime[1]);  // 34

        return 60 * hour + minute;  // 5 * 60 + 34
    }
}

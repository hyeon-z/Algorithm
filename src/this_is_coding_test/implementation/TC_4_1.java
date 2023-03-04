package src.this_is_coding_test.implementation;

import java.io.IOException;
import java.util.Scanner;

/*
    이것이 코딩테스트다 4-1
    왕실의 나이트 (https://hyeon-z.tistory.com/4)

    # 시간 제한
    1초

    # 문제
    행복 왕국의 왕실 정원은 체스판과 같은 8 X 8 좌표 평면이다.
    왕실 정원의 특정한 한 칸에 나이트가 서 있다.
    나이트는 매우 충성스러운 신하로서 매일 무술을 연마한다.
    나이트는 말을 타고 있기 때문에 이동을 할 때는 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
    나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.

    1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
    2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기

    이처럼 8 X 8 좌표 평면상에서 나이트의 위치가 주어졌을 때 나이트가 이동할 수 있는 경우의 수를 출력하는 프로그램을 작성하시오.
    이때 왕실의 정원에서 행 위치를 표현할 때는 1부터 8로 표현하며, 열 위치를 표현할 때는 a부터 h로 표현한다.

    # 입력
    첫째 줄에 8 x 8 좌표 평면상에서 현재 나이트가 위치한 곳의 좌표를 나타내는 두 문자로 구성된 문자열이 입력된다.
    입력 문자는 a1 처럼 열과 행으로 이뤄진다.

    # 출력
    첫째 줄에 나이트가 이동할수 있는 경우의 수를 출력하사오.
 */

public class TC_4_1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int column = input.charAt(0) - 'a' + 1;
        int row = input.charAt(1) - '0';
        int count = 0;

        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};

        for (int i = 0; i < dx.length; i++) {
            int nx = column + dx[i];
            int ny = row + dy[i];

            if (nx < 1 || nx > 8 || ny < 1 || ny > 8)
                continue;

            count++;
        }
        System.out.println(count);
    }
}
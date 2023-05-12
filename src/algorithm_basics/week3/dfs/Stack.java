package src.algorithm_basics.week3.dfs;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        // 인접리스트
        graph = new ArrayList<>() {{
            add(new ArrayList<>(List.of()));
            add(new ArrayList<>(List.of(2, 3, 8)));
            add(new ArrayList<>(List.of(1, 7)));
            add(new ArrayList<>(List.of(1, 4, 5)));
            add(new ArrayList<>(List.of(3, 5)));
            add(new ArrayList<>(List.of(3, 4)));
            add(new ArrayList<>(List.of(7)));
            add(new ArrayList<>(List.of(2, 6, 8)));
            add(new ArrayList<>(List.of(1, 7)));
        }};

        visited = new boolean[graph.size()];

        System.out.println(dfs(1));
    }

    static String dfs(int start) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        boolean hasNext;

        stack.push(start);
        visited[start] = true;
        result.add(start);

        while (!stack.isEmpty()) {
            Integer top = stack.peek();
            hasNext = false;

            for (int i = 0; i < graph.get(top).size(); i++) {
                int num = graph.get(top).get(i);

                if (!visited[num]) {
                    stack.push(num);
                    visited[num] = true;
                    hasNext = true;
                    result.add(num);
                    break;
                }
            }

            // 방문하지 않은 인접노드가 없는 경우
            if (!hasNext) {
                stack.pop();
            }
        }
        return result.toString();
    }
}

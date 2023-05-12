package src.algorithm_basics.week3.dfs;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
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

        visited[start] = true;
        result.add(start);

        for (int i = 0; i < graph.get(start).size(); i++) {
            int num = graph.get(start).get(i);

            if (!visited[num]) {
                dfs(num);
            }
        }
        return result.toString();
    }
}

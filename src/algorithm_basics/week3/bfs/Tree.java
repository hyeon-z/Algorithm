package src.algorithm_basics.week3.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Tree {
    public static void main(String[] args) {
        /*
                 1
                 /\
                2  3
                /\ /\
               4 5 6 7
         */

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        System.out.println(bfs(node));
    }

    static String bfs(Node rootNode) {
        Queue<Node> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        q.offer(rootNode);

        while (!q.isEmpty()) {
            Node node = q.poll();
            result.add(node.value);

            if (node.left != null) {
                q.offer(node.left);
            }

            if (node.right != null) {
                q.offer(node.right);
            }
        }

        return result.toString();
    }
}

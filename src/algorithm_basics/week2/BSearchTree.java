package src.algorithm_basics.week2;

class BTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node rootNode;

    public Node search(int data) {
        return search(rootNode, data);
    }

    private Node search(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key) {
            return root;
        }
        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public void insert(int data) {
        rootNode = insert(rootNode, data);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // 새로 들어온 값이 루트보다 작은 경우 (왼쪽에 삽입)
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        // 새로 들어온 값이 루트보다 큰 경우(오른쪽에 삽입)
        else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void delete(int data) {
        rootNode = delete(rootNode, data);
    }

    private Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }

        // 삭제할 값이 루트보다 작은 경우 (왼쪽 서브트리 탐색)
        if (data < root.data) {
            root.left = delete(root.left, data);
        }
        // 삭제할 값이 루트보다 큰 경우(오른쪽 서브트리 탐색)
        else if (data > root.data) {
            root.right = delete(root.right, data);
        }
        // 삭제하려는 대상을 찾은 경우
        else {
            // 삭제할 노드: 자식 x
            if (root.left == null && root.right == null) {
                return null;
            }
            // 삭제할 노드: 자식 1 (오른쪽)
            else if (root.left == null) {
                return root.right;
            }
            // 삭제할 노드: 자식 1 (왼쪽)
            else if (root.right == null) {
                return root.left;
            }

            // 삭제할 노드: 자식 2
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    // 삭제하는 노드의 오른쪽 자식 노드에서 가장 작은 노드 찾기
    int findMin(Node root) {
        int min = root.data;

        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public void inorder() {
        inorder(rootNode);
        System.out.println("");
    }

    // 중위 순회 출력
    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}

class BSearchTree {
    public static void main(String[] args) {
        BTree tree = new BTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(10);
        tree.insert(1);
        tree.insert(6);
        tree.insert(4);
        tree.insert(7);
        tree.insert(14);
        tree.insert(13);

        tree.inorder();  // 1 3 4 6 7 8 10 13 14
        tree.delete(8);  // 1 3 4 6 7 10 13 14
        tree.inorder();

        if (tree.search(16) == null) {
            System.out.println("탐색 실패");  // 탐색 실패
        }
    }
}

package src.algorithm_basics.week1;

import java.util.Stack;

/*
    스택 2개로 큐 만들기
 */
class QStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int n) {
        stack1.push(n);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}

public class TwoStackQueue {
    public static void main(String[] args) {
        QStack qStack = new QStack();

        qStack.enqueue(1);
        qStack.enqueue(2);

        System.out.println(qStack.dequeue());

        qStack.enqueue(3);

        System.out.println(qStack.dequeue());

        qStack.enqueue(4);

        System.out.println(qStack.dequeue());
        System.out.println(qStack.dequeue());
    }
}

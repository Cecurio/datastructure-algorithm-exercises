package cn.cecurio.algorithm.exercise;


import java.util.Stack;

class MyQueue {
    private Stack<Integer> stackPush;

    private Stack<Integer> stackPop;

    public MyQueue() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void add(Integer item) {
        stackPush.push(item);
    }

    public Integer poll() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        if (stackPop.empty()) {
            throw new RuntimeException("Your Stack is empty.");
        }
        return stackPop.pop();
    }

    public Integer peek() {
        if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
        if (stackPop.empty()) {
            throw new RuntimeException("Your Stack is empty.");
        }
        return stackPop.peek();
    }
}

/**
 * @author: Cecurio
 * @create: 2018-04-07 12:28
 **/
public class Exercise2 {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.poll();

        queue.add(4);
        queue.add(5);
        queue.add(6);

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

    }
}

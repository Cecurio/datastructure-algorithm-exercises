package cn.cecurio.algorithm.exercise;

/*
实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。

## 要求

1. pop、 push、getMin操作的时间复杂度都是O(1)
2. 设计的栈类型可以使用现成的栈结构
 */

import java.util.Stack;

class SimpleStack {
    private Stack<Integer> stackData;
    // 用stackMin保存每一步的最小值
    private Stack<Integer> stackMin;

    public SimpleStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(Integer item) {
        if (this.stackData.empty()) {
            stackMin.push(item);
        } else {
            if (item <= stackMin.peek()) {
                stackMin.push(item);
            }
        }
        stackData.push(item);
    }

    public Integer pop() {
        if (this.stackData.empty()) {
            throw new RuntimeException("your stackData is empty");
        }
        if (stackData.peek() == stackMin.peek()) {
            stackMin.pop();
            return stackData.pop();
        } else {
            return stackData.pop();
        }
    }

    public Integer getMin() {
        if (this.stackMin.empty()) {
            throw new RuntimeException("your stackMin is empty");
        }
        return this.stackMin.peek();
    }
}

class SimpleStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public SimpleStack2() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(Integer item) {
        if (this.stackData.empty()) {
            stackMin.push(item);
        } else {
            if (item < stackMin.peek()) {
                stackMin.push(item);
            } else {
				stackMin.push(stackMin.peek());
            }
        }
        stackData.push(item);
    }

    public Integer pop() {
        if (this.stackData.empty()) {
            throw new RuntimeException("your stackData is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public Integer getMin() {
        if (this.stackMin.empty()) {
            throw new RuntimeException("your stackMin is empty");
        }
        return this.stackMin.peek();
    }
}

/**
 * @author: Cecurio
 * @create: 2018-04-07 11:51
 **/
public class Exercise1 {
    public static void main(String[] args) {
        testSimpleStack();
        testSimpleStack2();
    }

    public static void testSimpleStack() {
        SimpleStack simpleStack = new SimpleStack();

        simpleStack.push(11111);
        simpleStack.push(78888);
        simpleStack.push(4343);
        simpleStack.push(-22222);
        simpleStack.push(543);

        try {
            while (simpleStack.getMin() != null) {
                System.out.println(simpleStack.pop());
            }
        } catch (Exception e) {
            // do nothing
        }
    }

    public static void testSimpleStack2() {
        SimpleStack2 simpleStack2 = new SimpleStack2();

        Integer[] values = {3,4,5,1,2,1};

        for (int i = 0; i < values.length; i++) {
            Integer integer = values[i];
            simpleStack2.push(integer);
        }

        try {
            while (simpleStack2.getMin() != null) {
                System.out.println(simpleStack2.pop());
            }
        } catch (Exception e) {
            // do nothing
        }
    }
}

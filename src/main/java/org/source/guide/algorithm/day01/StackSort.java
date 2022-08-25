package org.source.guide.algorithm.day01;

import java.util.Stack;

public class StackSort {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        Stack<Integer> helper = new Stack<>();

        while (!stack.isEmpty()){
            Integer current = stack.pop();
            while (!helper.isEmpty() && helper.peek() < current){
                stack.push(helper.pop());
            }
            helper.push(current);
        }

        while (!helper.isEmpty()){
            stack.push(helper.pop());
        }
        System.out.println(stack.peek());




    }
}

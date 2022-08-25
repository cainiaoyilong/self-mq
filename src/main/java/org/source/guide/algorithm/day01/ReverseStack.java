package org.source.guide.algorithm.day01;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);

        System.out.println();
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverse(stack);

        while (!stack.isEmpty()){
            System.out.print(stack.pop()+",");
        }


    }


    public int getLastElement(Stack<Integer> stack){
        Integer result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }
        int lastElement = getLastElement(stack);
        stack.push(result);
        return lastElement;
    }

    public void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int lastElement = getLastElement(stack);
        reverse(stack);
        stack.push(lastElement);
    }


}

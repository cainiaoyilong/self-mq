package org.source.guide.algorithm.day01;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> minStack = new Stack<>();

    private Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(5);
        minStack.push(1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.poll());
        System.out.println(minStack.getMin());

        System.out.println(minStack.poll());
        System.out.println(minStack.getMin());


    }

   public void push(int num){
        if(minStack.isEmpty() || minStack.peek() >= num){
            minStack.push(num);
        }else{
            minStack.push(minStack.peek());
        }
        stack.push(num);
   }

   public int poll(){
      if(!stack.isEmpty()){
          Integer pop = stack.pop();
          minStack.pop();
          return pop;
      }else{
          throw new RuntimeException("stack is empty");
      }
   }

   public int getMin(){
       if(!minStack.isEmpty()){
           return minStack.peek();
       }
       throw new RuntimeException("stack is empty");
   }


}

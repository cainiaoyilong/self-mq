package org.source.guide.algorithm.day01;

import java.util.ArrayDeque;
import java.util.Queue;

public class CatAndDogQueue {
    public static void main(String[] args) {
        CatAndDogQueue catAndDogQueue = new CatAndDogQueue();
        catAndDogQueue.add("dog");
        catAndDogQueue.add("cat");
        catAndDogQueue.add("cat");
        catAndDogQueue.add("dog");
        catAndDogQueue.add("cat");
        catAndDogQueue.add("dog");
        catAndDogQueue.getDog();

        catAndDogQueue.getCat();
        catAndDogQueue.get();
        catAndDogQueue.getCat();

        catAndDogQueue.get();


    }


    private Queue<Dog> dogQueue = new ArrayDeque<>();

    private Queue<Cat> catQueue = new ArrayDeque<>();

    private int count = 0;

    public void add(String type){
        if("dog".equals(type)){
            dogQueue.add(new Dog(count++,type));
        }
        if("cat".equals(type)){
            catQueue.add(new Cat(count++,type));
        }
    }
    public void getCat(){
        if(!catQueue.isEmpty()){
            System.out.println("cat"+catQueue.poll().getCount());
        }
    }

    public void getDog(){
        if(!dogQueue.isEmpty()){
            System.out.println("dog"+dogQueue.poll().getCount());
        }
    }

    public void get(){
        if(!dogQueue.isEmpty() && !catQueue.isEmpty()){
            if(dogQueue.peek().getCount() < catQueue.peek().getCount()){
                System.out.println("dog"+dogQueue.poll().getCount());
            }else{
                System.out.println("cat"+catQueue.poll().getCount());

            }
        }else{
            if(!dogQueue.isEmpty()){
                System.out.println("dog"+dogQueue.poll().getCount());
            }
            if(!catQueue.isEmpty()){
                System.out.println("cat"+catQueue.poll().getCount());
            }
        }
    }

}


class Animal{
    protected int count;

    protected String type;

    public Animal(int count,String type) {
        this.type = type;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Dog extends Animal{

    public Dog(int count,String type) {
        super(count,type);
    }
}

class Cat extends Animal{

    public Cat(int count,String type) {
        super(count,type);
    }
}
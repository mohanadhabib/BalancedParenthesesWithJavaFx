package com.example.test;
class Node {
    public char value;
    public Node next;
}
class Stack {
    private Node top;
    public Stack(){
        top = null;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public void push(char element){
        Node newNode = new Node();
        newNode.value = element;
        newNode.next = top;
        top = newNode;
    }
    public void pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
        }
        else{
          top = top.next;
        }
    }
    public char getTop(){
        return top.value;
    }
}

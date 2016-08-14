// : c11:StackL.java
// Making a stack from a LinkedList.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

import java.util.LinkedList;

public class StackL {

  private LinkedList list = new LinkedList();

  public void push(Object v) {
    list.addFirst(v);
  }

  public Object top() {
    return list.getFirst();
  }

  public Object pop() {
    return list.removeFirst();
  }
/*
  public static void main(String[] args) {
    StackL stack = new StackL();
    for (int i = 0; i < 10; i++)
      stack.push(new Integer(i));
    System.out.println(stack.top());
    System.out.println(stack.top());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }*/
} ///:~
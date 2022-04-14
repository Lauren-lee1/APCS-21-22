// TNPG: NGL -- Nafiz Labib, Gabriel Thompson, Lauren Lee
// APCS pd8
// HW91: Deque the Halls
// 2022-04-13
// time spent: 0.3 hr

import java.util.LinkedList;

public class NGL<T> implements Deque<T>{

  LinkedList deq;

  public NGL(){
    deq = new LinkedList<T>();
  }

  public T removeFirst(){
    return (T) deq.removeFirst();
  }
  public T removeLast(){
    return (T) deq.removeLast();

  }

  public void addFirst( T x ){
    deq.addFirst(x);
  }
  public void addLast( T x ){
    deq.addLast(x);
  }

  public boolean isEmpty(){
    return deq.size() == 0;
  }

  public T getFirst(){
    return (T) deq.getFirst();
  }

  public T getLast(){
    return (T) deq.getLast();
  }

  public T pollFirst(){
    if (deq.isEmpty()){
      return null;
    }
    return (T) deq.removeFirst();
  }

  public T pollLast(){
    if (deq.isEmpty()){
      return null;
    }
    return (T) deq.removeLast();
  }
}

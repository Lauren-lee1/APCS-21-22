import java.util.LinkedList;

public class YourImplementationOfDeque<T> implements Deque<T>{

  LinkedList deq;

  public YourImplementationOfDeque(){
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

  public static void main(String[] args) {
    YourImplementationOfDeque<String> q = new YourImplementationOfDeque<String>();
    q.addFirst("There");
    q.addFirst("Hello");
    System.out.println(q.getFirst()); // "Hello"
    System.out.println(q.getLast()); // "There"
    q.addLast("Fellow");
    q.addLast("Human");
    q.removeFirst();
    q.removeLast();
    System.out.println(q.isEmpty());   // false
    System.out.println(q.getFirst()); // "There"
    System.out.println(q.getLast()); // "Fellow"
    q.removeFirst();
    q.removeLast();
    System.out.println(q.isEmpty());   // true
  }

}

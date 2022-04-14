// TNPG: NGL -- Nafiz Labib, Gabriel Thompson, Lauren Lee
// APCS pd8
// HW91: Deque the Halls
// 2022-04-13
// time spent: 0.3 hr

public class Driver{

  public static void main(String[] args) {
    NGL<String> q = new NGL<String>();
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
    System.out.println(q.pollFirst()); // null
    q.addFirst("Gabriel");
    q.addLast("Nafiz");
    q.addLast("Lauren");
    System.out.println(q.pollFirst()); // Gabriel
    System.out.println(q.pollLast()); // Lauren
    System.out.println(q.pollLast()); // Nafiz
    System.out.println(q.pollLast()); // null



  }

}

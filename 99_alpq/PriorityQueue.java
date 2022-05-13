public interface PriorityQueue{
    /*
    adds an item to this priority queue
    */
    public void add(Integer x);

    /*
    Returns true if this stack is empty, otherwise returns false.
    */
    public boolean isEmpty();

    /*
    Returns the smallest item stored in this priority queue without removing it
    */
    public Integer peekMin();

    /*
    Removes and returns the smallest item stored in this priority queue
    */
    public Integer removeMin();
}

// Team Not Gonna Lie (Nafiz Labib, Gabriel Thompson, Lauren Lee)
// APCS
// HW80 -- Generically Speaking
// 2022-03-24
// time spent: 0.7hrs

/***
 * interface List
 * subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *
 * If placed in current working dir, will be consulted instead of
 *  built-in Java library interface.
 **/

public interface List<T>
{
  //add node to list, containing input String as its data
  public boolean add( T x );

  //remove node from list, return its data
  public T remove( int index );

  //return data in element at position i
  public T get( int i );

  public void add( int index, T newVal );

  //overwrite data in element at position i
  public T set( int i, T x );

  //return length of list
  public int size();

}//end interface

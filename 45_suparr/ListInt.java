// Perfect Purple Petunias (John Gupta-She, Emily Ortiz, Lauren Lee)
// APCS pd8
// HW45: Array of Titanium
// 2021-12-08
// time spent: 1.0

/***************************
 QCC:
 - java.lang.object is a place holder for data type?
 DISCO:
 - declear SuperArray *implements* Listin to use it in SuperArray
- all methods in SuperArray.java that correspond with the abstract method should be public visibility
- the method headers of the abstract method should match the corresponding method in SuperArray.java


 ***************************/

public interface ListInt{

  boolean add(int value);

  boolean add_at_index(int index, int value);

  boolean remove(int index);

  int size();
}

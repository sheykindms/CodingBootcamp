package com.codingbootcamp.week2.day3;

import java.util.function.Function;

/**
 * Custom bidirectional List implementation that is similar to LinkedList
 */
public class List<T> {

  private List<T> prev;
  private List<T> next;
  private final T value;

  private List(List<T> prev, List<T> next, T value) {
    this.prev = prev;
    this.next = next;
    this.value = value;
  }

  /**
   * A static method to create the first element of LinkedList data structure
   *
   * @param value of the node itself
   * @return the first element of LinkedList
   */
  public static <T> List<T> createOne(T value) {
    return new List<>(null, null, value);
  }

  /**
   * Adds a newly created value to the end of the data structure by iterating over
   * the references till the last one
   *
   * @param list
   * @param newValue to be added to the structure
   * @return
   */
  public static <T> List<T> addToEnd(List<T> list, T newValue) {
    for (List<T> x = list; true; x = x.getNext()) {
      if (x.getNext() == null) {
        List<T> newList = new List<>(x, null, newValue);
        x.setNext(newList);
        return newList;
      }
    }
  }

  /**
   * Adds a newly created value to the end of the data structure by iterating over
   * the references till the first one
   *
   * @param list
   * @param newValue to be added to the structure
   * @return
   */
  public static <T> List<T> addToStart(List<T> list, T newValue) {
    for (List<T> x = list; true; x = x.getPrev()) {
      if (x.getPrev() == null) {
        List<T> newList = new List<>(null, x, newValue);
        x.setPrev(newList);
        return newList;
      }
    }
  }

  /**
   * Checks if the structure has a reference to the searched node
   * by iterating in two directions
   *
   * @param list  as the starting position for iterating
   * @param value as a searched value
   * @return boolean value. True if value was found and false otherwise
   */
  public static <T> boolean contains(List<T> list, T value) {
    for (List<T> x = list; x != null; x = x.getNext()) {
      if (x.getValue().equals(value)) {
        return true;
      }
    }
    for (List<T> x = list; x != null; x = x.getPrev()) {
      if (x.getValue().equals(value)) {
        return true;
      }
    }
    return false;
  }

  /**
   * A method that applies the provided function to each element in the LinkedList
   * and creates a new one
   *
   * @param list        as the starting position for iterating
   * @param mapFunction to be applied to each element in the data structure
   * @return newly created list of type <R>
   */
  public static <T, R> List<R> map(List<T> list, Function<T, R> mapFunction) {
    List<R> one = List.createOne(mapFunction.apply(list.getValue()));
    for (List<T> x = list.getNext(); x != null; x = x.getNext()) {
      List.addToEnd(one, mapFunction.apply(x.getValue()));
    }
    for (List<T> x = list.getPrev(); x != null; x = x.getPrev()) {
      List.addToStart(one, mapFunction.apply(x.getValue()));
    }
    return one;
  }

  /**
   * A method that calculates the length of LinkedList by iterating over
   * the references in two directions
   *
   * @return integer number
   */
  public int length() {
    int length = 1;
    for (List<T> x = this; x.getPrev() != null; x = x.getPrev()) {
      length++;
    }
    for (List<T> x = this; x.getNext() != null; x = x.getNext()) {
      length++;
    }
    return length;
  }

  /**
   * A method that inserts a new value after the current node
   *
   * @param newValue to be inserted after the current node
   * @return inserted List object with new value and newly created references
   */
  public List<T> insertAfter(T newValue) {
    if (getNext() != null) {
      List<T> newList = new List<>(this, getNext(), newValue);
      setNext(newList);
      getNext().getNext().setPrev(newList);
    } else {
      addToEnd(this, newValue);
    }
    return getNext();
  }

  /**
   * A method that inserts an array of values after the current node
   *
   * @param newValues to be inserted after the current node
   */
  public void insertAfter(T[] newValues) {
    for (T newValue : newValues) {
      insertAfter(newValue);
    }
  }

  /**
   * A method that deletes a node by removing references from the next and the previous nodes
   */
  public void delete() {
    if (getNext() != null) {
      next.setPrev(getPrev());
    }
    if (getPrev() != null) {
      prev.setNext(getNext());
    }
  }

  /**
   * A method that links two nodes between each other
   *
   * @param to to be connected to
   */
  public void connect(List<T> to) {
    setNext(to);
    to.setPrev(this);
  }

  public List<T> getNext() {
    return this.next;
  }

  public List<T> getPrev() {
    return this.prev;
  }

  public void setPrev(List<T> prev) {
    this.prev = prev;
  }

  public void setNext(List<T> next) {
    this.next = next;
  }

  public T getValue() {
    return this.value;
  }
}

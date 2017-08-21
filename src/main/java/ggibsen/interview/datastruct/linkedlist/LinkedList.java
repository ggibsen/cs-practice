package ggibsen.interview.datastruct.linkedlist;

/**
 * This is a non-cyclic linked list.  It has previous and next pointers (a doubly-linked list)
 * <p>
 * Created by greg on 8/9/17.
 */
public interface LinkedList {

    void swap(int indexI, int indexJ);

    Node delete(int index);

    void add(Node newNode, int indexToInsertAt);

    Node get(int index);

    int size();
}

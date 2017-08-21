package ggibsen.interview.datastruct.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Will test the delete and swap methods
 * <p>
 * Created by greg on 8/9/17.
 */
public class PointerLinkedListTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSwapInvalidIndexBoth() {
        LinkedList ll = new PointerLinkedList();
        ll.swap(-1, 50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapSameIndex() {
        LinkedList ll = new PointerLinkedList();
        ll.swap(0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSwapOnlyOneElement() {
        LinkedList ll = new PointerLinkedList();
        ll.add(new Node("A"), 0);
        ll.swap(0, 0);
    }

    @Test
    public void testSwap() {
        LinkedList ll = new PointerLinkedList();
        Node nodeA = new Node("A");
        ll.add(nodeA, 0);
        Node nodeB = new Node("B");
        ll.add(nodeB, 0);

        ll.swap(0, 1);

        Assert.assertEquals(nodeA, ll.get(0));
        Assert.assertEquals(nodeB, ll.get(1));
    }

    @Test
    public void testSwapMany() {
        LinkedList ll = new PointerLinkedList();
        Node nodeA = new Node("A");
        ll.add(nodeA, 0);
        // A
        Node nodeB = new Node("B");
        ll.add(nodeB, 0);
        // B A
        Node nodeD = new Node("D");
        ll.add(nodeD, 1);
        // B  D  A
        Node nodeC = new Node("C");
        ll.add(nodeC, 2);
        // B  D  C  A

        ll.swap(0, 1);
        // D  B  C  A
        ll.swap(2, 3);
        // D  B  A  C
        ll.swap(0, 3);
        // C  B  A  D
        ll.swap(1, 2);
        // C  A  B  D

        Assert.assertEquals(nodeC, ll.get(0));
        Assert.assertEquals(nodeA, ll.get(1));
        Assert.assertEquals(nodeB, ll.get(2));
        Assert.assertEquals(nodeD, ll.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteEmpty() {
        LinkedList ll = new PointerLinkedList();

        ll.delete(0);
    }

    @Test
    public void testDeleteRootOnly() {
        LinkedList ll = new PointerLinkedList();
        Node nodeA = new Node("A");
        ll.add(nodeA, 0);

        Node deletedNode = ll.delete(0);

        Assert.assertEquals(nodeA, deletedNode);
    }

    @Test
    public void testDeleteFromBack() {
        LinkedList ll = new PointerLinkedList();
        Node nodeC = new Node("C");
        ll.add(nodeC, 0);
        Node nodeB = new Node("B");
        ll.add(nodeB, 0);
        Node nodeA = new Node("A");
        ll.add(nodeA, 0);

        // A B C
        Node deletedNode = ll.delete(2);

        // A B
        Assert.assertEquals(nodeC, deletedNode);
        Assert.assertEquals(2, ll.size());
    }


}

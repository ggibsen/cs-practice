package ggibsen.interview.datastruct.linkedlist;

/**
 * Created by greg on 8/9/17.
 */
public class PointerLinkedList implements LinkedList {

    private int size = 0;
    private Node root;

    @Override
    public void swap(int indexI, int indexJ) {
        validIndex(indexI);
        validIndex(indexJ);
        if (indexI == indexJ) {
            throw new IllegalArgumentException("same index, won't swap...");
        }
        Node nodeI = getNode(indexI);
        Node nodeJ = getNode(indexJ);
        // get their new pointers
        Node nodeINewNext = nodeJ.next;
        Node nodeINewPrev = (nodeI == nodeJ.prev ? nodeJ : nodeJ.prev);
        Node nodeILeftNewNext = nodeJ;
        Node nodeIRightNewPrev = nodeJ;
        Node nodeJNewNext = (nodeJ == nodeI.next ? nodeI : nodeI.next);
        Node nodeJNewPrev = nodeI.prev;
        Node nodeJLeftNewNext = nodeI;
        Node nodeJRightNewPrev = nodeI;
        // now update pointers
        if (nodeI.prev != null && nodeI.prev != nodeJ) {
            nodeI.prev.next = nodeJ;
        }
        if (nodeI.next != null && nodeI.next != nodeJ) {
            nodeI.next.prev = nodeJ;
        }
        if (nodeJ.prev != null && nodeJ.prev != nodeI) {
            nodeJ.prev.next = nodeI;
        }
        if (nodeJ.next != null && nodeJ.next != nodeI) {
            nodeJ.next.prev = nodeI;
        }
        assignPointers(nodeI, nodeINewNext, nodeINewPrev);
        assignPointers(nodeJ, nodeJNewNext, nodeJNewPrev);
        if (nodeI == root) {
            root = nodeJ;
        } else if (nodeJ == root) {
            root = nodeI;
        }
    }

    private void validIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("bad index... " + index);
        }
    }

    private void assignPointers(Node node, Node nodeNewNext, Node nodeNewPrev) {
        node.next = nodeNewNext;
        node.prev = nodeNewPrev;
    }

    private Node getNode(int index) {
        Node foundNode = root;
        for (int ptr = 0; ptr < index; ptr++) {
            foundNode = foundNode.next;
        }
        return foundNode;
    }

    @Override
    public Node delete(int index) {
        return null;
    }

    @Override
    public void add(Node newNode, int indexToInsertAt) {
        if (size > 0) {
            validIndex(indexToInsertAt);
        } else if (indexToInsertAt != 0) {
            throw new IllegalArgumentException("empty list, bad index... " + indexToInsertAt);
        }
        if (size == 0) {
            root = newNode;
        } else {
            // get nodes and their new node pointers
            Node shiftRight = getNode(indexToInsertAt);
            Node shiftRightPrev = newNode;
            Node newNodeNext = shiftRight;
            Node newNodePrev = shiftRight.prev;
            // determine if we are at the root, or there's node on left to update
            if (shiftRight != root) {
                // we have a left node
                Node shiftLeft = shiftRight.prev;
                shiftLeft.next = newNode;
            } else {
                // we're shifting everything to the right (including root), assign new root
                root = newNode;
            }
            // assign out the node pointers
            shiftRight.prev = shiftRightPrev;
            assignPointers(newNode, newNodeNext, newNodePrev);
        }
        size++;
    }

    @Override
    public Node get(int index) {
        validIndex(index);
        return getNode(index);
    }
}

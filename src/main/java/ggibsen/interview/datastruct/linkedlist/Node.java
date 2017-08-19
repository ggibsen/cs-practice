package ggibsen.interview.datastruct.linkedlist;

/**
 * Created by greg on 8/9/17.
 */
public class Node {

    private final String data;

    public Node prev;

    public Node next;

    public Node(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (!data.equals(node.data)) return false;
        if (!prev.equals(node.prev)) return false;
        return next.equals(node.next);
    }

    @Override
    public int hashCode() {
        int result = data.hashCode();
        result = 31 * result + prev.hashCode();
        result = 31 * result + next.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                '}';
    }
}

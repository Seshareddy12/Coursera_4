package LinkedList;


class GenericDoublyLinkedList<T> {

    Node header;

    GenericDoublyLinkedList() {
        header = new Node(null, null, null);
    }


    public Node addFirst(T item) {
        Node n = new Node(header.next, header, item);
        if (header.next != null) {
            header.next.previous = n;
        }
        header.next = n;
        return n;
    }


    public Node add(T item) {
        Node end = getNode(size() - 1);
        Node next = new Node(null, end, item);
        end.next = next;
        return next;
    }


    public Node add(T item, int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("pos = " + index + " does not exist");
        }

        Node nodeIns = null;

        if (item != null) {
            Node node = header;

            if (node.next != null) {
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
            }

            nodeIns = new Node(node.next, node, item);

            if (node.next != null) {
                node.next.previous = nodeIns;
            }
            node.next = nodeIns;
        }
        return nodeIns;
    }


    public Node deleteFirst() {
        Node temp = getNode(0);
        if (temp != null && temp.next != null) {
            temp.next.previous = header;
            header.next = temp.next;
        } else {
            header.next = null;
        }

        return temp;
    }


    public Node deleteLast() {
        Node temp = getNode(size() - 1);
        Node newLast = getNode(size() - 2);
        newLast.next = null;
        return temp;
    }

    public boolean delete(int index) {
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("pos = " + index + " does not exist");
        }
        Node toBeRemoved = getNode(index);
        if (toBeRemoved == null)
            return false;
        Node previous = toBeRemoved.previous;
        Node next = toBeRemoved.next;

        previous.next = next;
        if (next != null) {
            next.previous = toBeRemoved.previous;
        }
        toBeRemoved = null;
        return true;
    }


    public boolean delete(T item) {
        int index = find(item);
        if (index == -1)
            return false;
        return delete(index);

    }


    private Node getNode(int index) {
        if (index > size())
            throw new IndexOutOfBoundsException();
        Node node = header;
        for (int i = 0; i <= index; ++i) {
            node = node.next;
        }

        return node;
    }


    public String get(int index) {
        Node node = getNode(index);
        return (node != null) ? node.value.toString() : null;
    }


    public int find(T item) {
        if (item == null)
            return -1;
        Node currentNode = header;
        int i = -1;
        while (currentNode.next != null) {
            ++i;
            currentNode = currentNode.next;
            if (item.equals(currentNode.value))
                return i;
        }
        return -1;
    }


    public int size() {
        int count = 0;
        Node node = header.next;
        while (node != null) {
            ++count;
            node = node.next;
        }
        return count;
    }


    public boolean isEmpty() {
        boolean isEmpty = (size() > 0) ? false : true;
        return isEmpty;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node next = header.next;
        while (next != null) {
            sb.append(next.value + ", ");
            next = next.next;
        }
        String ret = sb.toString();
        if (ret.length() > 1) {
            ret = ret.substring(0, ret.length() - 2);
        }
        return (ret + "]");
    }



    class Node {
        T value;
        Node next;
        Node previous;

        Node() {
        }

        Node(Node next, Node previous, T value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }

        public String toString() {
            return value + "";
        }
    }


}

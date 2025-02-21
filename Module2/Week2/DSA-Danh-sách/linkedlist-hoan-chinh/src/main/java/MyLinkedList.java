public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public void add(int index, E newElement) {
        if (index < 0 || index > numNodes) {
            return;
        }
        Node newNode = new Node(newElement);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        numNodes++;
    }

    public void addFirst(E newElement) {
        Node newNode = new Node(newElement);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E newElement) {
        Node newNode = new Node(newElement);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        numNodes++;
    }

    public void remove(int index) {
        if (index < 0 || index >= numNodes) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
        numNodes--;
    }

    public int size() {
        return numNodes;
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        if (head == null) return newList;

        newList.head = new Node(head.data);
        Node currentOld = head.next;
        Node currentNew = newList.head;

        while (currentOld != null) {
            currentNew.next = new Node(currentOld.data);
            currentNew = currentNew.next;
            currentOld = currentOld.next;
        }

        newList.numNodes = this.numNodes;
        return newList;
    }


    public boolean contains(Object element) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public int indexOf(Object element) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (E) current.data;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        }
        return (E) head.data;
    }

    public E getLast() {
        if (head == null) {
            return null;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return (E) current.data;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

    @Override
    public String toString() {
        String result = "[";
        Node current = head;
        while (current != null) {
            result += current.data;
            if (current.next != null) {
                result += " -> ";
            }
            current = current.next;
        }
        result += "]";
        return result;
    }

    class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
}

import java.util.Arrays;

public class MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public boolean add(E newElement) {
        ensureCapacity(size + 1);
        elements[size] = newElement;
        size++;
        return true;
    }

    public void add(int index, E newElement) {
        ensureCapacity(size + 1);
        elements[index] = newElement;
        size++;
    }

    public E remove(int index) {
        E removingElement = (E) elements[index];
        elements[index] = null;
        size--;
        return removingElement;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone() {
        MyList<E> newList = new MyList<>(this.size);
        newList.elements = Arrays.copyOf(this.elements, this.size);
        newList.size = this.size;
        return newList;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}

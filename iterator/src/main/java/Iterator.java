public interface Iterator<T> {
    boolean hasNext();
    void next() throws IndexOutOfBoundsException;
    T getElement();
}

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyCollection <E> {
    protected Object[] expansiveArray;
    protected int capacity;
    protected int size;
    protected final int RESIZE_FACTOR = 2;

    public MyCollection() {
        expansiveArray = new Object[1];
        capacity = 0;
        size = 1;
    }

    public MyCollection(int size) {
        expansiveArray = new Object[size];
        capacity = 0;
        this.size = size;
    }

    public int size() {
        return expansiveArray.length;
    }

    protected void resize() {
        size = size * RESIZE_FACTOR;
        expansiveArray = Arrays.copyOf(expansiveArray, size);
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean contains(E element) {
        return Arrays.asList(expansiveArray).contains(element);
    }

    public void clear() {
        expansiveArray = new Object[size];
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        E elementAtIndex = (E) expansiveArray[index];
        expansiveArray[index] = (E) new Object();
        return elementAtIndex;
    }

    @SuppressWarnings("unchecked")
    public E removeElement(E element) {
        boolean elementExists = contains(element);
        E elementAtIndex = (E) new Object();
        if(elementExists) {
            int firstOccurrenceOfElement = IntStream.range(0, expansiveArray.length)
                    .filter(i -> element ==  expansiveArray[i])
                    .findFirst() // first occurrence
                    .orElse(-1); // No element found
            if(firstOccurrenceOfElement != -1) {
                elementAtIndex = (E) expansiveArray[firstOccurrenceOfElement];
                remove(firstOccurrenceOfElement);
            }
        }
        return elementAtIndex;
    }
}

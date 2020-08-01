import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class MySetTest {
    MySet<String> stringSetNoLength;
    MySet<Integer> intSetWithLength;

    @Before
    public void setup() {
        stringSetNoLength = new MySet<>();
        intSetWithLength = new MySet<>(3);
    }

    @Test
    public void mySetZeroArgConstructorSizeTest() {
        int expectedSize = 1;

        int actualSize = stringSetNoLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void mySetOneArgConstructorSizeTest() {
        int expectedSize = 3;

        int actualSize = intSetWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void sizeTest() {
        int expectedSize = 3;

        int actualSize = intSetWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addNoDuplicatesTest() {
        boolean addSuccessful = intSetWithLength.add(4);

        assertTrue(addSuccessful);
    }

    @Test
    public void addWithDuplicatesTest() {
        intSetWithLength.add(4);
        boolean addFailure = intSetWithLength.add(4);

        assertFalse(addFailure);
    }

    @Test
    public void clearTest() {
        int expectedSize = 3;

        intSetWithLength.clear();
        int actualSize = intSetWithLength.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void listIsEmptyTest() {

        boolean actualValue = intSetWithLength.isEmpty();

        assertTrue(actualValue);
    }

    @Test
    public void iteratorTest() {
        int expectedValue = 1;

        intSetWithLength.add(1);
        Iterator<Integer> iterator = intSetWithLength.iterator();
        int actualValue = iterator.next();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void toArrayTest() {
        assertNotNull(intSetWithLength.toArray());
    }

    @Test
    public void addAllSuccessfulTest() {
        TreeSet<Integer>setWithValues = new TreeSet<>();
        setWithValues.add(12);
        setWithValues.add(3);

        boolean result = intSetWithLength.addAll(setWithValues);

        assertTrue(result);
    }

    @Test
    public void addAllFailureTest() {
        TreeSet<Integer>setWithValues = new TreeSet<>();
        setWithValues.add(3);
        setWithValues.add(3);

        boolean result = intSetWithLength.addAll(setWithValues);

        assertTrue(result);
    }

    @Test
    public void containsAllSuccessfulTest() {
        intSetWithLength.add(3);
        intSetWithLength.add(12);
        TreeSet<Integer>setWithValues = new TreeSet<>();
        setWithValues.add(12);
        setWithValues.add(3);

        boolean result = intSetWithLength.containsAll(setWithValues);

        assertTrue(result);
    }

    @Test
    public void containsAllFailureTest() {
        intSetWithLength.add(12);
        TreeSet<Integer>setWithValues = new TreeSet<>();
        setWithValues.add(12);
        setWithValues.add(3);

        boolean result = intSetWithLength.containsAll(setWithValues);

        assertTrue(result);
    }

    @Test
    public void removeAllSuccessfulTest() {
        intSetWithLength.add(12);
        TreeSet<Integer>setWithValues = new TreeSet<>();
        setWithValues.add(12);

        boolean result = intSetWithLength.removeAll(setWithValues);

        assertTrue(result);
    }

    @Test
    public void removeAllFailureTest() {
        intSetWithLength.add(12);
        TreeSet<Integer>setWithValues = new TreeSet<>();
        setWithValues.add(12);
        setWithValues.add(3);

        boolean result = intSetWithLength.removeAll(setWithValues);

        assertTrue(result);
    }

    @Test
    public void retainAllTest() {
        intSetWithLength.add(12);
        TreeSet<Integer>setWithValues = new TreeSet<>();
        setWithValues.add(12);
        setWithValues.add(4);

        boolean result = intSetWithLength.retainAll(setWithValues);

        assertTrue(result);
    }

    @Test
    public void equalsTest() {
        MySet<Integer> set = new MySet<Integer>(3);

        assertTrue(intSetWithLength.equals(set));
    }



}

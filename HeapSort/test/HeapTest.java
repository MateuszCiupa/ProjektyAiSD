
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void testCreateNullHeap() {
        ArrayList<Double> vector = null;
        Heap<Double> heap = new Heap<>(vector);

        assertEquals(0, heap.getSize());
        assertTrue(heap.getHeap() != null);
    }

    @Test
    public void testPutItemIntoTheHeap() {
        Heap<Double> heap = new Heap<>();
        heap.put(1.234);

        assertEquals(1, heap.getSize());
        assertTrue(heap.getObject(0) == 1.234);
    }

    @Test
    public void testCorrectTheHeap() {
        Heap<Integer> heap = new Heap<>();
        heap.put(1);
        heap.put(0);
        heap.put(7);
        heap.put(2);
        heap.put(32);
        heap.put(12);

        heap.correctHeap();
        boolean isTrue = true;

        for (int i = 0; i < heap.getSize() / 2; i++) {
            int leftChild = i * 2 + 1;
            int rightChild = leftChild + 1;
            if (heap.getObject(leftChild) > heap.getObject(i) || rightChild < heap.getSize() && heap.getObject(rightChild) > heap.getObject(i)) {
                isTrue = false;
                break;
            }
        }

        assertEquals(true, isTrue);
    }

    @Test
    public void testPopTheLargestElementOfTheHeap() {
        Heap<Integer> heap = new Heap<>();
        heap.put(1);
        heap.put(0);
        heap.put(7);
        heap.put(2);
        heap.put(32);
        heap.put(12);

        Integer theLargest = 32;
        heap.correctHeap();

        assertEquals(theLargest, heap.pop());
    }

    @Test
    public void testSortEmptyVector() {
        HeapSorter sorter = new HeapSorter();
        Heap<Double> heap = new Heap<>();
        ArrayList<Double> sortedVector = sorter.sort(heap.getHeap());

        assertEquals(null, sortedVector);
    }

    @Test
    public void testOneElementSort() {
        HeapSorter sorter = new HeapSorter();
        Heap<Double> heap = new Heap<>();
        heap.put(1.05);

        assertEquals(heap.getHeap(), sorter.sort(heap.getHeap()));
    }

    @Test
    public void testEvenNumberOfElementsToSort() {
        HeapSorter sorter = new HeapSorter();
        Heap<Double> heap = new Heap<>();

        heap.put(1.0);
        heap.put(2.0);
        heap.put(5.0);
        heap.put(3.0);
        heap.put(-1.0);
        heap.put(43.0);
        heap.put(12.0);
        heap.put(-1.1);

        heap.correctHeap();
        ArrayList<Double> sortedVector = sorter.sort(heap.getHeap());
        boolean isTrue = true;

        for (int i = 0; i < 7; i++) {
            if (sortedVector.get(i) > sortedVector.get(i + 1)) {
                isTrue = false;
                break;
            }
        }

        assertTrue(isTrue);
    }

    @Test
    public void testOddNumberOfElementsToSort() {
        HeapSorter sorter = new HeapSorter();
        Heap<Double> heap = new Heap<>();

        heap.put(1.0);
        heap.put(2.0);
        heap.put(5.0);
        heap.put(3.0);
        heap.put(-1.0);
        heap.put(43.0);
        heap.put(12.0);
        heap.put(-1.1);
        heap.put(32.43);

        heap.correctHeap();
        ArrayList<Double> sortedVector = sorter.sort(heap.getHeap());
        boolean isTrue = true;

        for (int i = 0; i < 8; i++) {
            if (sortedVector.get(i) > sortedVector.get(i + 1)) {
                isTrue = false;
                break;
            }
        }

        assertTrue(isTrue);
    }

    @Test
    public void testManyElementsToSort() {
        HeapSorter sorter = new HeapSorter();
        Heap<Double> heap = new Heap<>();

        heap.put(2.423);
        heap.put(42.1);
        heap.put(641.043);
        heap.put(213.052);
        heap.put(-1.8543);
        heap.put(446.12);
        heap.put(12.0);
        heap.put(-1.32);
        heap.put(24.02);
        heap.put(4.6194);
        heap.put(-5.0543);
        heap.put(-325.32);
        heap.put(-1.7);
        heap.put(43.4326);
        heap.put(2.0954);
        heap.put(-1.154);
        heap.put(134.4378);
        heap.put(22.03412);
        heap.put(-5.915);
        heap.put(-3324.58263);
        heap.put(-12.3);
        heap.put(43.065);
        heap.put(-932.8);
        heap.put(-1.1);

        heap.correctHeap();
        ArrayList<Double> sortedVector = sorter.sort(heap.getHeap());
        boolean isTrue = true;

        for (int i = 0; i < 23; i++) {
            if (sortedVector.get(i) > sortedVector.get(i + 1)) {
                isTrue = false;
                break;
            }
        }

        assertTrue(isTrue);
    }
}

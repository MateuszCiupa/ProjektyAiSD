
import java.util.ArrayList;

public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private ArrayList<T> heap;
    private int size;

    public Heap(ArrayList<T> heap) {
        if (heap != null) {
            this.heap = heap;
            size = heap.size();
        } else {
            this.heap = new ArrayList<T>(0);
            size = 0;
        }
    }

    public int getSize() {
        return size;
    }

    public T getObject(int i) {
        return heap.get(i);
    }

    public ArrayList<T> getHeap() {
        return heap;
    }

    public Heap() {
        heap = new ArrayList<T>(0);
        size = 0;
    }

    @Override
    public void put(T item) {
        heap.add(item);
        size++;
    }

    public void set(int index, T value) {
        heap.set(index, value);
    }

    @Override
    public T pop() { // aby metoda zdejmowała za każdym razem największy element musi zostać wywołana metoda correctHeap(), która porządkuje kopiec aby potomkowie każdego wierzchołka pozostawały w znanej nam relacji
        T root = heap.get(0);
        heap.set(0, heap.get(--size));
        heapify(0);
        return root;
    }

    public void heapify(int index) {
        T root = heap.get(index);
        int largestChild;

        while (index < size / 2) {
            int leftChild = index * 2 + 1;
            int rightChild = leftChild + 1;

            if (rightChild < size && (heap.get(rightChild)).compareTo(heap.get(leftChild)) > 0) {
                largestChild = rightChild;
            } else {
                largestChild = leftChild;
            }

            if (root.compareTo(heap.get(largestChild)) >= 0) {
                break;
            }

            heap.set(index, heap.get(largestChild));
            index = largestChild;
        }

        heap.set(index, root);
    }

    public void correctHeap() { // metoda ustawia kopiec w odpowiedniej relacji ojciec - dziecko
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

}

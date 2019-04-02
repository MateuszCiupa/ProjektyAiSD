
import java.util.ArrayList;

public class HeapSorter implements ListSorterAlgorithm {

    @Override
    public ArrayList<Double> sort(ArrayList<Double> unsortedVector) {
        if (unsortedVector.isEmpty()) {
            return null;
        }

        Heap<Double> heap = new Heap<>(unsortedVector);

        for (int k = heap.getSize() - 1; k >= 0; k--) {
            Double largestNode = heap.pop();
            heap.set(k, largestNode);
        }

        return heap.getHeap();
    }

}

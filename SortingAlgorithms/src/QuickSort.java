package sortingalgorithms;

public class QuickSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        if(unsortedVector.length == 0) {
            return unsortedVector;
        }
        
        int left = 0;
        int right = unsortedVector.length - 1;
        int top = -1;
        int[] stack = new int[unsortedVector.length];
        
        stack[++top] = left;
        stack[++top] = right;
        
        while(top >= 0) {
            right = stack[top--];
            left = stack[top--];
            
            int partitioned = partition(unsortedVector, left, right);
            
            if(partitioned - 1 > left) {
                stack[++top] = left;
                stack[++top] = partitioned - 1;
            }
            
            if(partitioned + 1 < right) {
                stack[++top] = partitioned + 1;
                stack[++top] = right;
            }           
        }
        
        return unsortedVector;
    }
    
    private int partition(double[] vector, int left, int right) {
        double pivot = vector[right];
        int i = left - 1;
        
        for(int j = left; j <= right; j++) {
            if(vector[j] <= pivot) {
                i++;
                swap(vector, i, j);
            }
        }
        
        return i;
    }
    
    private void swap(double[] vector, int x, int y) {
        double tmp = vector[x];
        vector[x] = vector[y];
        vector[y] = tmp;
    }
}

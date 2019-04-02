package sortingalgorithms;

import java.util.Arrays;

public class InsertionSort implements SortingAlgorithm {
    
    @Override
    public double[] sort(double[] unsortedVector) {
        for(int i = 1; i < unsortedVector.length; i++) {
            int j = i - 1;
            double tmpValue = unsortedVector[i];
            
            while(j >= 0 && unsortedVector[j] > tmpValue) {
                unsortedVector[i] = unsortedVector[j];
                i = j;
                j--;
            }
            
            if(i != j) {
                unsortedVector[i] = tmpValue;
            }    
        }
        
        return unsortedVector;
    }
    
    public static void main(String[] args) {
        SortingAlgorithm alg = new MergeSort();
        SortingAlgorithms sorter = new SortingAlgorithms(alg);
       
        double[] vector = sorter.getRandomVector(10);
        System.out.println(Arrays.toString(alg.sort(vector)));
        
    }
}

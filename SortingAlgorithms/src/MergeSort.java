package sortingalgorithms;

public class MergeSort implements SortingAlgorithm {

    @Override
    public double[] sort(double[] unsortedVector) {
        for(int i = 1; i < unsortedVector.length; i = i * 2) { 
            for(int j = 0; j < unsortedVector.length - 1; j += 2 * i) { 
                int left = j;
                int middle = Math.min(j + i - 1, unsortedVector.length - 1);
                int right = Math.min(j + 2 * i - 1, unsortedVector.length - 1);
                merge(unsortedVector, left, middle, right);
            }
        }
        
        return unsortedVector;
    }
        
    private void merge(double[] vector, int left, int middle, int right) {
        int firstSize = middle - left + 1; 
        int secondSize = right - middle; 
      
        double firstArray[] = new double[firstSize]; 
        double secondArray[] = new double[secondSize]; 
      
        for(int i = 0; i < firstSize; i++) {
            firstArray[i] = vector[left + i]; 
        }
        
        for(int i = 0; i < secondSize; i++) {
            secondArray[i] = vector[middle + 1 + i]; 
        }
        
        int firstIndicator = 0;
        int secondIndicator = 0;
        int mainIndicator = left;
        
        while(firstIndicator < firstSize && secondIndicator < secondSize) {
            if(firstArray[firstIndicator] < secondArray[secondIndicator]) {
                vector[mainIndicator] = firstArray[firstIndicator];
                firstIndicator++;
            } else {
                vector[mainIndicator] = secondArray[secondIndicator];
                secondIndicator++;
            }
            
            mainIndicator++;
        }
      
        while(firstIndicator < firstSize) { 
            vector[mainIndicator] = firstArray[firstIndicator];
            firstIndicator++;
            mainIndicator++;
        } 
        
        while(secondIndicator < secondSize) {
            vector[mainIndicator] = secondArray[secondIndicator];
            secondIndicator++;
            mainIndicator++;
        }
    } 
    
}

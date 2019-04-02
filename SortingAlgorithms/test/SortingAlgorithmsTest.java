package sortingalgorithms;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SortingAlgorithmsTest {
    
    @Test
    public void testSortNoneByInsertionSort() {
        // GIVEN 
        SortingAlgorithm algorithm = new InsertionSort();
        double[] vector = new double[0];
        
        // WHEN 
        int result = algorithm.sort(vector).length;
        int expectedResult = 0;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSortNoneByQuickSort() {
        // GIVEN 
        SortingAlgorithm algorithm = new QuickSort();
        double[] vector = new double[0];
        
        // WHEN 
        int result = algorithm.sort(vector).length;
        int expectedResult = 0;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSortNoneByMergeSort() {
        // GIVEN 
        SortingAlgorithm algorithm = new MergeSort();
        double[] vector = new double[0];
        
        // WHEN 
        int result = algorithm.sort(vector).length;
        int expectedResult = 0;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSortFewByInsertionSort() {
        // GIVEN 
        SortingAlgorithms sorter = new SortingAlgorithms(new InsertionSort());
        double[] result = sorter.getRandomVector(5);
        double[] expectedResult = new double[result.length];
        
        System.arraycopy(result, 0, expectedResult, 0, result.length);
        
        // WHEN 
        result = sorter.sort(result);
        Arrays.sort(expectedResult);
                
        // THEN 
        for(int i = 0; i < result.length; i++) {
            assertEquals(expectedResult[i], result[i], 0.0001);
        }
    }
    
    @Test
    public void testSortFewByQuickSort() {
        // GIVEN 
        SortingAlgorithms sorter = new SortingAlgorithms(new QuickSort());
        double[] result = sorter.getRandomVector(5);
        double[] expectedResult = new double[result.length];
        
        System.arraycopy(result, 0, expectedResult, 0, result.length);
        
        // WHEN 
        result = sorter.sort(result);
        Arrays.sort(expectedResult);
                
        // THEN 
        for(int i = 0; i < result.length; i++) {
            assertEquals(expectedResult[i], result[i], 0.0001);
        }
    }
    
    @Test
    public void testSortFewByMergeSort() {
        // GIVEN 
        SortingAlgorithms sorter = new SortingAlgorithms(new MergeSort());
        double[] result = sorter.getRandomVector(5);
        double[] expectedResult = new double[result.length];
        
        System.arraycopy(result, 0, expectedResult, 0, result.length);
        
        // WHEN 
        result = sorter.sort(result);
        Arrays.sort(expectedResult);
                
        // THEN 
        for(int i = 0; i < result.length; i++) {
            assertEquals(expectedResult[i], result[i], 0.0001);
        }
    }
    
    @Test
    public void testSortMillionByInsertionSort() {
        // GIVEN 
        SortingAlgorithms sorter = new SortingAlgorithms(new InsertionSort());
        double[] result = sorter.getRandomVector(1000000);
        double[] expectedResult = new double[result.length];
        
        System.arraycopy(result, 0, expectedResult, 0, result.length);
        
        // WHEN 
        result = sorter.sort(result);
        Arrays.sort(expectedResult);
                
        // THEN 
        for(int i = 0; i < result.length; i++) {
            assertEquals(expectedResult[i], result[i], 0.0001);
        }
    }
    
    @Test
    public void testSortMilliontByQuickSort() {
        // GIVEN 
        SortingAlgorithms sorter = new SortingAlgorithms(new QuickSort());
        double[] result = sorter.getRandomVector(1000000);
        double[] expectedResult = new double[result.length];
        
        System.arraycopy(result, 0, expectedResult, 0, result.length);
        
        // WHEN 
        result = sorter.sort(result);
        Arrays.sort(expectedResult);
                
        // THEN 
        for(int i = 0; i < result.length; i++) {
            assertEquals(expectedResult[i], result[i], 0.0001);
        }
    }
    
    @Test
    public void testSortMilliontByMergeSort() {
        // GIVEN 
        SortingAlgorithms sorter = new SortingAlgorithms(new MergeSort());
        double[] result = sorter.getRandomVector(1000000);
        double[] expectedResult = new double[result.length];
        
        System.arraycopy(result, 0, expectedResult, 0, result.length);
        
        // WHEN 
        result = sorter.sort(result);
        Arrays.sort(expectedResult);
                
        // THEN 
        for(int i = 0; i < result.length; i++) {
            assertEquals(expectedResult[i], result[i], 0.0001);
        }
    }
}

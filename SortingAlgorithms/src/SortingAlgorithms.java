package sortingalgorithms;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SortingAlgorithms {

    private SortingAlgorithm algorithm;
    private static final double UPPER_RAND_VALUE = 10.0;
    private static final double LOWER_RAND_VALUE = 0.0;
    private static final int NUMB_TO_AVG = 1000000;
    private static final int NUMB_OF_AVG = 300;
    private static final int STEP = 2;
    
    public SortingAlgorithms(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
    
    public void setSortingAlgorithm(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }
    
    public double[] sort(double[] vector) {
        return algorithm.sort(vector);
    }
    
    public double[] getRandomVector(int n) {
        double[] vector = new double[n];
        
        for(int i = 0; i < n; i++) {
            vector[i] = getRandomDouble();
        }
        
        return vector;
    }
    
    private long getSortingTime(double[] vector) {
        long startTime = System.nanoTime();
        algorithm.sort(vector);
        return System.nanoTime() - startTime;
    }
    
    private long getAvgSortingTime(double[] vector) {
        long avgTime = 0;
        
        for(int i = 0; i < NUMB_TO_AVG; i++) {
            avgTime += getSortingTime(vector);
        }
        
        return avgTime / NUMB_TO_AVG;
    }
    
    private double getRandomDouble() {
        return Math.random() * (UPPER_RAND_VALUE - LOWER_RAND_VALUE + 1) + LOWER_RAND_VALUE;
    }
    
    public void worstCaseQuickSort() {
        try {
            File file = new File("worstCaseQuickSort.txt");
            
            if(!file.exists()) {
                file.createNewFile();
            }
            
            PrintWriter writer = new PrintWriter(file);
            
            for(int i = 0; i < NUMB_OF_AVG; i++) {
                double [] vector = new double[i * 2];
                
                for(int j = 0; j < i * 2; j++) {
                    vector[j] = 5.187;
                }
                
                writer.println(getAvgSortingTime(vector));
            }
            
            writer.close();
        } catch(IOException e) {        
        }
    }
    
    public void worstCaseInsertionSort() {
        try {
            File file = new File("worstCaseInsertionSort.txt");
            
            if(!file.exists()) {
                file.createNewFile();
            }
            
            PrintWriter writer = new PrintWriter(file);
            
            for(int i = 0; i < NUMB_OF_AVG; i++) {
                double [] vector = getRandomVector(i * STEP);
                Arrays.sort(vector);
                reverseVector(vector);
                writer.println(getAvgSortingTime(vector));
            }
            
            writer.close();
        } catch(IOException e) {        
        }
    }
    
    public void avgCaseMergeSort() {
        try {
            File file = new File("avgCaseMergeSort.txt");
            
            if(!file.exists()) {
                file.createNewFile();
            }
            
            PrintWriter writer = new PrintWriter(file);
            
            for(int i = 0; i < NUMB_OF_AVG; i++) {
                double[] vector = getRandomVector(i * STEP);
                writer.println(getAvgSortingTime(vector));
            }
            
            writer.close();
        } catch(IOException e) {        
        }
    }
    
    public void avgCaseQuickSort() {
        try {
            File file = new File("avgCaseQuickSort.txt");
            
            if(!file.exists()) {
                file.createNewFile();
            }
            
            PrintWriter writer = new PrintWriter(file);
            
            for(int i = 0; i < NUMB_OF_AVG; i++) {
                double [] vector = getRandomVector(i * STEP);
                writer.println(getAvgSortingTime(vector));
            }
            
            writer.close();
        } catch(IOException e) {        
        }
    }
    
    public void bestCaseInsertionSort() {
        try {
            File file = new File("bestCaseInsertionSort.txt");
            
            if(!file.exists()) {
                file.createNewFile();
            }
            
            PrintWriter writer = new PrintWriter(file);
            
            for(int i = 0; i < NUMB_OF_AVG; i++) {
                double [] vector = getRandomVector(i * STEP);
                Arrays.sort(vector);
                writer.println(getAvgSortingTime(vector));
            }
            
            writer.close();
        } catch(IOException e) {        
        }
    }
    
    public void avgCaseInsertionSort() {
        try {
            File file = new File("avgCaseInsertionSort.txt");
            
            if(!file.exists()) {
                file.createNewFile();
            }
            
            PrintWriter writer = new PrintWriter(file);
            
            for(int i = 0; i < NUMB_OF_AVG; i++) {
                double [] vector = getRandomVector(i * STEP);
                writer.println(getAvgSortingTime(vector));
            }
            
            writer.close();
        } catch(IOException e) {        
        }
    }
    
    private void reverseVector(double [] vector) {
        for(int i = 0; i < vector.length; i++) {
            double tmpValue = vector[0];
            vector[0] = vector[vector.length - 1 - i];
            vector[vector.length - 1 - i] = tmpValue;
        }
    }
    
    public static void main(String[] args) {
        SortingAlgorithms sorter = new SortingAlgorithms(new InsertionSort());
        sorter.bestCaseInsertionSort();
    }
    
}

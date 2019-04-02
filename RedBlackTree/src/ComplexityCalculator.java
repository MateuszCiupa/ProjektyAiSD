package blackredtree;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ComplexityCalculator {
    
    private RedOnlyLeftTree<Integer, Integer> tree = new RedOnlyLeftTree<>();
    private static final int MAX_RANGE = 1000;
    private static final int MIN_RANGE = 0;
    private static final int NUMB_TO_AVG = 200000;
    private static final int NUMB_OF_AVG = 300;
    private static final int STEP = 2;
    
    private void setRandomIntegers(int n) {
        RedOnlyLeftTree<Integer, Integer> tmpTree = new RedOnlyLeftTree<>();
        
        for (int i = 0; i < n; i++) {
            int x = getRandomInteger();
            tmpTree.setValue(x, x * 2 + 11);
        }
        
        tree = tmpTree;
    }
    
    private int getRandomInteger() {
        return (int) (Math.random() * (MAX_RANGE - MIN_RANGE + 1)) + MIN_RANGE;
    }
    
    private long getSetValueTime(int x) {    
        long startTime = System.nanoTime();
        tree.setValue(x, x * 2 + 11);
        return System.nanoTime() - startTime;
    }
    
    private long getGetValueTime(int x) {
        long startTime = System.nanoTime();
        tree.getValue(x);
        return System.nanoTime() - startTime;
    }
    
    private long getSetValueAvgTime(int n) {
        long avarageTime = 0;
        int x;
        int i;
        
        for(i = 0; i < NUMB_TO_AVG; i++) {
            x = getRandomInteger();
            setRandomIntegers(n);
            avarageTime += getSetValueTime(x);
        }
        
        return avarageTime / i;    
    }
    
    private long getGetValueAvgTime(int n) {
        long avarageTime = 0;
        int x;
        int i;
        
        for(i = 0; i < NUMB_TO_AVG; i++) {
            x = getRandomInteger();
            setRandomIntegers(n);
            avarageTime += getGetValueTime(x);
        }
        
        return avarageTime / i;
    }
    
    public static void main(String[] args) {
        ComplexityCalculator calc = new ComplexityCalculator();
        calc.createFileWithSetValueAvgTimes();
        calc.createFileWithGetValueAvgTimes();
    }
    
    public void createFileWithSetValueAvgTimes() {
        try {
            File file = new File("setValueAvgTimes.txt");
            
            if(!file.exists()) {
                file.createNewFile();
            }
            
            PrintWriter writer = new PrintWriter(file);
            
            for(int i = 0; i <= NUMB_OF_AVG; i++) {
                writer.println(getSetValueAvgTime(i * STEP));
            }
            
            writer.close();
        } catch(IOException e) {        
        }
    }
    
    public void createFileWithGetValueAvgTimes() {
        try {
            File file = new File("getValueAvgTimes.txt");
        
            if(!file.exists()) {
                file.createNewFile();
            }
        
            PrintWriter writer = new PrintWriter(file);
            
            for(int i = 0; i <= NUMB_OF_AVG; i++) {
                writer.println(getGetValueAvgTime(i * STEP));
            }
            
            writer.close();
        } catch(IOException e) {
        }
    }
    
}

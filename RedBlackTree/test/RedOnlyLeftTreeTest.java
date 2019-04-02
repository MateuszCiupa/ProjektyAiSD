package blackredtree;

import org.junit.Test;
import static org.junit.Assert.*;

public class RedOnlyLeftTreeTest {

    @Test
    public void testGetValue() {
        // GIVEN 
        RedOnlyLeftTree<Integer, Integer> testTree = new RedOnlyLeftTree<>();
        testTree.setValue(1, 5);
        testTree.setValue(6, 12);
        testTree.setValue(4, 3);
        testTree.setValue(2, 55);
        
        // WHEN 
        Integer result = testTree.getValue(6);
        Integer expectedResult = 12;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    
    @Test
    public void testGetValueButKeyIsNull() {
        // GIVEN 
        RedOnlyLeftTree<Integer, Integer> testTree = new RedOnlyLeftTree<>();
        testTree.setValue(1, 5);
        testTree.setValue(6, 12);
        testTree.setValue(4, 3);
        testTree.setValue(2, 55);
        
        // WHEN 
        Integer result = testTree.getValue(null);
        Integer expectedResult = null;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testGetValueButThereIsNoSuch() {
        // GIVEN 
        RedOnlyLeftTree<Integer, Integer> testTree = new RedOnlyLeftTree<>();
        testTree.setValue(1, 5);
        testTree.setValue(6, 12);
        testTree.setValue(4, 3);
        testTree.setValue(2, 55);
        
        // WHEN 
        Integer result = testTree.getValue(7);
        Integer expectedResult = null;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testLeftRotate() {
        // GIVEN 
        RedOnlyLeftTree<Integer, Integer> testTree = new RedOnlyLeftTree<>();
        Node<Integer, Integer> root = new Node<>(1, 4);
        Node<Integer, Integer> node = new Node<>(4, 32);
        root.setRight(node);
        
        // WHEN 
        testTree.leftRotate(root);
        Node<Integer, Integer> result = node.getLeft();
        Node<Integer, Integer> expectedResult = root;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testRightRotate() {
        // GIVEN 
        RedOnlyLeftTree<Integer, Integer> testTree = new RedOnlyLeftTree<>();
        Node<Integer, Integer> root = new Node<>(153, 4);
        Node<Integer, Integer> node = new Node<>(4, 32);
        root.setLeft(node);
        
        // WHEN 
        testTree.rightRotate(root);
        Node<Integer, Integer> result = node.getRight();
        Node<Integer, Integer> expectedResult = root;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSetValueButKeyIsNull() {
        // GIVEN 
        RedOnlyLeftTree<Integer, Integer> testTree = new RedOnlyLeftTree<>();
        testTree.setValue(null, 5);
        
        // WHEN 
        Node result = testTree.getRoot();
        Node expectedResult = null;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSetValueButValueIsNull() {
        // GIVEN 
        RedOnlyLeftTree<Integer, Integer> testTree = new RedOnlyLeftTree<>();
        testTree.setValue(65, null);
        
        // WHEN 
        Node result = testTree.getRoot();
        Node expectedResult = null;
        
        // THEN 
        assertEquals(expectedResult, result);
    }
    
    @Test
    public void testSetValueWhereKeyIsString() {
        // GIVEN 
        RedOnlyLeftTree<String, Integer> testTree = new RedOnlyLeftTree<>();
        testTree.setValue("A", 1);
        testTree.setValue("L", 12);
        testTree.setValue("G", 7);
        testTree.setValue("O", 15);
        testTree.setValue("R", 17);
        testTree.setValue("Y", 22);
        testTree.setValue("T", 19);
        testTree.setValue("M", 13);
        
        // WHEN 
        String result = testTree.getRoot().getKey();
        String expectedResult = "O";
        
        // THEN 
        assertEquals(expectedResult, result); 
    }
 
}

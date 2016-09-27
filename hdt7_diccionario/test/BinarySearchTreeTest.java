/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo Arriaza;
 */
public class BinarySearchTreeTest {
    
    public BinarySearchTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of find method, of class BinarySearchTree.
     * Prueba encontrar un objeto que no esta y encontrar uno que si esta
     */
    @Test
    public void testFind_String() {
        System.out.println("find");
        Association<String, String> key1 = new Association ("no", "esta");
        BinarySearchTree instance = new BinarySearchTree();
        boolean expResult1 = false;
        boolean result1 = instance.find("no");
        Association<String, String> key2 = new Association("Si esta","x");
        instance.insert(key2); //como la estoy insertando, cuando la busque debe devolver true porque si esta
        boolean expResult2 = true;
        boolean result2 = instance.find("Si esta");
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        // TODO review the generated test code and remove the default call to fail.
    }

    

    /**
     * Test of insert method, of class BinarySearchTree.
     * Inserta un objeto y revisa si esta para ver si se inserto 
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        int id = 5;
        BinarySearchTree instance = new BinarySearchTree();
        instance.insert(id);
        boolean result = instance.find(id);
        boolean expResult = true;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}

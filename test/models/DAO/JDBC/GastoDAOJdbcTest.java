/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO.JDBC;

import java.sql.ResultSet;
import java.util.List;
import models.DAO.SingletonDataConnection;
import models.gastos.Gasto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alex
 */
public class GastoDAOJdbcTest {
    static SingletonDataConnection s;
    static GastoDAOJdbc gDAOJ;
    
    public GastoDAOJdbcTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        s = SingletonDataConnection.getInstance();
        gDAOJ = new GastoDAOJdbc(s.getConnection());
        
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
     * Test of getList method, of class GastoDAOJdbc.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        gDAOJ.getList();
        GastoDAOJdbc instance = gDAOJ;
        //List<Gasto> expResult = null;
        List<Gasto> result = instance.getList();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseResultRow method, of class GastoDAOJdbc.
     */
    @Test
    public void testParseResultRow() {
        System.out.println("parseResultRow");
        ResultSet set = null;
        Gasto expResult = null;
        Gasto result = GastoDAOJdbc.parseResultRow(set);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class GastoDAOJdbc.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        GastoDAOJdbc instance = gDAOJ;
        int expResult = 0;
        int result = instance.insert();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class GastoDAOJdbc.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        GastoDAOJdbc instance = null;
        boolean expResult = false;
        boolean result = instance.update();
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

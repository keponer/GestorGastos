/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO.JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import models.CategoriaGasto;
import models.CategoriaGastoCollection;
import models.DAO.DAOFactory;
import models.DAO.SingletonDataConnection;
import models.GastoCollection;
import models.gastos.Alquiler_Hipoteca;
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
    
    private static Connection c;
    private static Gasto g;
    
    public GastoDAOJdbcTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        SingletonDataConnection.getInstance();
        CategoriaGastoCollection.start();
        GastoCollection.getInstance();
        DAOFactory.getGastoDAO();
        c = SingletonDataConnection.getInstance().getConnection();
        CategoriaGasto ct = CategoriaGastoCollection.getById(1);
        g = new Alquiler_Hipoteca(666, "666", ct, 0, null, null);
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
        GastoDAOJdbc instance = new GastoDAOJdbc(c);
        //List<Gasto> expResult = null;
        List<Gasto> result = instance.getList();
        //assertEquals(expResult, result);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype." + result);
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
     * Test of update method, of class GastoDAOJdbc.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        GastoDAOJdbc instance = new GastoDAOJdbc(c, g);
        boolean expResult = false;
        boolean result = instance.update();
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class GastoDAOJdbc.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        c = SingletonDataConnection.getInstance().getConnection();
        CategoriaGasto ct = CategoriaGastoCollection.getById(1);
        g = new Alquiler_Hipoteca(666, "666", ct, 0, null, null);
        GastoDAOJdbc instance = new GastoDAOJdbc(c, g);
        int expResult = 666;
        int result = instance.insert();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class GastoDAOJdbc.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        GastoDAOJdbc instance = new GastoDAOJdbc(c, g);
        boolean expResult = false;
        boolean result = instance.delete();
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Data;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author steve
 */
public class PhoneBkItemTest {
    
    public PhoneBkItemTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    
    

    /**
     * Test of getContactName method, of class PhoneBookItem.
     */
    @Test
    public void testGetContactName() {
        System.out.println("getContactName");
        PhoneBkItem instance = new PhoneBkItem("Jane","0788885647");
        String expResult = "Jane";
        String result = instance.getContactName();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class PhoneBookItem.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        String _contactName = "Jane";
        String _contactNumber = "0788885647";
        PhoneBkItem instance = new PhoneBkItem("Ken","0788885000");
        boolean expResult = false;
        boolean result = instance.equals(_contactName, _contactNumber);
        assertEquals(expResult, result);
      }

    /**
     * Test of setContactName method, of class PhoneBookItem.
     */
   

    /**
     * Test of getContactNumber method, of class PhoneBookItem.
     */
    @Test
    public void testGetContactNumber() {
        System.out.println("getContactNumber");
        PhoneBkItem instance = new PhoneBkItem("Jane","0788885647");
        String expResult = "0788885647";
        String result = instance.getContactNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setContactName method, of class PhoneBookItem.
     */
    @Test
    public void testSetContactName() {
        System.out.println("setContactName");
        String ContactName = "Jane";
        String expResult = "Jane";
        PhoneBkItem instance = new PhoneBkItem("","");
        instance.setContactName(ContactName);
        String result = instance.getContactName();
        assertEquals(expResult, result);
      }

    /**
     * Test of setContactNumber method, of class PhoneBookItem.
     */
    @Test
    public void testSetContactNumber() {
        System.out.println("setContactNumber");
        String ContactNumber = "0788885647";
        String expResult = "0788885647";
        PhoneBkItem instance = new PhoneBkItem("","");;
        instance.setContactNumber(ContactNumber);
        String result = instance.getContactNumber();
        assertEquals(expResult, result);
    }

    
   
    
}

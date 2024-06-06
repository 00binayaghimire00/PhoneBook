/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Data;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author steve
 */
public class PhoneBkDataTest {
    
    public PhoneBkDataTest() {
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
     * Test of addPropertyChangeListener method, of class PhoneBookData.
     */
    @Test
    public void testAddPropertyChangeListener() {
        System.out.println("addPropertyChangeListener");
        PropertyChangeListener outsidePcl = null;
        PhoneBkData instance = new PhoneBkData();
        instance.addPropertyChangeListener(outsidePcl);
        PropertyChangeListener result = instance.getPropertyChangeListener();
        assertEquals(outsidePcl, result);
    }

    /**
     * Test of addContact method, of class PhoneBookData.
     */
    @Test
    public void testAddContact() {
        System.out.println("addContact");
        String _contactName = "Jane";
        String _contactNumber = "0788885647";
        PhoneBkData instance = new PhoneBkData();
        boolean expResult = true;
        boolean result = instance.addContact(_contactName, _contactNumber);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getSize method, of class PhoneBookData.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        PhoneBkData instance = new PhoneBkData();
        instance.addContact("Ben", "0758785647");
        instance.addContact("Jane", "0788885647");
        int expResult = 2;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of findContactAt method, of class PhoneBookData.
     */
    @Test
    public void testFindContactAt() {
        System.out.println("findContactAt");
        String _contactName = "Ben";
        String _contactNumber = "0758785647";
        String _contactName2 = "Jane";
        String _contactNumber2 = "0788885647";
        PhoneBkData instance = new PhoneBkData();
        instance.addContact(_contactName, _contactNumber);
        instance.addContact(_contactName2, _contactNumber2);
        int expResult = 1;
        int result = instance.findContactAt(_contactName2, _contactNumber2);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteContact method, of class PhoneBookData.
     */
    @Test
    public void testDeleteContact() {
        System.out.println("deleteContact");
        String _contactName = "Ben";
        String _contactNumber = "0758785647";
        PhoneBkData instance = new PhoneBkData();
        instance.addContact(_contactName, _contactNumber);
        boolean expResult = true;
        boolean result = instance.deleteContact(_contactName, _contactNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactList method, of class PhoneBookData.
     */
    @Test
    public void testGetContactList() {
        System.out.println("getContactList");
        PhoneBkData instance = new PhoneBkData();
        ArrayList<PhoneBkItem> expResult = new ArrayList<>();
        ArrayList<PhoneBkItem> result = instance.getContactList();
        assertEquals(expResult, result);
        assertNotNull(result);
    }

    /**
     * Test of setContactList method, of class PhoneBookData.
     */
    @Test
    public void testSetContactList() {
        System.out.println("setContactList");
        ArrayList<PhoneBkItem> contactList = new ArrayList<>();
        PhoneBkData instance = new PhoneBkData();
        instance.setContactList(contactList);
        ArrayList<PhoneBkItem> result = instance.getContactList();
        assertEquals(contactList, result);
    }
    
    @Test
    public void DontAllowDuplicateNames()
    {
        System.out.println("No duplicate name");
        String _contactName1 = "Emeka";
        String _contactNumber1 = "07587950547";
        String _contactName2 = "Emeka";
        String _contactNumber2 = "07498769866";
        PhoneBkData instance = new PhoneBkData();
        instance.addContact(_contactName2, _contactNumber2);
        assertThrows(IllegalArgumentException.class, () -> {
        instance.addContact(_contactName1, _contactNumber1);});  
    }
    
    @Test
    public void DontAllowDuplicateNumbers()
    {
       System.out.println("No duplicate number");
        String _contactName1 = "Emeka";
        String _contactNumber1 = "07587950547";
        String _contactName2 = "John";
        String _contactNumber2 = "07587950547";
        PhoneBkData instance = new PhoneBkData();
        instance.addContact(_contactName2, _contactNumber2);
        assertThrows(IllegalArgumentException.class, () -> {
        instance.addContact(_contactName1, _contactNumber1);});   
    }
    
    @Test
    public void allowInternationalNumberCode(){
        System.out.println("addContact with + sign");
        String _contactName = "Jane";
        String _contactNumber = "+0788885647";
        PhoneBkData instance = new PhoneBkData();
        boolean expResult = true;
        boolean result = instance.addContact(_contactName, _contactNumber);
        assertEquals(expResult, result);
      }
    
    @Test
    public void DontAllowInvalidEntries()
    {
        String _contactName1 = "";
        String _contactNumber1 = "07587950547";
        String _contactName2 = "John";
        String _contactNumber2 = "075879";
        String _contactName3 = "Ken";
        String _contactNumber3 = "";
        String _contactName4 = "Ben";
        String _contactNumber4 = "++07587950511";
        String _contactName5 = "Kelvin";
        String _contactNumber5 = "07587950th11";
        PhoneBkData instance = new PhoneBkData();
        
        boolean expResult = false;
        boolean result1 = instance.addContact(_contactName1, _contactNumber1);
        boolean result2 = instance.addContact(_contactName2, _contactNumber2);
        boolean result3 = instance.addContact(_contactName3, _contactNumber3);
        boolean result4 = instance.addContact(_contactName4, _contactNumber4);
        boolean result5 = instance.addContact(_contactName5, _contactNumber5);
        
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
        assertEquals(expResult, result4);
        assertEquals(expResult, result5);
        
    }
}

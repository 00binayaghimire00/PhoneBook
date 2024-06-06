/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Stiv
 */
public class PhoneBkItem {

    /**
     * @return the ContactName
     */
    PhoneBkItem(String _contactName, String _contactNumber)
    {
        setContactName(_contactName);
        setContactNumber(_contactNumber);
    }
    
    public String getContactName() {
        return ContactName;
    }
    
    public boolean equals(String _contactName, String _contactNumber)
    {
        if (ContactName.equals(_contactName) && ContactNumber.equals(_contactNumber)) return true;
        return false;
    }

    /**
     * @param ContactName the ContactName to set
     */
    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    /**
     * @return the ContactNumber
     */
    public String getContactNumber() {
        return ContactNumber;
    }

    /**
     * @param ContactNumber the ContactNumber to set
     */
    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }
    private String ContactName;
    private String ContactNumber;
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;


/**
 *
 * @author Stiv
 */
public class PhoneBkData {

    /**
     * @return the contactList
     */
    public ArrayList<PhoneBkItem> getContactList() {
        return contactList;
    }
    private int counter = 0 ;
    /**
     * @param contactList the contactList to set
     */
    public void setContactList(ArrayList<PhoneBkItem> contactList) {
        this.contactList = contactList;
    }
    
    private ArrayList<PhoneBkItem> contactList;
    PropertyChangeListener pcl;
    
    public PhoneBkData()
    {
        contactList = new  ArrayList<PhoneBkItem>();
        
    }
    
    public void addPropertyChangeListener(PropertyChangeListener outsidePcl)
    {
        pcl = outsidePcl;
    }
    
    public PropertyChangeListener getPropertyChangeListener(){
        return pcl;
    }
    
    public boolean addContact(String _contactName, String _contactNumber)
    {
        //if is a phone number it must be at least 7 digits
        //for name it 
        if (_contactName==null||_contactNumber==null) return false;
        if (_contactName.equals("")) return false;
        if (_contactNumber.length()<7) return false;
        if (!_contactNumber.matches("^\\+?\\d{7,}$")) return false; 
        contactList.forEach(contact -> {
            if(contact.getContactName().equalsIgnoreCase(_contactName)){
                throw new IllegalArgumentException(_contactName + " already exists.");
                }
            if(contact.getContactNumber().equalsIgnoreCase(_contactNumber)){
                throw new IllegalArgumentException(_contactNumber + " already exists."); }});

        PhoneBkItem pbi = new PhoneBkItem(_contactName, _contactNumber);
        getContactList().add(pbi);
        counter++;
        if (pcl!=null) pcl.propertyChange(new PropertyChangeEvent(this, "contactAdded", null, this));
        return true;
    }
    
    public int getSize()
    {
        return getContactList().size();
    }
    
    public int findContactAt(String _contactName, String _contactNumber)
    {
        for (int i=0;i<getContactList().size();i++)
        {
            if (getContactList().get(i).equals(_contactName,_contactNumber)) return i;
        }
        return -1;
    }
    
    
    public boolean deleteContact(String _contactName, String _contactNumber)
    {
        int at = findContactAt(_contactName,_contactNumber);
        if (at<0) return false;
        getContactList().remove(at);
        counter--;
        if (pcl!=null) pcl.propertyChange(new PropertyChangeEvent(this, "contactDeleted", null, this));
        return true;
        
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
 
//    .stream()
//                .filter(coach -> coach.getName().equalsIgnoreCase(name))
//                .findFirst()
//                .orElseThrow(() -> new NoSuchElementException("Booking not found"));

            
    
}




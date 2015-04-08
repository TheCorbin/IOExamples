/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ryancorbin
 */
public class ContactReader {
    
    List<Contact> contacts = new ArrayList();
    
    public static void main(String[] args) throws Exception{
    
    
    }
    
    public List readFile(String fileName) throws Exception{
        
    File file = new File(File.separatorChar + "Users" + File.separatorChar + "ryancorbin" + File.separatorChar 
                        + fileName);
    
    
    int lineCount = 0;
    Contact person = new Contact();
    
    BufferedReader in = null; 
    
    try {
	   in = new BufferedReader(new FileReader(file));
	   String line = in.readLine();
           
	   while(line != null){
               
               String[] a = line.split(" ");
               
               if (lineCount == 0){
                   person.setfName(a[0]);
                   person.setlName(a[1]);
               } else if (lineCount == 1){
                   person.setAddress(line);
               } else if (lineCount == 2){
                   person.setCity(a[0]);
                   person.setState(a[1]);
                   person.setZip(a[2]);
               }
               line = in.readLine();
               lineCount++;
               if (lineCount == 3)
               {
                   contacts.add(person);
                   person = new Contact();
                   lineCount = 0;
                   line = in.readLine();
               }
           }
           
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
  
    for (Contact contact: contacts){
        System.out.println("First Name: " + contact.getfName());
        System.out.println("Last Name: " + contact.getlName());
        System.out.println("Address: " + contact.getAddress());
        System.out.println("City: " + contact.getCity());
        System.out.println("State: " + contact.getState());
        System.out.println("Zip: " + contact.getZip());
        System.out.println(" ");
    }
    return contacts;
    }   
}

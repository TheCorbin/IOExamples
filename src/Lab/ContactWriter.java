/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ryancorbin
 */
public class ContactWriter {
    List<Contact> contacts = new ArrayList();
    
    BufferedWriter out = null;
    File file;

    public ContactWriter(String fileName) {
        this.file = new File(File.separatorChar + "Users" + File.separatorChar + "ryancorbin" + File.separatorChar 
                        + fileName);
    }
       
    
    public void writeFile(List<Contact> contacts) throws Exception{
    int lineCount = 0;
    
    try {
           out = new BufferedWriter(new FileWriter(file));
	   String line = "";
           String newLine = System.getProperty("line.separator");
           
	   for(Contact contact: contacts){
               
               lineCount = 0;
               while(lineCount < 3){ 
                   if (lineCount == 0){
                        line = contact.getfName() + " " + contact.getlName() + newLine;
                   } else if (lineCount == 1){
                       line = contact.getAddress() + newLine;
                   } else if (lineCount == 2){
                       line = contact.getCity() + " " + contact.getState() + " " + contact.getZip() + newLine;
                   }
                   out.write(line);
                   lineCount++;
               }
               out.write(newLine);
           }
           
        } catch(IOException ioe) {
            throw ioe;
        } finally {
            try {
                out.close();
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
    }
    
    
    public void writeContact(Contact contact) throws Exception{
        
        int lineCount = 0;
        
        try {
           out = new BufferedWriter(new FileWriter(file, true));
	   String line = "";
           String newLine = System.getProperty("line.separator");
        
           lineCount = 0;
               while(lineCount < 3){ 
                   if (lineCount == 0){
                        line = contact.getfName() + " " + contact.getlName() + newLine;
                   } else if (lineCount == 1){
                       line = contact.getAddress() + newLine;
                   } else if (lineCount == 2){
                       line = contact.getCity() + " " + contact.getState() + " " + contact.getZip() + newLine;
                   }
                   out.append(line);
                   System.out.println(line);
                   lineCount++;
               }
               
        }  catch(IOException ioe) {
            throw ioe;
        } finally {
            try {
                out.close();
            } catch(Exception e) {
                
            }
        }
    } 
    
}
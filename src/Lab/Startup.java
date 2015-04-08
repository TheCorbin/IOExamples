/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryancorbin
 */
public class Startup {
    
    public static void main(String[] args) {
        
    
    
    ContactReader reader = new ContactReader();
    ContactWriter writer = new ContactWriter("output.txt");
            
    List<Contact> contacts = new ArrayList();
    
    try{
        contacts = reader.readFile("test.txt");
    } catch (Exception ex) {
           System.out.println("NO SUCH FILE EXSISTS");
    }
    
    try{
        writer.writeFile(contacts);
    } catch (Exception ex) {
           System.out.println("NO SUCH FILE EXSISTS");
    }
   
    Contact Steve = new Contact("Susan", "Bot", "123 Robot Street", "BotTown", "WI", "53066");
    
    try{
        writer.writeContact(Steve);
    }catch (Exception ex){
        System.out.println("NO SUCH FILE EXSISTS");
    }
    
    
    
    
    } 
    
}

package com.group7.nomnom;
 
import static com.group7.nomnom.User.login;
import forms.login_page;
import java.util.Scanner;
 
/**
*
* @author mc4ev
*/
public class main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_page().setVisible(true);
            }
        });
        
        Scanner scanner = new Scanner(System.in);
        User user = null;
        int attempts = 0; // Counter for login attempts
        final int MAX_ATTEMPTS = 3; // Maximum allowed attempts
 
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
 
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
 
            user = login(username, password);
 
            if (user != null) {
                System.out.println("Welcome, " + user.name + "!");
                // Redirect to role-specific menu
                if (user instanceof Customer) {
                    ((Customer) user).menu();
                } else if (user instanceof Manager) {
                    ((Manager) user).menu();
                } else if (user instanceof Admin) {
                    ((Admin) user).menu();
                } else if (user instanceof Courier) {
                    ((Courier) user).menu();
                } else if (user instanceof Vendor) {
                    ((Vendor) user).menu();
                }
                break; // Exit the loop if login is successful
            } else {
                attempts++;
                System.out.println("Invalid credentials. Attempt " + attempts + " of " + MAX_ATTEMPTS + ".");
                if (attempts == MAX_ATTEMPTS) {
                    System.out.println("Too many failed attempts. Program exiting.");
                }
            }
        }
 
        scanner.close();
    }
}

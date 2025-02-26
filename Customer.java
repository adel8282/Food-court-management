/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group7.nomnom;

/**
 *
 * @author mc4ev
 */

public class Customer extends User {
    private double balance;

    public Customer(int id, String name, String username, String password, double balance) {
        super(id, name, username, password);
        this.balance = balance;
    }

    public void menu() {
        System.out.println("Customer Menu:");
        System.out.println("1. View Balance");
        System.out.println("2. Update Profile");
        System.out.println("3. Logout");
    }
}

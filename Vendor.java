/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group7.nomnom;

/**
 *
 * @author mc4ev
 */
public class Vendor extends User {
    public Vendor(int id, String name, String username, String password) {
        super(id, name, username, password);
    }

    public void menu() {
        System.out.println("Vendor Menu:");
        System.out.println("1. View Products");
        System.out.println("2. Add New Product");
        System.out.println("3. Logout");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group7.nomnom;

/**
 *
 * @author mc4ev
 */
public class Manager extends User{
    public Manager(int id, String name, String username, String password) {
        super(id, name, username, password);
    }

    public void menu() {
        System.out.println("Manager Menu:");
        System.out.println("1. View Reports");
        System.out.println("2. Manage Users");
        System.out.println("3. Logout");
    }
}

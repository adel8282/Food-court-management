/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group7.nomnom;

import static com.group7.nomnom.FileHandler.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author mc4ev
 */
public class User {
    protected int id;
    protected String name;
    protected String username;
    protected String password;

    public User(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public static User login(String username, String password) {
        JSONArray usersArray = readFromFile("users");

        if (usersArray != null) {
            for (Object obj : usersArray) {
                JSONObject userObj = (JSONObject) obj;
                int id = (int) userObj.get("id");
                String name = (String) userObj.get("name");
                String userUsername = (String) userObj.get("username");
                String userPassword = (String) userObj.get("password");
                String role = (String) userObj.get("role");

                if (userUsername.equals(username) && userPassword.equals(password)) {
                    switch (role.toLowerCase()) {
                        case "customer":
                            double balance = ((Number) userObj.get("balance")).doubleValue();
                            return new Customer(id, name, username, password, balance);
                        case "manager":
                            return new Manager(id, name, username, password);
                        case "admin":
                            return new Admin(id, name, username, password);
                        case "courier":
                            return new Courier(id, name, username, password);
                        case "vendor":
                            return new Vendor(id, name, username, password);
                        default:
                            return null;
                    }
                }
            }
        }

        return null;
    }
}

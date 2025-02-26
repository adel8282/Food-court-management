/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.group7.nomnom;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mc4ev
 */
public class FileHandler {
        public static JSONArray readFromFile(String arrayName) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("src/main/java/com/group7/nomnom/data.txt")) {
            JSONObject fileObject = (JSONObject) parser.parse(reader);
            return (JSONArray) fileObject.get(arrayName);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null; // Return null if any error occurs
        }
    }

    public static void writeToFile(String filename, JSONArray data) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data.toJSONString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

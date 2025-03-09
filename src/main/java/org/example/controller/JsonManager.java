package org.example.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.University;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class JsonManager {
    private Gson gson;


    public JsonManager() {
        // Створення GSON з налаштуваннями для більш читабельного виведення
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }


    public String universityToJson(University university) {
        return gson.toJson(university);
    }


    public University jsonToUniversity(String json) {
        return gson.fromJson(json, University.class);
    }


    public void writeUniversityToFile(University university, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(universityToJson(university));
        }
    }


    public University readUniversityFromFile(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            StringBuilder jsonBuilder = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                jsonBuilder.append((char) character);
            }
            return jsonToUniversity(jsonBuilder.toString());
        }
    }
}
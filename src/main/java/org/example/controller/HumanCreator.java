package org.example.controller;

import org.example.model.Human;
import org.example.model.Sex;


public class HumanCreator {

    public Human createHuman(String firstName, String lastName, String middleName, Sex sex) {
        return new Human(firstName, lastName, middleName, sex);
    }
}
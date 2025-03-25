package ntudp.lab3.controller;

import ntudp.lab3.model.Human;
import ntudp.lab3.model.Sex;


public class HumanCreator {

    public Human createHuman(String firstName, String lastName, String middleName, Sex sex) {
        return new Human(firstName, lastName, middleName, sex);
    }
}
package org.example.model;

import java.util.ArrayList;
import java.util.List;


public class University extends UniversityUnit {
    private List<Faculty> faculties;


    public University(String name, Human head) {
        super(name, head);
        this.faculties = new ArrayList<>();
    }


    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public boolean removeFaculty(Faculty faculty) {
        return faculties.remove(faculty);
    }

    public List<Faculty> getFaculties() {
        return new ArrayList<>(faculties);
    }

    @Override
    public String toString() {
        return "Університет: " + name + ", Ректор: " + head + ", Кількість факультетів: " + faculties.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;

        University university = (University) obj;

        return faculties.equals(university.faculties);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + faculties.hashCode();
        return result;
    }
}

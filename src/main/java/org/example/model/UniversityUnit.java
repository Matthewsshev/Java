package org.example.model;


public abstract class UniversityUnit {
    protected String name;
    protected Human head;


    public UniversityUnit(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        UniversityUnit that = (UniversityUnit) obj;

        if (!name.equals(that.name)) return false;
        return head.equals(that.head);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + head.hashCode();
        return result;
    }
}
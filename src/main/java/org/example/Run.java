package org.example;

import org.example.controller.*;
import org.example.model.*;


public class Run {
    public static void main(String[] args) {
        System.out.println("Створення типового університету...");
        University university = createTypicalUniversity();
        System.out.println(university);

        // Виведення структури університету
        printUniversityStructure(university);
    }


    public static University createTypicalUniversity() {
        // Створення необхідних творців
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator();
        GroupCreator groupCreator = new GroupCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        UniversityCreator universityCreator = new UniversityCreator();

        // Створення ректора університету
        Human rector = humanCreator.createHuman("Іван", "Петренко", "Олексійович", Sex.MALE);

        // Створення університету
        University university = universityCreator.createUniversity("Київський національний університет", rector);

        // Створення факультету інформатики
        Human dean1 = humanCreator.createHuman("Олександр", "Коваленко", "Миколайович", Sex.MALE);
        Faculty computerScienceFaculty = facultyCreator.createFaculty("Факультет інформатики", dean1);

        // Створення кафедри програмування
        Human departmentHead1 = humanCreator.createHuman("Марія", "Іваненко", "Петрівна", Sex.FEMALE);
        Department programmingDepartment = departmentCreator.createDepartment("Кафедра програмування", departmentHead1);

        // Створення групи CS-101
        Human groupHead1 = humanCreator.createHuman("Олег", "Сидоренко", "Васильович", Sex.MALE);
        Group csGroup = groupCreator.createGroup("CS-101", groupHead1);

        // Додавання студентів до групи
        Student student1 = studentCreator.createStudent("Андрій", "Мельник", "Ігорович", Sex.MALE, "CS-101-001");
        Student student2 = studentCreator.createStudent("Ольга", "Шевченко", "Михайлівна", Sex.FEMALE, "CS-101-002");
        groupCreator.addStudentToGroup(csGroup, student1);
        groupCreator.addStudentToGroup(csGroup, student2);

        // Додавання групи до кафедри
        departmentCreator.addGroupToDepartment(programmingDepartment, csGroup);

        // Створення групи CS-102
        Human groupHead2 = humanCreator.createHuman("Наталія", "Бондаренко", "Вікторівна", Sex.FEMALE);
        Group csGroup2 = groupCreator.createGroup("CS-102", groupHead2);

        // Додавання студентів до групи
        Student student3 = studentCreator.createStudent("Віктор", "Коваль", "Сергійович", Sex.MALE, "CS-102-001");
        Student student4 = studentCreator.createStudent("Ірина", "Ткаченко", "Андріївна", Sex.FEMALE, "CS-102-002");
        groupCreator.addStudentToGroup(csGroup2, student3);
        groupCreator.addStudentToGroup(csGroup2, student4);

        // Додавання групи до кафедри
        departmentCreator.addGroupToDepartment(programmingDepartment, csGroup2);

        // Створення кафедри комп'ютерної інженерії
        Human departmentHead2 = humanCreator.createHuman("Сергій", "Лисенко", "Вікторович", Sex.MALE);
        Department computerEngineeringDepartment = departmentCreator.createDepartment("Кафедра комп'ютерної інженерії", departmentHead2);

        // Створення групи CE-101
        Human groupHead3 = humanCreator.createHuman("Валентина", "Пономаренко", "Іванівна", Sex.FEMALE);
        Group ceGroup = groupCreator.createGroup("CE-101", groupHead3);

        // Додавання студентів до групи
        Student student5 = studentCreator.createStudent("Дмитро", "Захарченко", "Олегович", Sex.MALE, "CE-101-001");
        Student student6 = studentCreator.createStudent("Юлія", "Кравченко", "Сергіївна", Sex.FEMALE, "CE-101-002");
        groupCreator.addStudentToGroup(ceGroup, student5);
        groupCreator.addStudentToGroup(ceGroup, student6);

        // Додавання групи до кафедри
        departmentCreator.addGroupToDepartment(computerEngineeringDepartment, ceGroup);

        // Додавання кафедр до факультету
        facultyCreator.addDepartmentToFaculty(computerScienceFaculty, programmingDepartment);
        facultyCreator.addDepartmentToFaculty(computerScienceFaculty, computerEngineeringDepartment);

        // Створення факультету економіки
        Human dean2 = humanCreator.createHuman("Тетяна", "Григоренко", "Юріївна", Sex.FEMALE);
        Faculty economicsFaculty = facultyCreator.createFaculty("Факультет економіки", dean2);

        // Створення кафедри менеджменту
        Human departmentHead3 = humanCreator.createHuman("Роман", "Білоус", "Андрійович", Sex.MALE);
        Department managementDepartment = departmentCreator.createDepartment("Кафедра менеджменту", departmentHead3);

        // Створення групи MG-101
        Human groupHead4 = humanCreator.createHuman("Микола", "Павленко", "Олександрович", Sex.MALE);
        Group mgGroup = groupCreator.createGroup("MG-101", groupHead4);

        // Додавання студентів до групи
        Student student7 = studentCreator.createStudent("Лілія", "Даниленко", "Миколаївна", Sex.FEMALE, "MG-101-001");
        Student student8 = studentCreator.createStudent("Павло", "Романенко", "Іванович", Sex.MALE, "MG-101-002");
        groupCreator.addStudentToGroup(mgGroup, student7);
        groupCreator.addStudentToGroup(mgGroup, student8);

        // Додавання групи до кафедри
        departmentCreator.addGroupToDepartment(managementDepartment, mgGroup);

        // Додавання кафедри до факультету
        facultyCreator.addDepartmentToFaculty(economicsFaculty, managementDepartment);

        // Додавання факультетів до університету
        universityCreator.addFacultyToUniversity(university, computerScienceFaculty);
        universityCreator.addFacultyToUniversity(university, economicsFaculty);

        return university;
    }


    public static void printUniversityStructure(University university) {
        System.out.println("\nСтруктура університету:");
        System.out.println("Університет: " + university.getName() + " | Ректор: " + university.getHead());

        // Виведення факультетів
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\n  Факультет: " + faculty.getName() + " | Декан: " + faculty.getHead());

            // Виведення кафедр
            for (Department department : faculty.getDepartments()) {
                System.out.println("    Кафедра: " + department.getName() + " | Завідувач: " + department.getHead());

                // Виведення груп
                for (Group group : department.getGroups()) {
                    System.out.println("      Група: " + group.getName() + " | Староста: " + group.getHead());

                    // Виведення студентів
                    for (Student student : group.getStudents()) {
                        System.out.println("        Студент: " + student.getLastName() + " " + student.getFirstName() +
                                " | Ст. квиток: " + student.getStudentId());
                    }
                }
            }
        }
    }
}
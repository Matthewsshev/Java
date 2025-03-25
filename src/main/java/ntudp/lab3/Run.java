package ntudp.lab3;

import ntudp.lab3.controller.*;
import ntudp.lab3.model.*;


public class Run {
    public static void main(String[] args) {
        System.out.println("Creating a typical university...");
        University university = createTypicalUniversity();
        System.out.println(university);

        printUniversityStructure(university);
    }


    public static University createTypicalUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator();
        GroupCreator groupCreator = new GroupCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        UniversityCreator universityCreator = new UniversityCreator();

        Human rector = humanCreator.createHuman("John", "Smith", "William", Sex.MALE);

        University university = universityCreator.createUniversity("Stanford University", rector);

        Human dean1 = humanCreator.createHuman("Michael", "Johnson", "Robert", Sex.MALE);
        Faculty computerScienceFaculty = facultyCreator.createFaculty("Faculty of Computer Science", dean1);

        Human departmentHead1 = humanCreator.createHuman("Emily", "Davis", "Elizabeth", Sex.FEMALE);
        Department programmingDepartment = departmentCreator.createDepartment("Department of Programming", departmentHead1);

        Human groupHead1 = humanCreator.createHuman("David", "Brown", "Andrew", Sex.MALE);
        Group csGroup = groupCreator.createGroup("CS-101", groupHead1);

        Student student1 = studentCreator.createStudent("Robert", "Wilson", "Thomas", Sex.MALE, "CS-101-001");
        Student student2 = studentCreator.createStudent("Sarah", "Taylor", "Emma", Sex.FEMALE, "CS-101-002");
        groupCreator.addStudentToGroup(csGroup, student1);
        groupCreator.addStudentToGroup(csGroup, student2);

        departmentCreator.addGroupToDepartment(programmingDepartment, csGroup);

        Human groupHead2 = humanCreator.createHuman("Jessica", "Miller", "Louise", Sex.FEMALE);
        Group csGroup2 = groupCreator.createGroup("CS-102", groupHead2);

        Student student3 = studentCreator.createStudent("Kevin", "Anderson", "James", Sex.MALE, "CS-102-001");
        Student student4 = studentCreator.createStudent("Rachel", "Martinez", "Grace", Sex.FEMALE, "CS-102-002");
        groupCreator.addStudentToGroup(csGroup2, student3);
        groupCreator.addStudentToGroup(csGroup2, student4);

        departmentCreator.addGroupToDepartment(programmingDepartment, csGroup2);

        Human departmentHead2 = humanCreator.createHuman("Christopher", "Thompson", "Daniel", Sex.MALE);
        Department computerEngineeringDepartment = departmentCreator.createDepartment("Department of Computer Engineering", departmentHead2);

        Human groupHead3 = humanCreator.createHuman("Amanda", "Harris", "Claire", Sex.FEMALE);
        Group ceGroup = groupCreator.createGroup("CE-101", groupHead3);

        Student student5 = studentCreator.createStudent("Ryan", "Clark", "Michael", Sex.MALE, "CE-101-001");
        Student student6 = studentCreator.createStudent("Lauren", "Lewis", "Sophia", Sex.FEMALE, "CE-101-002");
        groupCreator.addStudentToGroup(ceGroup, student5);
        groupCreator.addStudentToGroup(ceGroup, student6);

        departmentCreator.addGroupToDepartment(computerEngineeringDepartment, ceGroup);

        facultyCreator.addDepartmentToFaculty(computerScienceFaculty, programmingDepartment);
        facultyCreator.addDepartmentToFaculty(computerScienceFaculty, computerEngineeringDepartment);

        Human dean2 = humanCreator.createHuman("Elizabeth", "Roberts", "Anne", Sex.FEMALE);
        Faculty economicsFaculty = facultyCreator.createFaculty("Faculty of Economics", dean2);

        Human departmentHead3 = humanCreator.createHuman("Daniel", "White", "Joseph", Sex.MALE);
        Department managementDepartment = departmentCreator.createDepartment("Department of Management", departmentHead3);

        Human groupHead4 = humanCreator.createHuman("Mark", "Green", "Steven", Sex.MALE);
        Group mgGroup = groupCreator.createGroup("MG-101", groupHead4);

        Student student7 = studentCreator.createStudent("Jennifer", "Garcia", "Marie", Sex.FEMALE, "MG-101-001");
        Student student8 = studentCreator.createStudent("Thomas", "Rodriguez", "Henry", Sex.MALE, "MG-101-002");
        groupCreator.addStudentToGroup(mgGroup, student7);
        groupCreator.addStudentToGroup(mgGroup, student8);

        departmentCreator.addGroupToDepartment(managementDepartment, mgGroup);

        facultyCreator.addDepartmentToFaculty(economicsFaculty, managementDepartment);

        universityCreator.addFacultyToUniversity(university, computerScienceFaculty);
        universityCreator.addFacultyToUniversity(university, economicsFaculty);

        return university;
    }


    public static void printUniversityStructure(University university) {
        System.out.println("\nUniversity Structure:");
        System.out.println("University: " + university.getName() + " | Rector: " + university.getHead());

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\n  Faculty: " + faculty.getName() + " | Dean: " + faculty.getHead());

            for (Department department : faculty.getDepartments()) {
                System.out.println("    Department: " + department.getName() + " | Head: " + department.getHead());

                for (Group group : department.getGroups()) {
                    System.out.println("      Group: " + group.getName() + " | Group Leader: " + group.getHead());

                    for (Student student : group.getStudents()) {
                        System.out.println("        Student: " + student.getLastName() + " " + student.getFirstName() +
                                " | Student ID: " + student.getStudentId());
                    }
                }
            }
        }
    }
}
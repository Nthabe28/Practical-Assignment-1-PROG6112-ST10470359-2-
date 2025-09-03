/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolmanagement;

import java.util.Scanner;

/**
 *
 * @author ST10470359
 */
public class Teacher extends Person {//Teacher is the subclass of person(child class)

    //Declaration
    public String module;
    private String department;
    Student[] students;
    private int studCount;
    private int maxStudent;
    Scanner input = new Scanner(System.in);

    //Constructors
    public Teacher(String module, String department, Student[] students, int studCount, int maxStudent, String name, String age) {
        super(name, age);
        this.module = module;
        this.department = department;
        this.students = new Student[maxStudent];
        this.studCount = 0;
        this.maxStudent = maxStudent;
    }

   
    public Teacher(String name, String age) {
        super(name, age);
    }

     //Getters and Setters
    public String getDeparment() {
        return department;
    }

    public void setDeparment(String deparment) {
        this.department = deparment;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getStudCount() {
        return studCount;
    }

    public void setStudCount(int studCount) {
        this.studCount = studCount;
    }

    //Methods
    public Teacher[] captureTeacher() {//Captures Teachers information
        System.out.println("How many teachers to capture: ");
        int count = Integer.parseInt(input.nextLine());

        Teacher[] teachers = new Teacher[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Capture Teacher "+(i+1));
            teachers[i]= new Teacher("","");
            teachers[i].BasicDetails();

            System.out.print("Please enter Teacher's department: ");
            teachers[i].department = input.nextLine();
            System.out.print("Please enter the module the Teacher teaches: ");
            teachers[i].module = input.nextLine();
            System.out.print("Please enter the max number of students a teacher can have: ");
            teachers[i].maxStudent = Integer.parseInt(input.nextLine());

            teachers[i].students = new Student[teachers[i].maxStudent];
            teachers[i].studCount = 0;
        }
        return teachers;//Returns teacher array

    }

    //Method assigns students to teachers with same module
    public void assignStudToModule(Student[] allStudents) {
        studCount = 0;

        for (int i = 0; i < allStudents.length; i++) {
            if (studCount >= maxStudent) {
                System.out.println("Max student capacity exceeded for " + getName());
            }
            Student student = allStudents[i];
            if (student != null && student.getModules() != null) {
                for (String studentModule : student.getModules()) {
                    if (studentModule != null && studentModule.equalsIgnoreCase(this.module)) {
                        students[studCount] = student;
                        studCount++;
                        student.teacher = this;
                    }
                }
            }

        }
    }

    //This method displays teachers information and the students within the module of the teacher
    public void displayTeacher() {
        System.out.println("-------TEACHER INFORMATION---------------\n"
                + "Name: " + name + "\n"
                + "Age: " + age + "\n"
                + "Department: " + department + "\n"
                + "Module: " + module + "\n"
                + "Students: " + studCount + "/" + maxStudent);

        if (studCount > 0) {
            System.out.println("Student List: ");
            for (int i = 0; i < studCount; i++) {
                System.out.println(" " + (i + 1) + ". " + students[i].name);
            }
        }

    }
}

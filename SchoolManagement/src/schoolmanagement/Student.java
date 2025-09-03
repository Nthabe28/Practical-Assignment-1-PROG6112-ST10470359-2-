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
public class Student extends Person {//Student is the subclass of Person(child class)

    //Declaration
    private String[] modules;
    private int[][] grade;
    private double[] averages;
    int noMarks;
    int noModules;
    Teacher teacher;

    Scanner input = new Scanner(System.in);

    //Constructor
    public Student(String name, String age) {
        super(name, age);
    }

    //Setters and Getters
    public void setModules(String[] modules) {
        this.modules = modules;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String[] getModules() {
        return modules;
    }

    public int[][] getGrade() {
        return grade;
    }

    public void setGrade(int[][] grade) {
        this.grade = grade;
    }

    public double[] getAverages() {
        return averages;
    }

    public void setAverages(double[] averages) {
        this.averages = averages;
    }

    public int getNoMarks() {
        return noMarks;
    }

    public void setNoMarks(int noMarks) {
        this.noMarks = noMarks;
    }

    public int getNoModules() {
        return noModules;
    }

    public void setNoModules(int noModules) {
        this.noModules = noModules;
    }

    //Methods
    public Student[] captureStudent() {//Method that captures student information

        System.out.println("How many student to capture: ");
        int count = Integer.parseInt(input.nextLine());
        Student[] students = new Student[count];//Initailizing student array

        for (int i = 0; i < count; i++) {
            System.out.println("Capture student: " + (i + 1));
            students[i] = new Student("", "");
            students[i].BasicDetails();

            System.out.print("Enter the number of Modules: " + students[i].name + ": ");
            int noModules = Integer.parseInt(input.nextLine());

            System.out.print("Enter the number of marks for each Module: ");
            noMarks = Integer.parseInt(input.nextLine());

            students[i].modules = new String[noModules];
            students[i].grade = new int[noModules][noMarks];
            students[i].averages = new double[noModules];

            for (int j = 0; j < noModules; j++) {
                System.out.print("Enter module " + (j + 1) + ": ");
                students[i].modules[j] = input.nextLine();

                int sum = 0;
                for (int t = 0; t < noMarks; t++) {
                    System.out.println("Enter the grade for " + students[i].modules[j] + " mark " + (t + 1) + ": ");
                    students[i].grade[j][t] = Integer.parseInt(input.nextLine());
                    sum += students[i].grade[j][t];//Calculates average according to the grades entered from user

                }
                students[i].averages[j] = (double) sum / noMarks;
                System.out.println("Average for " + students[i].modules[j] + ": " + students[i].averages[j]);
            }
        }

        return students;//Returns the student array
    }

    //Method displays student information that is captured
    public void displayStudentInfo() {
        System.out.println("-----STUDENT INFORMATION -----------\n"
                + "Name: " + name + "\n"
                + "Age: " + age + "\n ");

        if (teacher != null) {
            System.out.println("Teacher: " + teacher.name +" "+ teacher.module);//Displays teacher associated with the modules eneterd
        }

        if (modules == null || grade == null || averages == null) {
            System.out.println("No modules captured for this student.");
            return;
        }

        System.out.print("-----MODULES AND GRADES--------------\n");
        for (int i = 0; i < modules.length; i++) {
            System.out.println("Module: " + modules[i] + "\n"
                    + "Grades: ");
            for (int j = 0; j < grade[i].length; j++) {
                System.out.print(grade[i][j] + " ");
            }
            System.out.println("\n1Average: " + averages[i]);
            //Classifys student's average
            if (averages[i] >= 90) {
                System.out.println("Grade: A (Excellent)");
            } else if (averages[i] >= 80) {
                System.out.println("Grade: B (Very Good)");
            } else if (averages[i] >= 70) {
                System.out.println("Grade: C (Good)");
            } else if (averages[i] >= 60) {
                System.out.println("Grade: D (Satisfactory)");
            } else {
                System.out.println("Grade: F (Fail)");
            }
        }

    }
}

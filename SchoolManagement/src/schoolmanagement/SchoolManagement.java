/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolmanagement;

import java.util.Scanner;

/**
 *
 * @author ST10470359
 */
public class SchoolManagement {

    /**
     * @param args the command line arguments
     */
    //Declaration
    private static Student[] students;
    private static Teacher[] teachers;

    public static void main(String[] args) {
        // Declaration

        Scanner input = new Scanner(System.in);

        Student st = new Student("", "");
        Teacher te = new Teacher("", "");

        //This Menu
        while (true) {
            System.out.println("-----Menu-------\n"
                    + "1. Capture Students" + "\n"
                    + "2. Capture Teachers" + "\n"
                    + "3. Display Students" + "\n"
                    + "4. Display Teachers" + "\n"
                    + "5. Exit ");
            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {

                case 1:

                    //Option 1 allows user to capture student
                    students = st.captureStudent();
                    if (teachers != null) {
                        for (Teacher t : teachers) {
                            if (t != null) {
                                t.assignStudToModule(students);
                            }
                        }
                    }
                    break;
                case 2:
                    //Option 2 allows user to capture the teacher
                    teachers = te.captureTeacher();
                    if (students != null) {
                        for (Teacher t : teachers) {
                            if (t != null) {
                                t.assignStudToModule(students);
                            }
                        }
                    }
                    break;
                case 3:
                    //Option 3 displays all captured students
                    if (students != null) {
                        for (Student stu : students) {
                            if (stu != null) {
                                stu.displayStudentInfo();
                            }
                        }
                    }

                    break;
                case 4:
                    //Option 4 displays all captured teachers an students who are assigned to the teacher
                    if (teachers != null) {
                        for (Teacher tch : teachers) {
                            if (tch != null) {
                                tch.displayTeacher();
                            }
                        }
                    }

                    break;
                case 5:
                    //Option 5 exits the application or program
                    System.out.println("Goodbye");
                    System.exit(0);
 
                    break;
                default:
                    System.out.println("Unexcaptable choice");

            }
        }

    }
    

}

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
//This is the superclass(parent class)
public class Person {
    
    //Declaration
    protected String name;
    protected String age;
    Scanner input = new Scanner(System.in);

    //Constructor
    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
    
    //Setters and Getters

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    //Method to obtain Person's name and age
public void BasicDetails(){
    System.out.println("Enter name: ");
    this.name=input.nextLine();
    System.out.println("Enter age: ");
    this.age=input.nextLine();
}
    
    
    
}

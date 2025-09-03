/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package schoolmanagement;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 *
 * @author moloi
 */
public class PersonTest {
    
    public PersonTest() {
    }


    @Test
    public void testBasicDetails() {
        Person p1 = new Person("John", "40");
        Person p2 = new Person("Rose", "20");

        assertEquals("John", p1.getName());
        assertEquals("40", p1.getAge());

        assertEquals("Rose", p2.getName());
        assertEquals("20", p2.getAge());
    }
    
}

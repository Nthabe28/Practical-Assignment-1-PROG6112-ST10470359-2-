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
public class StudentTest {

    private Student student1;
    private Student student2;
    private Teacher teacher;

    public StudentTest() {
    }

   

    @Test
    public void testDisplayStudentInfo() {
        Student s = new Student("Rose", "20");
        s.setModules(new String[]{"Prog6112"});
        s.setGrade(new int[][]{{85, 95}});
        s.setAverages(new double[]{90.0});

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        s.displayStudentInfo(); // assuming it prints details

        String output = out.toString();
        assertTrue(output.contains("Rose"));
        assertTrue(output.contains("Prog6112"));
        assertTrue(output.contains("Average"));

    }

}

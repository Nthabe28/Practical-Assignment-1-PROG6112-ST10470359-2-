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
public class TeacherTest {

    private Student student1;
    private Student student2;
    private Teacher teacher;

    public TeacherTest() {
    }

   

    @Test
    public void testAssignStudToModule() {
        Student student = new Student("", "");
        student.setModules(new String[]{"Prog6112"});
        student.setGrade(new int[][]{{90, 100}});
        student.setAverages(new double[]{95.0});

        Teacher teacher = new Teacher("John", "40");
        teacher.module = "Prog6112";
        teacher.setDeparment("Science Dept");
        teacher.setStudents(new Student[2]);

        teacher.assignStudToModule(new Student[]{student});

        assertEquals("Prog6112", student.getModules()[0]);
        assertEquals(95.0, student.getAverages()[0], 0.01);
    }

    @Test
    public void testDisplayTeacher() {
      Student s = new Student("Rose", "20");
        s.setModules(new String[]{"Prog6112"});
        s.setGrade(new int[][]{{80, 90}});
        s.setAverages(new double[]{85.0});

        Teacher t = new Teacher("John", "40");
        t.setDeparment("Science");
        t.module = "Prog6112";
        t.setStudents(new Student[2]);
        t.assignStudToModule(new Student[]{s});

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        t.displayTeacher();

        String output = out.toString();
        assertTrue(output.contains("John"));
        assertTrue(output.contains("Prog6112"));
        assertTrue(output.contains("Rose"));  
        
    }

}

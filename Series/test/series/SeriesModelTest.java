/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package series;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
/*https://www.geeksforgeeks.org/advance-java/unit-testing-system-in-for-input-handling-in-junit/
https://www.geeksforgeeks.org/java/system-exit-in-java/
*/

/**
 *
 * @author ST10470359
 */
public class SeriesModelTest {

    private SeriesModel seriesModel;
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    public SeriesModelTest() {

    }

    @Test
    public void testSearchSeries() {
        String simulatedInput = "101\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesArray(new SeriesModel[]{
            new SeriesModel("101", "Extreme Sports", "12", "10")
        });

        String result = seriesModel.SearchSeries();
        assertTrue(result.contains("Extreme Sports"));
        assertTrue(result.contains("101"));

    }

    @Test
    public void testSearcSeries_SeriesNotFound() {
        String simulatedInput = "999\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesArray(new SeriesModel[]{
            new SeriesModel("101", "Extreme Sports", "12", "10")
        });

        String result = seriesModel.SearchSeries();
        assertTrue(result.contains("was not found"));
    }

    @Test
    public void testUpdateSeries() {
        String simulatedInput = "101\nExtreme Sports 2025\n12\n10\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesArray(new SeriesModel[]{
            new SeriesModel("101", "Extreme Sports", "12", "10")
        });

        seriesModel.UpdateSeries();

        SeriesModel updated = seriesModel.getSeriesArray()[0];
        assertEquals("101", updated.getSeriesID());
        assertEquals("Extreme Sports 2025", updated.getSeriesName());
        assertEquals("12", updated.getSeriesAge());
        assertEquals("10", updated.getSeriesNumberOfEpisodes());

    }

    @Test
    public void testDeleteSeries() {
        String simulatedInput = "101\ny\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesArray(new SeriesModel[]{
            new SeriesModel("101", "Extreme Sports", "12", "10")
        });

        String result = seriesModel.DeleteSeries();

        assertTrue(result.contains("WAS deleted!"));

    }

    @Test
    public void testDelete_SeriesNotFound() {
        String simulatedInput = "999\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        SeriesModel seriesModel = new SeriesModel();
        seriesModel.setSeriesArray(new SeriesModel[]{
            new SeriesModel("101", "Extreme Sports", "12", "10")
        });

        String result = seriesModel.DeleteSeries();
        assertEquals("", result);

    }

    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        String input = "1\n101\nExtreme Sports\n12\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        SeriesModel seriesModel = new SeriesModel();
        seriesModel.CaptureSeries();

        SeriesModel[] arr = seriesModel.getSeriesArray();
        assertNotNull(arr[0]);
        assertEquals("101", arr[0].getSeriesID());
        assertEquals("Extreme Sports", arr[0].getSeriesName());
        assertEquals("12", arr[0].getSeriesAge());
        assertEquals("10", arr[0].getSeriesNumberOfEpisodes());
    }

    @Test
    public void testSeriesAgeRestriction_SeriesAgeInValid() {

        String input = "1\n101\nExtreme Sports\n20\n12\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        SeriesModel seriesModel = new SeriesModel();
        seriesModel.CaptureSeries();

        String out = output.toString();

        assertTrue(out.contains("You have entered an incorrect series age!!!"));

        SeriesModel[] arr = seriesModel.getSeriesArray();
        assertNotNull(arr[0]);
        assertEquals("101", arr[0].getSeriesID());
        assertEquals("Extreme Sports", arr[0].getSeriesName());
        assertEquals("12", arr[0].getSeriesAge());
        assertEquals("10", arr[0].getSeriesNumberOfEpisodes());

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package series;

import java.util.Scanner;

/*
Referencing for both programs:
GeeksforGeeks.2025.Unit Testing System.in for Input Handling in Junit.23 July 2025.[Online]Available at: https://www.geeksforgeeks.org/advance-java/unit-testing-system-in-for-input-handling-in-junit/ [Accessed 30 August 2025]
GeeksforGeeks.2025.System.exit() in Java.21 April 2025.[Online]Available at: https://www.geeksforgeeks.org/java/system-exit-in-java/ [Accessed 30 August 2025]
GeeksforGeeks.2025.How to Extend an Array After Initialisation in Java.23 July 2025.[Online]Available at: https://www.geeksforgeeks.org/java/how-to-extend-an-array-after-initialisation-in-java/ [Accessed 15 August 2025]
GeeksforGeeks.2025.Remove an Element at Specific Index from an Array in Java.11 July 2025.[Online]Available at: https://www.geeksforgeeks.org/java/remove-an-element-at-specific-index-from-an-array-in-java/ .[Accessed 15 August 2025]
Baeldung.2024.Java ArrayIndexOutOfBoundsException.8 January 2024.[Online]Available at: https://www.baeldung.com/java-arrayindexoutofboundsexception. [Accessed 17 August 2025]
W3Schools.2025.Java Multi-Dimensional Arrays.[Online]Available at: https://www.w3schools.com/java/java_arrays_multi.asp .[Accessed 18 August 2025]
Farrell, (2023). Java programming.10 edition. USA: Cengage
OpenAI (2025) ChatGPT .Used for brainstorming only. Available at: https://chatgpt.com (Accessed: 13 August 2025)



 */

/**
 *
 * @author ST10470359
 */
public class Series {

    public Series(String SeriesID, String SeriesName, String SeriesAge, String SeriesNumberOfEpisodes) {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaration
        String LaunchMenu;
        Scanner input = new Scanner(System.in);
        SeriesModel ms = new SeriesModel();

        while (true) {
            System.out.print("LASTEST SERIES - 2025\n"
                    + "************************************\n");

            System.out.println("Enter (1) to launch menu or any other key to exit");
            LaunchMenu = input.nextLine();

            if (LaunchMenu.equals("1")) {//This launches the menu when the user enters the vaule 1

                //This is the menu display
                System.out.println("Please select one of the following menu items \n"
                        + "(1) Capture a new series. \n"
                        + "(2) Search for a series.\n"
                        + "(3) Update series \n"
                        + "(4) Delete a series.\n"
                        + "(5) Print series report - 2025.\n"
                        + "(6) Exit Application\n");

                String choice = input.nextLine();

                switch (choice) {

                    case "1":
                        //Option to capture series
                        ms.CaptureSeries();

                        break;
                    case "2":
                        //Option to search series
                        System.out.println(ms.SearchSeries());

                        break;
                    case "3":
                        //Option to update series
                        ms.UpdateSeries();
                        break;
                    case "4":
                        //Option to delete series
                        System.out.println(ms.DeleteSeries());
                        break;
                    case "5":
                        //Option to print series
                        ms.SeriesReport();
                        break;
                    case "6":
                        //Option to exit program
                        ms.ExitSeriesApplication();

                        break;
                    default:
                        System.out.println("Incorrect entry");
                }

            }

        }
    }

}

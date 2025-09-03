/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package series;

import java.util.Scanner;

/**
 *
 * @author moloi
 */
public class SeriesModel {
//Declaration
    public String SeriesID;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;
    private SeriesModel[] seriesArray;//Array to store multiple  series
    Scanner input = new Scanner(System.in);

    //Constructors
    public SeriesModel() {
    }

    public SeriesModel(String SeriesID, String SeriesName, String SeriesAge, String SeriesNumberOfEpisodes) {
        this.SeriesID = SeriesID;
        this.SeriesName = SeriesName;
        this.SeriesAge = SeriesAge;
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }

    //Getters and Setters
    public String getSeriesID() {
        return SeriesID;
    }

    public String getSeriesName() {
        return SeriesName;
    }

    public String getSeriesAge() {
        return SeriesAge;
    }

    public String getSeriesNumberOfEpisodes() {
        return SeriesNumberOfEpisodes;
    }

    public SeriesModel[] getSeriesArray() {
        return seriesArray;
    }

    public void setSeriesID(String SeriesID) {
        this.SeriesID = SeriesID;
    }

    public void setSeriesName(String SeriesName) {
        this.SeriesName = SeriesName;
    }

    public void setSeriesAge(String SeriesAge) {
        this.SeriesAge = SeriesAge;
    }

    public void setSeriesNumberOfEpisodes(String SeriesNumberOfEpisodes) {
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }

    public void setSeriesArray(SeriesModel[] seriesArray) {
        this.seriesArray = seriesArray;
    }

    //Methods
    public void CaptureSeries() {
        int NoOfSeries;

        System.out.print(" Enter the number of series you want to enter");
        NoOfSeries = Integer.parseInt(input.nextLine());

        //Increases the size of the array by coping the old series that were captured before to the new array every time the user enters a new series
        if (seriesArray == null) {
            seriesArray = new SeriesModel[NoOfSeries];
        } else {
            SeriesModel[] addArray = new SeriesModel[seriesArray.length + NoOfSeries];

            for (int i = 0; i < seriesArray.length; i++) {
                addArray[i] = seriesArray[i];
            }
            seriesArray = addArray;

        }
        //This checks where to add the new series
        int increaseArray = 0;
        while (increaseArray < seriesArray.length && seriesArray[increaseArray] != null) {
            increaseArray++;
        }

        //This loops to capture series
        for (int i = 0; i < NoOfSeries; i++) {
            System.out.println("CAPTURE A  NEW SERIES\n"
                              + "*******************************");

            System.out.print("Enter the series id ");
            SeriesID = input.nextLine();

            System.out.print("Enter the series name: ");
            SeriesName = input.nextLine();
            

            //This is where the age restriction is validated if its between ages of 2 till 18
            while (true) {
                System.out.print("Enter the series age restriction ");
                SeriesAge = input.nextLine();

                if (SeriesAge.matches("\\d+")) {
                    int ageRestriction = Integer.parseInt(SeriesAge);
                    if (ageRestriction >= 2 && ageRestriction <= 18) {
                        break;
                    } else {
                        System.out.println("You have entered an incorrect series age!!!");
                        System.out.print("Please re-enter the series age >> ");
                    }
                } else {
                    System.out.println("You have entered an incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            }

            System.out.print("Enter the number of episodes for " + SeriesName + " : ");
            SeriesNumberOfEpisodes = input.nextLine();

            if (SeriesID != null && SeriesName != null && SeriesAge != null && SeriesNumberOfEpisodes != null) {
                System.out.println("Series processed successfully!!!");
            }

            //Stores all new series that have been captured
            seriesArray[increaseArray++] = new SeriesModel(SeriesID, SeriesName, SeriesAge, SeriesNumberOfEpisodes);

        }

    }

    //This method seraches the series by the seriesID 
    public String SearchSeries() {

        String searchSeriesID;

        System.out.print("Enter the series id to search: ");
        searchSeriesID = input.nextLine();
        for (int j = 0; j < seriesArray.length; j++) {
            if (seriesArray[j] != null && seriesArray[j].getSeriesID().equals(searchSeriesID)) {
                return "-----------------------------------------------------------\n"
                        + "SERIES ID: " + seriesArray[j].getSeriesID() + "\n"
                        + "SERIES NAME: " + seriesArray[j].getSeriesName() + "\n"
                        + "SERIES AGE RESTRICTION: " + seriesArray[j].getSeriesAge() + "\n"
                        + "SERIES NUMBER OF EPISODES: " + seriesArray[j].getSeriesNumberOfEpisodes() + "\n"
                        + "---------------------------------------------------------";

            }

        }

        return "-------------------------------------------------"
                + "Series with Series Id: " + searchSeriesID + " was not found!"
                + "------------------------------------------------\n";
    }

    //This method updates existing series that have been captured by their seriesID
    public String UpdateSeries() {
        String UpdateSeriesID;
        System.out.print("\nEnter the series id to update: ");
        UpdateSeriesID = input.nextLine();
        for (int i = 0; i < seriesArray.length; i++) {
            if (seriesArray[i] != null && seriesArray[i].getSeriesID().equals(UpdateSeriesID)) {

                System.out.print("Enter the series name: ");
                String Nname = input.nextLine();
                seriesArray[i].setSeriesName(Nname);

                System.out.print("Enter the age restriction: ");
                String nAge = input.nextLine();
                seriesArray[i].setSeriesAge(nAge);

                System.out.print("Enter the number of episodes: ");
                String NewNoOfEpisodes = input.nextLine();
                seriesArray[i].setSeriesNumberOfEpisodes(NewNoOfEpisodes);

            }

        }

        return "";

    }

    //This method deletes series by their seriesID by also nullifying the array
    public String DeleteSeries() {
        String SeriesIDDelete;

        System.out.print("Enter the series id to delete: ");
        SeriesIDDelete = input.nextLine();

        for (int j = 0; j < seriesArray.length; j++) {
            if (seriesArray[j] != null && seriesArray[j].getSeriesID().equals(SeriesIDDelete)) {
                System.out.println(" Are you sure you want to delete series " + SeriesIDDelete + " from the system ? Yes (y) to delete.");
                String choice = input.nextLine();

                //this shift all the elements to the left and removes last duplicate
                if (choice.equalsIgnoreCase("Y")) {
                    for (int t = j; t < seriesArray.length - 1; t++) {
                        seriesArray[t] = seriesArray[t + 1];
                    }
                    seriesArray[seriesArray.length - 1] = null;

                    return "------------------------------------\n"
                            + "Series with Series Id: " + SeriesIDDelete + " WAS deleted! \n"
                            + "-----------------------------------";

                }

            }

        }
        return "";
    }

    //This method prints all series except the deleted series
    public void SeriesReport() {
        
        //This checks if the array is empty or null
        if (seriesArray == null || seriesArray.length == 0) {
            System.out.println("No series available to display.");
            return;
        }

        int count = 0;
        for (int i = 0; i < seriesArray.length; i++) {
            if (seriesArray[i] != null) {
                count++;
                System.out.println("Series " + count + "\n"
                        + "-----------------------------------------\n"
                        + "SERIES ID: " + seriesArray[i].getSeriesID() + "\n"
                        + "SERIES NAME: " + seriesArray[i].getSeriesName() + "\n"
                        + "SERIES AGE RESTRICTION: " + seriesArray[i].getSeriesAge() + "\n"
                        + "NUMBER OF EPISODES: " + seriesArray[i].getSeriesNumberOfEpisodes() + "\n"
                        + "------------------------------------------");
            }

        }
    }

    //This is the method that exits the application
    public void ExitSeriesApplication() {
       System.exit(0);

        
    }
}

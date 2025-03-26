/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieanalyzer;

/**
 *
 * @author iamad
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MovieDataProcessor {
    private static final Logger logger = Logger.getLogger(MovieDataProcessor.class.getName());
    private static ArrayList<Movie> Movies;
    private static ArrayList<String> warningMsg = new ArrayList();
    private static String warningMsgFile = "Warnings.txt";
    private static int indexWarning;
    
    /**
     * Assigns values from file to movie object, adds objects to movie list
     * @param filePath the file to read
     * @return a list of movies
     * @throws IOException 
     */
    public static ArrayList readCSV(String filePath) throws IOException{
        ArrayList<Movie> List = new ArrayList();
        String fileName = filePath;
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        int lineNumber = 0;
        addWaringMsg();
        
        
        //Bonus Empty File check
        if(!inputFile.hasNext()){
            System.out.println("Error: Empty File \n No Movies are available");
            System.exit(1);
        }
        while(inputFile.hasNext()){
            ++lineNumber;
            String movie;
            String title;
            String warning;
            int year;
            double starRating;
            movie = inputFile.nextLine();
            
            //Bonus Malformed Data check
            boolean malformed;
            malformed = isMalformed(movie);
            
            if (malformed){
                warning = warningMsg.get(indexWarning);
                logger.log(Level.WARNING, "Malformed Data in {0} at line: {1}: {2}", new Object[]{fileName, lineNumber, warning});
                continue;
            }
            
            String[] parsed = movie.split(",");
            title = parsed[0];
            year = Integer.parseInt(parsed[1]);
            starRating = Double.parseDouble(parsed[2]);
            Movie myMovie = new Movie(title, year, starRating);
            List.add(myMovie);    
        }
        Movies = List;
       
        return List;
    }
    /**
     * Bonus function: Checks for malformed data in file
     * @param movie the movie to check
     * @return Boolean
     */
    public static boolean isMalformed(String movie){
        boolean malformed = false;
        final int ITEMS_PER_LINE = 3;
        String[] parsed = movie.split(",");
            
        if (parsed.length < ITEMS_PER_LINE){
            indexWarning = 0;
            return true;
        }
        else if (parsed.length > ITEMS_PER_LINE){
            indexWarning = 1;
            return true;
        }
        else{
            //Checks the year datatype
            try{
                Integer.valueOf(parsed[1]);
            }
            catch(NumberFormatException e){
                indexWarning = 2;
                return true;
            }
            //Checks the rating datatype
            try {
                Double.valueOf(parsed[2]);
            }catch(NumberFormatException e) {
                indexWarning = 3;
                return true;
            }
            if (Integer.parseInt(parsed[1]) < 1888 ){     //checks if the movie comes before the date of the first movie ever made
                indexWarning = 4;
                return true;
            }
            if ((Double.parseDouble(parsed[2]) < 0) || (Double.parseDouble(parsed[2]) > 10)){ // checks if the rating is out of bounds
                indexWarning = 5;
                return true;
            }
        }
        return malformed;
    }
    /**
     * fills warning list with warnings from file;
     * @throws IOException 
     */
    public static void addWaringMsg()throws IOException{ 
        File warnings = new File(warningMsgFile);
        Scanner input = new Scanner(warnings);
        while (input.hasNext()){
            warningMsg.add(input.nextLine());
        }
        
    }
    
    /**
     * reads list of movies and returns the one with the highest rating
     * @param movies
     * @return the highest rated movie
     */
    public  static Movie getHighestRatedMovie(ArrayList movies){    // Bonus * already handles duplicates *
        int highest = 0;
        for (int i = 0; i < Movies.size(); i++){
            if (Movies.get(i).getStarRating() > Movies.get(highest).getStarRating()){
                highest = i;
            }
        }
        
        return Movies.get(highest) ;
    }
    
    /**
     * reads list of movies and returns the one with the highest rating
     * @param movies
     * @return the highest rated movie
     */
    public static Movie getLowestRatedMovie(ArrayList movies){      // Bonus * already handles duplicates *
        int lowest = 0;
        
        for (int i = 0; i < Movies.size(); i++){
            if (Movies.get(i).getStarRating() < Movies.get(lowest).getStarRating()){
                lowest = i;
            }
        }
        
        return Movies.get(lowest);
    }
    
    /**
     * Calculates the average movie rating
     * @param movies
     * @return the average
     */
    public static double calculateAverageRating(ArrayList movies){
        double total = 0, avg;
        int count = 0;
        
        for(int i = 0; i < Movies.size(); i++){
            total += Movies.get(i).getStarRating();
            ++count;
        }
        avg = total / count;
        return avg;
    }
    /**
     * Reads list of movie and returns new list of movies with a year after specified year
     * @param movies the list to read
     * @param year the year to specify
     * @return list of movies
     */
    public static ArrayList getMoviesAfterYear(ArrayList movies, int year){
        ArrayList<Movie> afterYear = new ArrayList();
        for (int i = 0; i < Movies.size(); i++){
            if (Movies.get(i).getYear() > year){
                afterYear.add(Movies.get(i));
            }
        }
        return afterYear;
    }
}

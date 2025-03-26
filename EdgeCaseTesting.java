/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieanalyzer;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author iamad
 */
public class EdgeCaseTesting {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       
        //File path of the text file that contains errors
        String filePath = "testFile.txt";
        
        //Read the CSV file
        ArrayList<Movie> movies = MovieDataProcessor.readCSV(filePath);
        
        //Process the data
        System.out.println("Total number of movies: " + movies.size());
        
        //Movie with highest and lowest star ratings
        Movie highestRatedMovie = MovieDataProcessor.getHighestRatedMovie(movies);
        Movie lowestRatedMovie = MovieDataProcessor.getLowestRatedMovie(movies);
        
        System.out.print("Movie with the highest star rating: " + highestRatedMovie);
        System.out.print("Movie with the lowest star rating: " + lowestRatedMovie);
        
        //Average star rating
        double averageRating = MovieDataProcessor.calculateAverageRating(movies);
        System.out.println("Average star rating: " + averageRating);
        
        //Movies released after a given year
        int givenYear = 2000; //Example year, you can change this
        ArrayList<Movie> moviesAfterYear = MovieDataProcessor.getMoviesAfterYear(movies,givenYear);
        System.out.println("Movies released after " + givenYear + ": \n" + moviesAfterYear);
        
    }
}

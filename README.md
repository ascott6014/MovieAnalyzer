  MovieAnalyzer 

**Movie Data Analysis with File and Text Processing**

### **Objective:**

The objective of this assignment is to practice file and text processing in Java by reading data from a CSV file, manipulating and processing the data, and producing useful output.

* * *

### **Description:**

Write a Java program to read a CSV file containing movie data. The CSV file will include columns for the movie title, release year, and star rating. The program should process this data and generate specific outputs as detailed below.

#### **CSV File Format:**

    The Shawshank Redemption,1994,9.3
    The Godfather,1972,9.2
    The Dark Knight,2008,9.0
    ...
    

* * *

### **Requirements:**

#### **1\. Read the CSV File**

*   Read the CSV file and store the data in an `ArrayList`

#### **2\. Data Processing**

*   Count the total number of movies in the file.
*   Find the movie with the highest star rating.
*   Find the movie with the lowest star rating.
*   Calculate the average star rating of all movies (formatted to two decimal places).
*   List all movies released after a given year (provided by the user).

#### **3\. Output the Results**

*   Display the total number of movies.
*   Display the movie with the highest and lowest star ratings.
*   Display the average star rating.
*   Display the list of movies released after the given year.

* * *

### **Instructions:**

#### **1\. Create a New Java Project and Class Files**

*   Create a new Java project. Follow the _Setup Guide PDF_ to create a new project named **MovieAnalyzer**, along with **Main.java** and **Movie.java** class files.
*   Create a class file named **MovieDataProcessor.java** to handle reading the CSV file and processing the movie data.
*   Use the _MovieAnalyzer UML image_ as a reference for class design.

#### **2\. Implement the Movie Class**

*   Define attributes: `title` (String), `year` (int), and `starRating` (double).
*   Implement a constructor to initialize the attributes.
*   Provide **getters and setters** for each attribute.
*   Override the `toString()` method to provide a string representation of the movie.

#### **3\. Implement the MovieDataProcessor Class**

*   Implement a method `readCSV(String filePath)` to read the CSV file and return a `List<Movie>`.
*   Implement a method `getHighestRatedMovie(List<Movie> movies)` to return the movie with the highest star rating.
*   Implement a method `getLowestRatedMovie(List<Movie> movies)` to return the movie with the lowest star rating.
*   Implement a method `calculateAverageRating(List<Movie> movies)` to calculate and return the **formatted** average star rating.
*   Implement a method `getMoviesAfterYear(List<Movie> movies, int year)` to return a list of movies released after the given year.

#### **4\. Implement the Main Class**

*   Implement the `main` method to read the CSV file, process the data, and output the results as specified. Use the following **driver code** to test your program.

##### **Sample Main Class Code:**

    public class Main {
        public static void main(String[] args) {
            // File path of the CSV file
            String filePath = "movieData.csv";
    
            // Read the CSV file
            List<Movie> movies = MovieDataProcessor.readCSV(filePath);
    
            // Process the data
            System.out.println("Total number of movies: " + movies.size());
    
            // Movie with highest and lowest star ratings
            Movie highestRatedMovie = MovieDataProcessor.getHighestRatedMovie(movies);
            Movie lowestRatedMovie = MovieDataProcessor.getLowestRatedMovie(movies);
    
            System.out.println("Movie with the highest star rating: " + highestRatedMovie);
            System.out.println("Movie with the lowest star rating: " + lowestRatedMovie);
    
            // Average star rating
            double averageRating = MovieDataProcessor.calculateAverageRating(movies);
            System.out.println("Average star rating: " + averageRating);
    
            // Movies released after a given year
            int givenYear = 2000; // Example year, you can change this
            List<Movie> moviesAfterYear = MovieDataProcessor.getMoviesAfterYear(movies, givenYear);
            System.out.println("Movies released after " + givenYear + ": " + moviesAfterYear);
        }
    }
    

* * *

### **Bonus Section: Handling Edge Cases**

To ensure your program is robust, handle the following edge cases:

1.  **Empty File**: If the CSV file is empty, display a message indicating no movies are available.
2.  **Malformed Data**: If a row has missing or incorrect data (e.g., missing year or rating or extreme values like negative years or out of range scores) skip the row and log a warning
3.  **Duplicate Ratings**: If multiple movies have the highest or lowest rating, return the first occurrence.
4.  **Non-Numeric Data in Numeric Fields**: Ensure proper parsing of `year` and `starRating` fields; handle cases where they contain invalid values skip the row and log a warning

* * *

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package movieanalyzer;

/**
 *
 * @author iamad
 */
public class Movie {
    private String title; 
    private int year;
    private double starRating;
    /**
     * Constructor: creates a movie object with assigned values 
     * @param title the title to set
     * @param year the year to set
     * @param starRating the starRating to set
     */
    public Movie(String title, int year, double starRating){
        this.title = title;
        this.year = year;
        this.starRating = starRating;
        
    }
    /**
     * Overrides the toString method
     * 
     * @return  String: the formatted movie to string
     */
    @Override
    public String toString(){
        return "Title: " + getTitle() + "\t" + "Year: " + getYear() + "\t" + "Star Raing: " + getStarRating() + "\n"; 
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the starRating
     */
    public double getStarRating() {
        return starRating;
    }

    /**
     * @param starRating the starRating to set
     */
    public void setStarRating(double starRating) {
        this.starRating = starRating;
    }
    
}

package exp12;

import java.io.*;
import java.util.*;

class Movie {
    private String name;
    private String director;
    private double rating;
    Movie() {
        name = "";
        director = "";
        rating = 0.0;
    }
    Movie(String name, String director, double rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }
    public double getRating() {
        return rating;
    }
    public String toString() {
        return "Movie Name: " + name +
                "\nDirector: " + director +
                "\nRating: " + rating;
    }
}
public class MovieCollection {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("exp12/movie.txt"));
        int n = Integer.parseInt(file.nextLine());
        Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            String name = file.nextLine();
            String director = file.nextLine();
            double rating = Double.parseDouble(file.nextLine());
            movies[i] = new Movie(name, director, rating);
        }
        PrintWriter out = new PrintWriter("exp12/movie_output.txt");
        out.println("Movies with Rating Above 4");
        for (Movie m : movies) {
            if (m.getRating() > 4) {
                out.println(m);
                out.println();
            }
        }
        out.close();
        file.close();
        System.out.println("Data written to movie_output.txt");
    }
}
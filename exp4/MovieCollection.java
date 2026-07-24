package exp4;
import java.util.*;

class Movie {
    private String name;
    private String director;
    private double rating;

    public Movie() {
        name = new String();
        director = new String();
        rating = 0.0;
    }

    public Movie(String name, String director, double rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    public String getName() { 
        return name;
     }
    public void setName(String name) {
         this.name = name;
         }

    public String getDirector() { 
        return director;
     }
    public void setDirector(String director) { 
        this.director = director;
     }

    public double getRating() {
         return rating;
         }
    public void setRating(double rating) {
         this.rating = rating;
         }

    public String toString() {
        return "Movie Name: " + name + "\nDirector: " + director + "\nRating: " + rating;
    }
}

public class MovieCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();
        sc.nextLine();

        Movie[] movies = new Movie[n];

        for(int i=0;i<n;i++) {
            System.out.println("\nEnter details of movie " + (i+1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Director: ");
            String director = sc.nextLine();
            System.out.print("Rating: ");
            double rating = sc.nextDouble();
            sc.nextLine();

            movies[i] = new Movie();  
            movies[i].setName(name);
            movies[i].setDirector(director);
            movies[i].setRating(rating);
        }

        System.out.println("\nMovies with rating above 4:");
        for(Movie m : movies) {
            if(m.getRating() > 4) {
                System.out.println(m);
                System.out.println();
            }
        }
    }
}
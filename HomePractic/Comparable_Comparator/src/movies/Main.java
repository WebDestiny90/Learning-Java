package movies;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Movies> movies = Arrays.asList(
            new Movies("Avatar", 7.8, 2009),
            new Movies("Inception", 8.8, 2010),
            new Movies("Shutter Island", 8.1, 2010),
            new Movies("Avengers", 8.1, 2010),
            new Movies("Interstellar", 8.6, 2014),
            new Movies("The Dark Knight", 9.0, 2008),
            new Movies("The Dark Knight Rises", 8.4, 2012),
            new Movies("Matrix", 8.6, 1999),
            new Movies("Matrix Reloaded", 7.2, 2003),
            new Movies("Matrix Revolutions", 6.8, 2003),
            new Movies("Joker", 8.4, 2019),
            new Movies("Parasite", 8.6, 2019),
            new Movies("Tenet", 7.5, 2020),
            new Movies("Dune", 8.1, 2021),
            new Movies("Spider-Man: No Way Home", 8.4, 2021),
            new Movies("Doctor Strange", 7.5, 2016),
            new Movies("Iron Man", 7.9, 2008),
            new Movies("Thor", 7.0, 2011),
            new Movies("Captain America", 7.9, 2011),
            new Movies("Guardians of the Galaxy", 8.0, 2014),
            new Movies("Black Panther", 7.3, 2018),
            new Movies("Wakanda Forever", 6.8, 2022),
            new Movies("Avengers: Endgame", 8.4, 2019),
            new Movies("Avengers: Infinity War", 8.5, 2018),
            new Movies("Harry Potter and the Philosopher's Stone", 7.6, 2001),
            new Movies("Harry Potter and the Chamber of Secrets", 7.4, 2002),
            new Movies("Harry Potter and the Prisoner of Azkaban", 7.9, 2004),
            new Movies("Harry Potter and the Goblet of Fire", 7.7, 2005)
    );

    Collections.sort(movies, new MovieComparator());

    movies.forEach(System.out::println);
  }
}

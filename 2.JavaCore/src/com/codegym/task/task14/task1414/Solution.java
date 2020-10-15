package com.codegym.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Movie movie;
        String key;
        while (true) {
            key = read.readLine();
            movie = MovieFactory.getMovie(key);
            if (movie != null) System.out.println(movie.getClass().getSimpleName());
            else break;
        }
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie;

            // Create a SoapOpera object for the key "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            } else movie = null;

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {

    }
}

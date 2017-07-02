package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Optional;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        Optional<String> urlOfLargestBoxArt = movies.stream().flatMap(f -> f.getBoxarts().stream()).reduce((a, b) -> {
            if (a.getWidth() * a.getHeight() >= b.getWidth() * b.getHeight()) {
                return a;
            } else {
                return b;
            }
        }).map(b -> b.getUrl());

        return urlOfLargestBoxArt.get();
//        return "someUrl";
    }
}

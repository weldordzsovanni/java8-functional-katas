package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        System.out.println(movieLists);
        List<Integer> result = movieLists.stream().flatMap(c -> c.getVideos().stream()).map(m -> m.getId()).collect(Collectors.toList());

        System.out.println(result);
        return result;
//        return ImmutableList.of(1, 2, 3);
    }
}

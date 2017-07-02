package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> result = movieLists.stream().flatMap(f -> f.getVideos().stream()).map(m -> {
            String url = BoxArtSelector.selectMinFunction(BoxArtSelector.selectMinOperator()).select(m).get().getUrl();
            Date middleMoment = m.getInterestingMoments().stream().filter(f -> "Middle".equals(f.getType())).findFirst().get().getTime();
            return ImmutableMap.of("id", m.getId(), "title", m.getTitle(), "time", middleMoment, "url", url);
        }).collect(Collectors.toList());

        return result;
//        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl"));
    }
}

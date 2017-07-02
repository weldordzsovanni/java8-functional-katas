package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.T;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> result = movieLists.stream().flatMap(list -> list.getVideos().stream())
                .map(m -> {
                    String url = BoxArtSelector.selectMinFunction(BoxArtSelector.selectMinOperator()).select(m).get().getUrl();
                    return ImmutableMap.of("id", m.getId(), "title", m.getTitle(), "boxart",
                            url
                            );
                        }
                ).collect(Collectors.toList());

        System.out.println(result);
        return result;
//        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", "url"));
    }


}

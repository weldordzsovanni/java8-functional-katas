package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> result = movieLists.stream().flatMap(f -> f.getVideos().stream()).map(m -> {
            Predicate<BoxArt> boxArtPredicate = b -> b.getHeight() == 200 && b.getWidth() == 150;
            BoxArt boxArtSelected = m.getBoxarts().stream().filter(boxArtPredicate).findAny().get();
            return ImmutableMap.of("id", m.getId(), "title", m.getTitle(), "boxart",
                    boxArtSelected);
        }).collect(Collectors.toList());

        System.out.println(result);
        return result;
//        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", new BoxArt(150, 200, "url")));
    }

}


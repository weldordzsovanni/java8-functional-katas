package katas;

import model.BoxArt;
import model.Movie;

import javax.swing.*;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * Created by dzsovanni on 2017.07.02..
 */
@FunctionalInterface
public interface BoxArtSelector<T extends Movie, R extends BoxArt> {

    Optional<R> select(T movie);


    static BoxArtSelector<Movie, BoxArt> selectMinFunction(BinaryOperator<BoxArt> selector) {
        return movie -> movie.getBoxarts().stream().reduce(selector);
    }

    static BinaryOperator<BoxArt> selectMinOperator() {
        BinaryOperator<BoxArt> minBoxArt = (a, b) -> {
            if (a.getWidth() * a.getHeight() <= b.getWidth() * b.getHeight()) {
                return a;
            } else {
                return b;
            }
        };
        return minBoxArt;
//        return mov.getBoxarts().stream().reduce(minBoxArt);

    }

}

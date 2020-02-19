package domain.result;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RankTest {

    @ParameterizedTest
    @MethodSource("createRank")
    void testRank(Rank rank, Rank rankExpected) {
        assertThat(rank).isEqualTo(rankExpected);
    }

    private static Stream<Arguments> createRank() {
        return Stream.of(
                Arguments.of(Rank.valueOf(1, false), Rank.MISS),
                Arguments.of(Rank.valueOf(3, false), Rank.FIFTH),
                Arguments.of(Rank.valueOf(4, false), Rank.FOURTH),
                Arguments.of(Rank.valueOf(5, false), Rank.THIRD),
                Arguments.of(Rank.valueOf(5, true), Rank.SECOND),
                Arguments.of(Rank.valueOf(6, false), Rank.FIRST)
        );
    }

    public static List<Rank> getRanksFixture() {
        List<Rank> ranks = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            ranks.add(Rank.FIRST);
        }
        return ranks;
    }
}

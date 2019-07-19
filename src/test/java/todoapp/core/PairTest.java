package todoapp.core;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PairTest {

    @Test
    void shouldContainTwoElements() {
        var pair = Pair.of("", 1);

        assertThat(pair.first).isEqualTo("");
        assertThat(pair.second).isEqualTo(1);
    }

    @Test
    void shouldContainTwoElementsOfOtherTypes() {
        var pair = Pair.of(1, "");

        assertThat(pair.first).isEqualTo(1);
        assertThat(pair.second).isEqualTo("");
    }


}

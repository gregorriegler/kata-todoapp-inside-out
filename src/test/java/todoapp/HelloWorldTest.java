package todoapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    void helloWorld() {
        Assertions.assertThat("hello").isEqualTo("hello");
    }
}

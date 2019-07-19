package todoapp.core;

public class Pair<F, S> {

    public final F first;
    public final S second;

    public static <F, S> Pair of(F first, S second) {
        return new Pair<>(first, second);
    }

    private Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
}
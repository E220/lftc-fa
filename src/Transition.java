public class Transition {
    private final State from;
    private final Key key;
    private final State to;

    public Transition(State from, Key key, State to) {
        this.from = from;
        this.key = key;
        this.to = to;
    }

    public State getFrom() {
        return from;
    }

    public Key getKey() {
        return key;
    }

    public State getTo() {
        return to;
    }
}

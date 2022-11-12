import java.util.List;
import java.util.Set;

public record FiniteAutomaton(
        Set<State> states,
        State initialState,
        Set<State> finalStates,
        Set<Key> alphabet,
        List<Transition> transitions
) {
}

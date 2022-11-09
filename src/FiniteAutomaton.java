import java.util.List;
import java.util.Set;

public record FiniteAutomaton(Set<State> states, Set<Key> alphabet, List<Transition> transitions,
                              Set<State> finalStates) {
}

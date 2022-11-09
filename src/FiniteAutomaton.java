import java.util.List;
import java.util.Set;

public class FiniteAutomaton {
    private final Set<State> states;
    private final Set<Key> alphabet;
    private final List<Transition> transitions;
    private final Set<State> finalStates;

    public FiniteAutomaton(Set<State> states, Set<Key> alphabet, List<Transition> transitions, Set<State> finalStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.finalStates = finalStates;
    }
}

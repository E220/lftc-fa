import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record FiniteAutomaton(
        Set<State> states,
        State initialState,
        Set<State> finalStates,
        Set<Key> alphabet,
        List<Transition> transitions
) {

    public Map<State, Map<Key, State>> getTransitionMap() {
        final Map<State, Map<Key, State>> transitionMap = new HashMap<>();
        transitions.forEach(transition -> {
            final State from = transition.from();
            final Map<Key, State> subMap = transitionMap.getOrDefault(from, new HashMap<>());
            subMap.put(transition.key(), transition.to());
            transitionMap.put(from, subMap);
        });
        return transitionMap;
    }
    public boolean acceptsSequence(String sequence) {
        State state = initialState;
        final Map<State, Map<Key, State>> transitionMap = getTransitionMap();
        for (final Character character : sequence.toCharArray()) {
            final Key key = new Key(character.toString());
            if (!transitionMap.containsKey(state) || !transitionMap.get(state).containsKey(key)) {
                return false;
            }
            state = transitionMap.get(state).get(key);
        }
        return finalStates.contains(state);
    }
}

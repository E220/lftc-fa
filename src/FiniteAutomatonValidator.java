import java.util.Map;

public class FiniteAutomatonValidator {
    public static boolean isValid(FiniteAutomaton fa) {
        if (!fa.states().contains(fa.initialState()) || !fa.states().containsAll(fa.finalStates())) {
            return false;
        }
        return fa.transitions().stream().allMatch(transition ->
                fa.states().contains(transition.from()) &&
                fa.alphabet().contains(transition.key()) &&
                fa.states().contains(transition.to()));
    }

    public static boolean isDeterministic(FiniteAutomaton fa) {
        if (!isValid(fa)) {
            return false;
        }
        final int transitionMapSize = fa.getTransitionMap().values().stream()
                .map(Map::size)
                .reduce(0, Integer::sum);
        return fa.transitions().size() == transitionMapSize;
    }
}

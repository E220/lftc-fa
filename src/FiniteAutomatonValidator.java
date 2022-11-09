import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FiniteAutomatonValidator {
    public static boolean isValid(FiniteAutomaton fa) {
        if (!fa.states().containsAll(fa.finalStates())) {
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
        final Set<String> sourceAndKeyPairs = fa.transitions().stream().map(
                FiniteAutomatonValidator::getSourceAndKeyPair
        ).collect(Collectors.toUnmodifiableSet());
        for (final Transition transition : fa.transitions()) {
            final String sourceAndKeyPair = getSourceAndKeyPair(transition);
            if (sourceAndKeyPairs.contains(sourceAndKeyPair)) {
                return false;
            }
            sourceAndKeyPairs.add(sourceAndKeyPair);
        }
        return true;
    }

    private static String getSourceAndKeyPair(Transition transition) {
        return transition.from().string() + "," + transition.key().string();
    }
}

public class FiniteAutomatonValidator {
    public static boolean isValid(FiniteAutomaton fa) {
        if (!fa.states().containsAll(fa.finalStates())) {
            return false;
        }
        if (!fa.transitions().stream().allMatch(transition ->
                fa.states().contains(transition.from()) &&
                fa.alphabet().contains(transition.key()) &&
                fa.states().contains(transition.to()))) {
            return false;
        }
        return true;
    }
}

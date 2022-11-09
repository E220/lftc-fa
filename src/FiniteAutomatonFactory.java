import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FiniteAutomatonFactory {
    public static FiniteAutomaton fromFile(String filename) throws FileNotFoundException {
        try(final Scanner scanner = new Scanner(new File(filename))) {
            final Set<State> states = readStates(scanner);
            final Set<State> finalStates = readStates(scanner);
            final Set<Key> alphabet = readAlphabet(scanner);
            final List<Transition> transitionList = readTransitions(scanner);
            final FiniteAutomaton fa = new FiniteAutomaton(states, alphabet, transitionList, finalStates);
            if (!FiniteAutomatonValidator.isValid(fa)) {
                return null;
            }
            return fa;
        }
    }

    private static Set<State> readStates(Scanner scanner) {
        return Stream.of(scanner.nextLine().split(","))
                .map(State::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    private static Set<Key> readAlphabet(Scanner scanner) {
        return Stream.of(scanner.nextLine().split(","))
                .map(Key::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    private static List<Transition> readTransitions(Scanner scanner) {
        final List<Transition> transitionList = new LinkedList<>();
        while (scanner.hasNextLine()) {
            final String[] line = scanner.nextLine().split("(,|->)");
            transitionList.add(new Transition(new State(line[0]), new Key(line[1]), new State(line[2])));
        }
        return transitionList;
    }
}

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;

public class Program {
    private final Menu mainMenu;
    private final Menu printMenu;

    public FiniteAutomaton fa;

    public Program() {
        mainMenu = new Menu(Arrays.asList(
                new MenuItem("read", "Read FA", this::readFA),
                new MenuItem("print", "Print FA", this::printFA),
                new MenuItem("stop", "Stop program", this::stop)
        ));
        printMenu = new Menu(Arrays.asList(
                new MenuItem("states", "Print states", this::printStates),
                new MenuItem("initial", "Print initial state", this::printInitialState),
                new MenuItem("final", "Print final states", this::printFinalStates),
                new MenuItem("alphabet", "Print alphabet", this::printAlphabet),
                new MenuItem("transitions", "Print transitions", this::printTransitions),
                new MenuItem("back", "Go back", this::goBack)
        ));
    }

    public void run() {
        mainMenu.run();
    }

    private void readFA() {
        mainMenu.printLine("Input file name");
        final String filename = mainMenu.readLine();
        try {
            this.fa = FiniteAutomatonFactory.fromFile("src/" + filename);
        } catch (FileNotFoundException e) {
            mainMenu.printLine("File not found");
        }
    }

    private void printFA() {
        if (Objects.isNull(fa)) {
            mainMenu.printLine("No FA provided");
            return;
        }
        if (!FiniteAutomatonValidator.isValid(fa)) {
            mainMenu.printLine("FA is not valid");
            return;
        }
        printMenu.run();
    }

    private void printStates() {
        printMenu.printLine(fa.states().toString());
    }

    private void printInitialState() {
        printMenu.printLine(fa.initialState().string());
    }

    private void printFinalStates() {
        printMenu.printLine(fa.finalStates().toString());
    }

    private void printAlphabet() {
        printMenu.printLine(fa.alphabet().toString());
    }

    private void printTransitions() {
        printMenu.printLine(fa.transitions().toString());
    }

    private void goBack() {
        printMenu.setRunning(false);
    }

    private void stop() {
        mainMenu.setRunning(false);
    };
}

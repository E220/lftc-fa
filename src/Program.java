import java.io.FileNotFoundException;
import java.util.Arrays;

public class Program {
    private final Menu menu;

    public FiniteAutomaton fa;

    public Program() {
        menu = new Menu(Arrays.asList(
                new MenuItem("read", "Read FA", this::readFA),
                new MenuItem("stop", "Stop program", this::stop)
        ));
    }

    public void run() {
        menu.run();
    }

    private void readFA() {
        menu.printLine("Input file name");
        final String filename = menu.readLine();
        try {
            this.fa = FiniteAutomatonFactory.fromFile("src/" + filename);
        } catch (FileNotFoundException e) {
            menu.printLine("File not found");
        }
    }

    private void stop() {
        menu.setRunning(false);
    };
}

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final FiniteAutomaton fa = FiniteAutomatonFactory.fromFile("src/FA.in");
        System.out.println(fa);
        final Program program = new Program();
        program.run();
    }
}
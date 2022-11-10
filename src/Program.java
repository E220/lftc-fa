import java.util.Arrays;

public class Program {
    private final Menu menu;

    public Program() {
        menu = new Menu(Arrays.asList(
            stop
        ));
    }

    public void run() {
        menu.run();
    }

    private final MenuItem stop = new MenuItem() {
        @Override
        public String getKey() {
            return "stop";
        }

        @Override
        public String getTitle() {
            return "Stop program";
        }

        @Override
        public void execute(Menu menu) {
            menu.setRunning(false);
        }
    };
}

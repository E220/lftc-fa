public interface MenuItem {
    String getKey();
    String getTitle();
    void execute(Menu menu);
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Computer com = new Computer("Samsung NT530", "Gen9_i7", 32);
        com.powerOn();
        com.printSpec();

        com.clickLeftAt200_400();
        com.clickRightAt600_800();
    }
}
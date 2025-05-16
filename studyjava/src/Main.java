//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Computer[] computers = new Computer[5];

        computers[0] = new Computer("mjc813", "Gen9_i7", 16, "HDD", 500, "GTX_1660");
        computers[1] = new Computer("Work", "Gen9_i9", 32, "SSD", 2000, "RTX_4080");
        computers[2] = new Computer("Gaming", "Gen9_i5", 8, "SSD", 1000, "Intel_A770");
        computers[3] = new Computer("Mini", "Gen9_i7", 4, "HDD", 1000, null);
        computers[4] = new Computer("Machine", "Gen9_i9", 32, "SSD", 1000, "GTX_1660");

        for (Computer c : computers) {
            c.powerOn();
        }

        System.out.println("\n컴퓨터 스펙");
        for (Computer c : computers) {
            c.printSpec();
        }

        for (Computer c : computers) {
            c.powerOff();
        }
    }
}
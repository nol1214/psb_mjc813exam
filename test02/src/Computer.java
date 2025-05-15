public class Computer {
    private String name;
    private String cpu;
    private int ram; // GB
    private String storageType;
    private int storageSize; // GB
    private String graphic;

    public Computer(String name, String cpu, int ram, String storageType, int storageSize, String graphic) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storageType = storageType;
        this.storageSize = storageSize;
        this.graphic = graphic;
    }

    public void powerOn() {
        System.out.println(name + " 켜졌습니다.");
    }

    public void powerOff() {
        System.out.println(name + " 꺼졌습니다.");
    }

    public void printSpec() {
        System.out.println("CPU : " + cpu);
        System.out.println("RAM : " + ram + "GB");
        System.out.println("Storage : " + storageType + " " + storageSize + "GB");
        System.out.println("Graphic : " + graphic);
        System.out.println();
    }
}

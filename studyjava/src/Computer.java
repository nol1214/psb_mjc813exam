public class Computer {
        private String name;
        private String cpu;
        private Integer ram; // GB
        private String storageType;
        private Integer storageSize; // GB
        private String graphic;
        private Mouse mouse;

        public Computer() {
            this.name = "Computer";
            this.cpu = null;
            this.ram = null;
            this.storageType = null;
            this.storageSize = null;
            this.graphic = null;
            this.mouse = new Mouse();
        }

        public Computer(String name) {
            this.name = name;
            this.cpu = null;
            this.ram = null;
            this.storageType = null;
            this.storageSize = null;
            this.graphic = null;
            this.mouse = new Mouse();
        }
        public Computer(String name, String cpu) {
            this.name = name;
            this.cpu = cpu;
            this.ram = null;
            this.storageType = null;
            this.storageSize = null;
            this.graphic = null;
            this.mouse = new Mouse();
        }
        public Computer(String name, String cpu, int ram) {
            this.name = name;
            this.cpu = cpu;
            this.ram = ram;
            this.storageType = null;
            this.storageSize = null;
            this.graphic = null;
            this.mouse = new Mouse();
        }
        public Computer(String name, String cpu, int ram, String storageType, int storageSize) {
            this.name = name;
            this.cpu = cpu;
            this.ram = ram;
            this.storageType = storageType;
            this.storageSize = storageSize;
            this.graphic = null;
            this.mouse = new Mouse();
        }
        public Computer(String name, String cpu, int ram, String storageType, int storageSize, String graphic) {
            this.name = name;
            this.cpu = cpu;
            this.ram = ram;
            this.storageType = storageType;
            this.storageSize = storageSize;
            this.graphic = graphic;
            this.mouse = new Mouse();
        }



        public void powerOn() {
            System.out.println(name + " 켜졌습니다.");
        }
        public void powerOff() {
            System.out.println(name + " 꺼졌습니다.");
        }
        public void printSpec() {
            System.out.println("이름 : " + name);
            System.out.println("CPU : " + (cpu != null ? cpu : "조립중입니다"));
            System.out.println("RAM : " + (ram != null ? ram + "GB" : "조립중입니다"));
            System.out.println("Storage : " + (storageType != null && storageSize != null ? storageType + " " + storageSize + "GB" : "조립중입니다"));
            System.out.println("Graphic : " + (graphic != null ? graphic : "조립중입니다"));
            System.out.println();
        }
        public void clickLeftAt200_400() {
            mouse.moveMouse(200, 400);
            mouse.leftClick();
        }
        public void clickRightAt600_800() {
            mouse.moveMouse(600, 800);
            mouse.rightClick();
        }
    }

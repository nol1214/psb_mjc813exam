import java.util.Comparator;
import java.util.Objects;

public class Computer implements Comparable<Computer> {
    private String name;
    private ECpu cpu;
    private ERam ram;
    private EStorage storage;
    private EGraphicCard graphicCard;
    private Integer price;
    private Integer qty;

    public Computer(String name, ECpu cpu, ERam ram, EStorage storage, EGraphicCard graphicCard,
                    Integer price, Integer qty) {
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.graphicCard = graphicCard;
        this.price = price;
        this.qty = qty;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Computer)) return false;
        Computer other = (Computer) obj;
        return cpu == other.cpu &&
                ram == other.ram &&
                storage == other.storage &&
                graphicCard == other.graphicCard;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpu, ram, storage, graphicCard);
    }

    @Override
    public String toString() {
        return String.format("컴퓨터명: %s | CPU: %s | RAM: %s | Storage: %s | GraphicCard: %s | Price: %d | Qty: %d",
                name, cpu, ram, storage, graphicCard, price, qty);
    }

    @Override
    public int compareTo(Computer o) {
        return this.cpu.ordinal() - o.cpu.ordinal();
    }

    public static Comparator<Computer> ramComparator = Comparator.comparingInt(c -> c.ram.ordinal());

    public String getName() { return name; }
    public Integer getPrice() { return price; }
    public Integer getQty() { return qty; }
    public ECpu getCpu() { return cpu; }
}




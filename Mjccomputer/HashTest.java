import java.util.*;

public class HashTest {
    public static void main(String[] args) {
        Set<Computer> set = new HashSet<>();
        Computer[] comps = {
                new Computer("컴1", ECpu.I3, ERam.GB8, EStorage.SSD_256, EGraphicCard.NONE, 500, 10),
                new Computer("컴2", ECpu.I5, ERam.GB16, EStorage.SSD_512, EGraphicCard.GTX1050, 800, 5),
                new Computer("컴3", ECpu.I7, ERam.GB32, EStorage.SSD_1000, EGraphicCard.RTX3060, 1500, 3),
                new Computer("컴4", ECpu.I5, ERam.GB16, EStorage.SSD_512, EGraphicCard.GTX1660, 850, 4),
                new Computer("컴5", ECpu.I3, ERam.GB8, EStorage.HDD_500, EGraphicCard.NONE, 450, 7)
        };

        set.addAll(Arrays.asList(comps));

        int totalInventoryValue = Arrays.stream(comps)
                .mapToInt(c -> c.getPrice() * c.getQty())
                .sum();
        System.out.println("총 금액: " + totalInventoryValue + "만원");

        ECpu minCpu = Arrays.stream(comps)
                .map(Computer::getCpu)
                .min(Comparator.comparingInt(Enum::ordinal))
                .orElse(ECpu.I3);

        int qtyOfMinCpu = Arrays.stream(comps)
                .filter(c -> c.getCpu() == minCpu)
                .mapToInt(Computer::getQty)
                .sum();
        System.out.println("가장 낮은 CPU의 재고: " + qtyOfMinCpu);

        System.out.println("HashSet 저장된 Computer 수: " + set.size());
        for (Computer comp : set) {
            System.out.println(comp);
        }
    }
}


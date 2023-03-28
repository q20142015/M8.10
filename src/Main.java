import java.util.Scanner;

public class Main {
    private static final int maxBoxInCont = 27;
    private static final int maxContInTrucks = 12;

    public static void main(String[] args) {
        System.out.println("Skolko yashikov?");
        var scaner = new Scanner(System.in);
        int boxCount = Integer.parseInt(scaner.nextLine());
        trucksAndContainers(boxCount);
    }

    public static void trucksAndContainers(int box) {

        int cont = box / maxBoxInCont + 1;
        int trucks = cont / maxContInTrucks + 1;

        System.out.println("gruzovikov nuzno:" + trucks);
        System.out.println("konteinerov nuzno:" + cont);
        System.out.println();

        for (int i = 1; i <= trucks; i++) {
            System.out.println("gruzovik:" + i);
            int ogrC = (i < trucks) ? maxContInTrucks * i : cont;
            for (int j = 1 + maxContInTrucks * (i - 1); j <= ogrC; j++) {
                System.out.println(" conteiner:" + j);
                int ogrY = (j < cont) ? maxBoxInCont * j : box;
                for (int k = 1 + maxBoxInCont * (j - 1); k <= ogrY; k++) {
                    System.out.println("  yashik:" + k);
                }
            }
        }

    }
}

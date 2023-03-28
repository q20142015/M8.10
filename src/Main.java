import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    private static final int maxBoxInCont = 27;
    private static final int maxContInTrucks = 12;

    public static void main(String[] args) {
        String str = collectBirthdays(1990, 12, 02);
        System.out.println(str);
        System.out.println("Skolko yashikov?");
        var scaner = new Scanner(System.in);
        int boxCount = Integer.parseInt(scaner.nextLine());
        long te = System.currentTimeMillis();
        trucksAndContainers(boxCount);
        long tn = System.currentTimeMillis();
        long zatrtime = tn - te;
        System.out.println(zatrtime);
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

    public static String collectBirthdays(int year, int month, int day) {
        String rString = "";
        LocalDate nowDay = LocalDate.now();
        LocalDate birthDay = LocalDate.of(year, month, day);

        int i=0;
        do {
            rString += i+"-";
            rString += birthDay.format(DateTimeFormatter.ofPattern("dd.MMMyyyy"));
            rString += "-" + birthDay.getDayOfWeek();
            birthDay = birthDay.plusYears(1);
            rString += "\n";
            i=i+1;
        } while (birthDay.isBefore(nowDay));
        return rString;
    }
}

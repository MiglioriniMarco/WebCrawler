import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String startingURL = "";

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Inserisci url iniziale: ");
            startingURL = scanner.nextLine();
        } while (Objects.equals(startingURL, ""));

        Crawler.crawl(startingURL);
    }
}
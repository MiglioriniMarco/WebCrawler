import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crawler {
    private static List<String> visitedLinks = new ArrayList<>();

    private static int startingLevel = 0;

    public static void crawl(String url) {
        crawlp(url, startingLevel);
    }

    private static void crawlp(String url, int level) {
        if (level < 3 && !visitedLinks.contains(url)) {
            System.out.println("Livello: " + (level+1) + " - Visitando: " + url);
            visitedLinks.add(url);

            try {
                Document document = Jsoup.connect(url).get();
                Elements links = document.select("a[href]");

                for (Element link : links) {
                    String nextUrl = link.absUrl("href");

                    crawlp(nextUrl, level + 1);
                }
            } catch (IOException e) {
                System.err.println("Error while connecting to " + url + ": " + e.getMessage());
            }
        }
    }
}

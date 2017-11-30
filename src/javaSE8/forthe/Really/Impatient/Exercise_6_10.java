package javaSE8.forthe.Really.Impatient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise_6_10 {
/*10. Write a program that asks the user for a URL, then reads the web page at that
    URL, and then displays all the links. Use a CompletableFuture for each stage.
    Don’t call get. To prevent your program from terminating prematurely, call
ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);*/

    public static void main(String[] args) {

        CompletableFuture.supplyAsync( Exercise_6_10::readPage )
                          .thenApply(Exercise_6_10::getLinks)
                          .handle((l, e) -> {
                            if (e != null) {
                                System.out.println(e.getMessage());
                                return new ArrayList<>();
                            } else {
                                return l;
                            }
                          })
                          .thenAccept(l -> l.stream().forEach(System.out::println));

         ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);

    }


    public static String readPage() {

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Type a URL: ");
        String urlTxt = reader.next(); // Scans the next token of the input as an string.
        reader.close();

        StringBuilder content = new StringBuilder("");
        try {
            URL url = new URL(urlTxt);
            URLConnection conn = url.openConnection();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    content.append(inputLine);
                }
            }
            return content.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    private static List<String> getLinks(String content){

        List<String> links = new ArrayList();
        String regex = "(?i)href=\"http://(.*?)\"";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        while (m.find()) {
            links.add(m.group(1));
        }

        return links;

    }

}

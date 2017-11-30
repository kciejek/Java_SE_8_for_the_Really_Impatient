package javaSE8.forthe.Really.Impatient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Exercise_8_11 {
/*11. Write a program that gets the contents of a password-protected web page.
    Call URLConnection connection = url.openConnection();. Form the string username:
    password and encode it in Base64. Then call connection.setRequestProperty(
            "Authorization", "Basic " + encoded string), followed by connection.connect() and
connection.getInputStream().*/


    public static void main(String[] args) throws IOException {

        Base64.Encoder encoder = Base64.getEncoder();
        String original = "username" + ":" + "password";
        String encoded = encoder.encodeToString(original.getBytes(StandardCharsets.UTF_8));

        URL url = new URL("https://example.com/");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("Authorization", "Basic " + encoded);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();

    }
}

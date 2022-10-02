import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        String keyWord = scanner.nextLine();
        switch(keyWord){
            case "next":
                connectAndRequest();
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Wrong command, use next or exit");
        }
    }

    private static void connectAndRequest() {
        HttpURLConnection connection ;
        try {
            connection = setConnectionParameters();
        } catch (IOException e) {
            return;
        }

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder responseContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            System.out.println(responseContent);

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            connection.disconnect();
        }

    }

    private static HttpURLConnection setConnectionParameters() throws IOException {
        URL url = new URL("https://api.kanye.rest/text");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(10000);
        return connection;
    }
}
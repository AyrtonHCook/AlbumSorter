import java.io.*;
public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/albums.txt"));
            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
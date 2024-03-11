import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        String sourcePath = "input.txt";
        String destPath = "output.txt";

        try (FileInputStream fis = new FileInputStream(sourcePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(destPath);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
        }

        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Час копіювання з буферизацією: " + timeElapsed + " мс");
    }
}

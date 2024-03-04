import java.io.*;
import java.util.zip.*;
public class Ex_8 {
    public static void main (String [] args) {
        try (ZipInputStream zin = new ZipInputStream(
                new FileInputStream("src/movies.zip"))) {
            ZipEntry entry;
            String name;
            long size;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName(); // отримаємо назву файлу
                size = entry.getSize();//отримаємо його розмір в байтах
                System.out.printf("File name:%s\t File size:%d\n",
                        name, size);
                // розпакування
                FileOutputStream fout = new FileOutputStream(
                        "src/new" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        }
        catch (Exception ex) {
            System.out.println (ex.getMessage());
        }
    }
}


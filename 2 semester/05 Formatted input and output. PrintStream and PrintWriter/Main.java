import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("movies.zip"))) {
            if (dis.readInt() != 0x504b0304) {
                throw new IOException("Invalid ZIP file format");
            }

            short versionNeededToExtract = dis.readShort();
            short generalPurposeBitFlag = dis.readShort();
            short compressionMethod = dis.readShort();
            int lastModifiedTime = dis.readInt();
            int lastModifiedDate = dis.readInt();
            int crc32 = dis.readInt();
            int compressedSize = dis.readInt();
            int uncompressedSize = dis.readInt();
            byte[] fileNameBytes = new byte[dis.readShort()];
            dis.readFully(fileNameBytes);
            String fileName = new String(fileNameBytes);

            System.out.println("Version needed to extract: " + versionNeededToExtract);
            System.out.println("File name in archive: " + fileName);
            System.out.println("Date and Time modified: " + parseDate(lastModifiedDate, lastModifiedTime));
            System.out.println("Compressed size: " + compressedSize + " bytes");
            System.out.println("Uncompressed size: " + uncompressedSize + " bytes");
        }
    }

    private static String parseDate(int date, int time) {
        int year = Integer.reverseBytes(date) & 0xFFFF;
        int month = (Integer.reverseBytes(date) >>> 16) & 0x0F;
        int day = (Integer.reverseBytes(date) >>> 20) & 0x1F;
        int hour = Integer.reverseBytes(time) & 0x1F;
        int minute = (Integer.reverseBytes(time) >>> 5) & 0x3F;
        int second = (Integer.reverseBytes(time) >>> 11) & 0x1F;
        return String.format("%02d/%02d/%04d %02d:%02d:%02d", day, month, year + 1980, hour, minute, second);
    }
}

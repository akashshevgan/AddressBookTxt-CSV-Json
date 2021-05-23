import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AddressBookFileIO {
    public static String FILE_NAME = "D:\\AddressBookTxt-CSV-Json\\src\\main\\resources\\addressBook.txt";

    public void writeDataToFile(List<PersonDetails> personDetails) {
        StringBuffer buffer = new StringBuffer();
        personDetails.forEach(details -> {
            String personDetailsString = details.toString().concat("\n");
            buffer.append(personDetailsString);
        });

        try {
            Files.write(Paths.get(FILE_NAME), buffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            Files.lines(new File(FILE_NAME).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long listCount() {
        long count = 0;
        try {
            count = Files.lines(new File(FILE_NAME).toPath())
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Count is:" +count);
        return count;
    }
}


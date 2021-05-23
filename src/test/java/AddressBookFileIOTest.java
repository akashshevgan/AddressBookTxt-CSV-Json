import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.util.Arrays;

public class AddressBookFileIOTest {
    @Test
    public void given3AddressBookDataWhenWrittenToFileShuldMatchCount() {
        PersonDetails[] arrayOfData = {
                new PersonDetails("Sagar", "Rajput", "Pune", "Maharastra", "420312", "7893447817", "sagar@gmail.com"),
                new PersonDetails("Yogesh", "Shevgan", "Aurangabad", "Maharastra", "423701", "9011871426", "yogesh11@gmail.com"),
                new PersonDetails("Dinesh", "Singh", "Hadapsar", "Maharastra", "412307", "9011653077", "dinesh@gmail.com")
        };
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        addressBookFileIO.writeDataToFile(Arrays.asList(arrayOfData));
        addressBookFileIO.readData();
        long count = addressBookFileIO.listCount();
        Assertions.assertEquals(3,count);
    }

    @Test
    public void givenThreeAddressBookDataWhenWritten_tOCSV_FileShouldGiveResult() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        PersonDetails[] arrayOfData = {
                new PersonDetails("Sagar", "Rajput", "Pune", "Maharastra", "420312", "7893447817", "sagar@gmail.com"),
                new PersonDetails("Yogesh", "Shevgan", "Aurangabad", "Maharastra", "423701", "9011871426", "yogesh11@gmail.com"),
                new PersonDetails("Dinesh", "Singh", "Hadapsar", "Maharastra", "412307", "9011653077", "dinesh@gmail.com")
        };
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        addressBookFileIO.writeDataToCSVfile(Arrays.asList(arrayOfData));
        addressBookFileIO.readCsvData();
        long count = addressBookFileIO.CsvlistCount();
        Assertions.assertEquals(4,count);
    }

    @Test
    public void givenThreeAddressBookDataWhenWritten_tOJSON_FileShouldGiveResult() throws IOException {
        PersonDetails[] arrayOfData = {
                new PersonDetails("Sagar", "Rajput", "Pune", "Maharastra", "420312", "7893447817", "sagar@gmail.com"),
                new PersonDetails("Yogesh", "Shevgan", "Aurangabad", "Maharastra", "423701", "9011871426", "yogesh11@gmail.com"),
                new PersonDetails("Dinesh", "Singh", "Hadapsar", "Maharastra", "412307", "9011653077", "dinesh@gmail.com")
        };
        AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
        addressBookFileIO.writeDataToJSONFile(Arrays.asList(arrayOfData));
        addressBookFileIO.readJsonData();
        long count = addressBookFileIO.JsonlistCount();
        Assertions.assertEquals(1,count);
    }
}

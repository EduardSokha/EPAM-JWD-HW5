package eduard.task5.file;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import by.sokhaeduard.fifthhw.task5.exception.TextProcessingException;
import by.sokhaeduard.fifthhw.task5.file.FileTextReader;
import eduard.task5.type.TextProcessingData;

public class FileTextReaderTest {
    private final FileTextReader fileTextReader = new FileTextReader();

    @Test(groups = {"fileChar", "fileRegEx", "fileString"})
    public void testRead() {
        String fileName = "resources\\SourceText.txt";
        String expectedString = TextProcessingData.SOURCE_TEXT;
        try {
            String actual = fileTextReader.read(fileName);
            assertEquals(actual, expectedString);
        } catch (TextProcessingException e) {
            fail();
        }
    }

    @DataProvider(name = "dataReadException")
    @Test
    public Object[][] dataReadException() {
        return new Object[][]{
                {null},
                {"WrongFile.txt"}
        };
    }

    @Parameters("fileName")
    @Test(expectedExceptions = TextProcessingException.class,
            dataProvider = "dataReadException",
            groups = {"fileChar", "fileRegEx", "fileString"})
    public void testReadException(String fileName)
            throws TextProcessingException {
        fileTextReader.read(fileName);
    }
}
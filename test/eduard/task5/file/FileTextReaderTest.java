package test.kharitonov.day5.file;

import by.kharitonov.day5.exception.TextProcessingException;
import by.kharitonov.day5.file.FileTextReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.kharitonov.day5.type.TextProcessingData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

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
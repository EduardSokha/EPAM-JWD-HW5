package eduard.task5.console;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.testng.annotations.Test;

import by.sokhaeduard.fifthhw.task5.console.ConsoleTextReader;
import by.sokhaeduard.fifthhw.task5.exception.TextProcessingException;
import eduard.task5.type.TextProcessingData;

public class ConsoleTextReaderTest {
    private final ConsoleTextReader consoleTextReader = new ConsoleTextReader();

    @Test(groups = {"consoleChar", "consoleRegEx", "consoleString"})
    public void testReadText() throws TextProcessingException {
        String inputString = TextProcessingData.SOURCE_TEXT;
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in =
                new ByteArrayInputStream(inputString.getBytes());
        String text = "";
        System.setIn(in);
        text = consoleTextReader.readText();
        System.setIn(sysInBackup);
        System.setIn(sysInBackup);
        assertEquals(text, inputString);
    }

    @Test(expectedExceptions = TextProcessingException.class,
            expectedExceptionsMessageRegExp = "Input stream has null pointer!")
    public void testReadTextExceptionNull() throws TextProcessingException {
        InputStream sysInBackup = System.in;
        System.setIn(null);
        try {
            consoleTextReader.readText();
        } catch (TextProcessingException e) {
            throw new TextProcessingException(e.getMessage());
        } finally {
            System.setIn(sysInBackup);
        }
        System.setIn(sysInBackup);
    }
}
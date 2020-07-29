package by.sokhaeduard.fifthhw.task5.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import by.sokhaeduard.fifthhw.task5.exception.TextProcessingException;

public class FileTextReader {
    public String read(String fileName) throws TextProcessingException {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new TextProcessingException("Error during reading file!",
                    e.getCause());
        } catch (NullPointerException e) {
            throw new TextProcessingException("Null pointer detected!",
                    e.getCause());
        }
    }
}

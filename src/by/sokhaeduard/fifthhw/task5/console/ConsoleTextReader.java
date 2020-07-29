package by.sokhaeduard.fifthhw.task5.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import by.sokhaeduard.fifthhw.task5.exception.TextProcessingException;

public class ConsoleTextReader {
    public String readText() throws TextProcessingException {
        StringBuilder sb = new StringBuilder();
        String ls = System.getProperty("line.separator");
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append(ls);
            }
            sb.replace(sb.length() - ls.length(), sb.length(), "");
            isr.close();
        } catch (IOException e) {
            throw new TextProcessingException("Error, while reading data!",
                    e.getCause());
        } catch (NullPointerException e) {
            throw new TextProcessingException("Input stream has null pointer!",
                    e.getCause());
        }
        return sb.toString();
    }
}

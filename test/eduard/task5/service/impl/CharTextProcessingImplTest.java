package test.kharitonov.day5.service.impl;

import by.kharitonov.day5.exception.TextProcessingException;
import by.kharitonov.day5.service.impl.CharTextProcessingImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.kharitonov.day5.type.TextProcessingData;

import static org.testng.Assert.assertEquals;

public class CharTextProcessingImplTest {
    private final CharTextProcessingImpl processor =
            new CharTextProcessingImpl();

    @Test(groups = {"consoleChar", "fileChar"}, priority = 1)
    public void testReplaceCharInWord() throws TextProcessingException {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.REPLACED_CHAR_IN_WORDS;
        String actualTextText = processor.replaceCharInWord(sourceText, 2, '!');
        assertEquals(actualTextText, expectedText);
    }

    @DataProvider(name = "dataReplaceCharInWordException")
    @Test
    public Object[][] dataReplaceCharInWordException() {
        return new Object[][]{
                {null, 2, '2'},
                {"bla", -2, '!'},
        };
    }

    @Parameters({"sourceText", "charNumber", "charReplacement"})
    @Test(expectedExceptions = TextProcessingException.class,
            dataProvider = "dataReplaceCharInWordException", priority = 1,
            groups = {"consoleChar", "fileChar"})
    public void testReplaceCharInWordException(String sourceText,
                                               int charNumber,
                                               char charReplacement)
            throws TextProcessingException {
        processor.replaceCharInWord(sourceText, charNumber, charReplacement);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 2)
    public void testReplaceOneWithAnother() throws TextProcessingException {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.REPLACED_ONE_TO_ANOTHER;
        String actualText = processor.replaceOneWithAnother(sourceText, "РА",
                "РО");
        assertEquals(actualText, expectedText);
    }

    @DataProvider(name = "dataReplaceOneWithAnotherException")
    @Test
    public Object[][] dataReplaceOneWithAnotherException() {
        return new Object[][]{
                {null, "2", "3"},
                {"bla", "PA", null},
                {"bla", null, "!"}
        };
    }

    @Parameters({"sourceText", "target", "replacement"})
    @Test(expectedExceptions = TextProcessingException.class,
            dataProvider = "dataReplaceOneWithAnotherException", priority = 2,
            groups = {"consoleChar", "fileChar"})
    public void testReplaceOneWithAnotherException(String sourceText,
                                                   String target,
                                                   String replacement)
            throws TextProcessingException {
        processor.replaceOneWithAnother(sourceText, target, replacement);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 3)
    public void testReplaceWordsToSubstring() throws TextProcessingException {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.REPLACED_WORD_TO_SUBSTRING;
        String actualText = processor.
                replaceWordsToSubstring(sourceText, 7, "ЗАМЕНА");
        assertEquals(actualText, expectedText);
    }

    @DataProvider(name = "dataReplaceWordsToSubstringException")
    @Test
    public Object[][] dataReplaceWordsToSubstringException() {
        return new Object[][]{
                {null, 2, "3"},
                {"bla", -1, "null"},
                {"bla", 4, null}
        };
    }

    @Parameters({"sourceText", "wordLength", "substring"})
    @Test(expectedExceptions = TextProcessingException.class,
            dataProvider = "dataReplaceWordsToSubstringException", priority = 3,
            groups = {"consoleChar", "fileChar"})
    public void testReplaceWordsToSubstringException(String sourceText,
                                                     int wordLength,
                                                     String substring)
            throws TextProcessingException {
        processor.replaceWordsToSubstring(sourceText, wordLength, substring);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 4)
    public void testDeleteAllNotSpaceOrLetter() throws TextProcessingException {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.DELETED_NOT_LETTERS;
        String actualText = processor.deleteAllNotSpaceOrLetter(sourceText);
        assertEquals(actualText, expectedText);
    }

    @Test(expectedExceptions = TextProcessingException.class,
            priority = 4, groups = {"consoleChar", "fileChar"})
    public void testDeleteAllNotSpaceOrLetterException()
            throws TextProcessingException {
        processor.deleteAllNotSpaceOrLetter(null);
    }

    @Test(groups = {"consoleChar", "fileChar"}, priority = 5)
    public void testDeleteConsonantWords() throws TextProcessingException {
        String sourceText = TextProcessingData.SOURCE_TEXT;
        String expectedText = TextProcessingData.DELETED_CONSONANT_WORDS;
        String actualText = processor.deleteConsonantWords(sourceText, 7);
        assertEquals(actualText, expectedText);
    }

    @DataProvider(name = "dataDeleteConsonantWordsException")
    @Test
    public Object[][] dataDeleteConsonantWordsException() {
        return new Object[][]{
                {null, 2},
                {"bla", -1},
        };
    }

    @Parameters({"sourceText", "wordLength"})
    @Test(expectedExceptions = TextProcessingException.class,
            dataProvider = "dataDeleteConsonantWordsException", priority = 5,
            groups = {"consoleChar", "fileChar"})
    public void testDeleteConsonantWordsException(String sourceText,
                                                  int wordLength)
            throws TextProcessingException {
        processor.deleteConsonantWords(sourceText, wordLength);
    }
}
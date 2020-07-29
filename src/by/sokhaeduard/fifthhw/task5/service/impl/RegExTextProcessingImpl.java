package by.sokhaeduard.fifthhw.task5.service.impl;

import by.sokhaeduard.fifthhw.task5.exception.TextProcessingException;
import by.sokhaeduard.fifthhw.task5.service.TextProcessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTextProcessingImpl extends TextProcessingUtils
        implements TextProcessing {
    private static final String REGEX_NOT_SPACE_LETTER;
    private static final String REGEX_ORDINAL_LETTER;
    private static final String REPLACE_GROUP;
    private static final String REGEX_WORD_DEFINITE_LENGTH;
    private static final String REGEX_CONSONANT_WORD;

    static {
        String ls = System.getProperty("line.separator");
        REGEX_NOT_SPACE_LETTER = String.format("([^\\p{L}\\s]+)(%s)*",
                ls);
        REGEX_ORDINAL_LETTER = "(\\b\\S{%d})(\\S)(\\S*\\b)";
        REPLACE_GROUP = "$1%s$3";
        REGEX_WORD_DEFINITE_LENGTH = "\\b\\p{L}{%d}\\b";
        REGEX_CONSONANT_WORD =
                "\\b[\\p{L}&&[^\\dауоыиэяюёАУОЫ�?ЭЯЮЁеaeiouAEIOU]][\\S]{%d}\\b";
    }

    @Override
    public String replaceCharInWord(String text, int charNumber,
                                    char charReplacement)
            throws TextProcessingException {
        if (text == null || charNumber <= 0) {
            throw new TextProcessingException("Wrong input data!");
        }
        String regEx = String.format(REGEX_ORDINAL_LETTER, charNumber - 1);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(String.format(REPLACE_GROUP, charReplacement));
        return text;
    }

    @Override
    public String replaceOneWithAnother(String text, String target,
                                        String replacement)
            throws TextProcessingException {
        if (text == null || target == null || replacement == null) {
            throw new TextProcessingException("Wrong input data!");
        }
        Pattern pattern = Pattern.compile(target);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(replacement);
        return text;
    }

    @Override
    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring)
            throws TextProcessingException {
        if (text == null || wordLength <= 0 || substring == null) {
            throw new TextProcessingException("Wrong input data!");
        }
        String regEx = String.format(REGEX_WORD_DEFINITE_LENGTH, wordLength);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(substring);
        return text;
    }

    @Override
    public String deleteAllNotSpaceOrLetter(String text)
            throws TextProcessingException {
        if (text == null) {
            throw new TextProcessingException("Input text has null pointer!");
        }
        Pattern pattern = Pattern.compile(REGEX_NOT_SPACE_LETTER,
                Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(SPACE);
        return text;
    }

    @Override
    public String deleteConsonantWords(String text, int wordLength)
            throws TextProcessingException {
        if (text == null || wordLength <= 0) {
            throw new TextProcessingException("Wrong input data!");
        }
        String regEx = String.format(REGEX_CONSONANT_WORD, wordLength - 1);
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(BLANK);
        return text;
    }
}

package by.sokhaeduard.fifthhw.task5.service.impl;

import by.sokhaeduard.fifthhw.task5.exception.TextProcessingException;
import by.sokhaeduard.fifthhw.task5.service.TextProcessing;

public class StringTextProcessingImpl extends TextProcessingUtils
        implements TextProcessing {
    private static final String REGEX_SPLIT_WORDS;
    private static final String REGEX_SPLIT_NOT_SPACE_LETTER;
    private static final String WORD_BOUNDARY;
    private static final String QUOTE;

    static {
        String ls = System.getProperty("line.separator");
        REGEX_SPLIT_NOT_SPACE_LETTER = String.format("[\\p{L}\\s&&[^%s]]+", ls);
        REGEX_SPLIT_WORDS = "\\s*(\\s|,|!|\\.|;|:|\\?)\\s*";
        WORD_BOUNDARY = "\\b";
        QUOTE = "\\Q%s\\E";
    }

    @Override
    public String replaceCharInWord(String text, int charNumber,
                                    char charReplacement)
            throws TextProcessingException {
        if (text == null || charNumber <= 0) {
            throw new TextProcessingException("Wrong input data!");
        }
        String[] words = text.split(REGEX_SPLIT_WORDS);
        for (String word : words) {
            if (word.length() >= charNumber) {
                StringBuilder sb = new StringBuilder(word);
                String regex = WORD_BOUNDARY + word + WORD_BOUNDARY;
                sb.setCharAt(charNumber - 1, charReplacement);
                text = text.replaceFirst(regex, sb.toString());
            }
        }
        return text;
    }

    @Override
    public String replaceOneWithAnother(String text, String target,
                                        String replacement)
            throws TextProcessingException {
        if (text == null || target == null || replacement == null) {
            throw new TextProcessingException("Wrong input data!");
        }
        return text.replace(target, replacement);
    }

    @Override
    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring)
            throws TextProcessingException {
        if (text == null || wordLength <= 0 || substring == null) {
            throw new TextProcessingException("Wrong input data!");
        }
        String[] words = text.split(REGEX_SPLIT_WORDS);
        for (String word : words) {
            if (word.length() == wordLength) {
                text = text.replaceAll(word, substring);
            }
        }
        return text;
    }

    @Override
    public String deleteAllNotSpaceOrLetter(String text)
            throws TextProcessingException {
        if (text == null) {
            throw new TextProcessingException("Input text has null pointer!");
        }
        String[] targets = text.split(REGEX_SPLIT_NOT_SPACE_LETTER);
        for (String target : targets) {
            if (target.isEmpty()) {
                continue;
            }
            target = String.format(QUOTE, target);
            text = text.replaceFirst(target, SPACE);
        }
        return text;
    }

    @Override
    public String deleteConsonantWords(String text, int wordLength)
            throws TextProcessingException {
        if (text == null || wordLength <= 0) {
            throw new TextProcessingException("Wrong input data!");
        }
        String[] words = text.split(REGEX_SPLIT_WORDS);
        for (String word : words) {
            if (word.length() == wordLength && isConsonant(word.charAt(0))) {
                text = text.replaceFirst(word, BLANK);
            }
        }
        return text;
    }
}

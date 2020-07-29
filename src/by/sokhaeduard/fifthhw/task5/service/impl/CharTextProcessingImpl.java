package by.sokhaeduard.fifthhw.task5.service.impl;

import by.sokhaeduard.fifthhw.task5.exception.TextProcessingException;
import by.sokhaeduard.fifthhw.task5.service.TextProcessing;

import java.util.Arrays;

public class CharTextProcessingImpl extends TextProcessingUtils
        implements TextProcessing {
    private static final String PUNCTUATION = "?,.!:;";
    private static final String NEWLINES = "\r\n";
    private static final char SPACE_CHAR = ' ';

    @Override
    public String replaceCharInWord(String text, int charNumber,
                                    char charReplacement)
            throws TextProcessingException {
        if (text == null || charNumber <= 0) {
            throw new TextProcessingException("Wrong input data!");
        }
        char[] data = text.toCharArray();
        for (int i = 0; i < data.length; i++) {
            int j = i;
            for (; j < data.length && !isWordBoundary(data, j); j++) ;
            if ((j - i) >= charNumber) {
                data[i + charNumber - 1] = charReplacement;
            }
            i = j;
        }
        return new String(data);
    }

    @Override
    public String replaceOneWithAnother(String text, String target,
                                        String replacement)
            throws TextProcessingException {
        if (text == null || target == null || replacement == null) {
            throw new TextProcessingException("Wrong input data!");
        }
        char[] data = text.toCharArray();
        char[] charsTarget = target.toCharArray();
        int delta = target.length() - replacement.length();
        for (int i = 0; i < data.length; i++) {
            boolean equals = true;
            for (int j = 0; j < target.length(); j++) {
                if (data[i + j] != charsTarget[j]) {
                    equals = false;
                    break;
                }
            }
            if (equals) {
                data = replace(data, i, i + target.length(),
                        replacement.toCharArray());
                i += delta;
            }
        }
        return new String(data);
    }

    @Override
    public String replaceWordsToSubstring(String text, int wordLength,
                                          String substring)
            throws TextProcessingException {
        if (text == null || wordLength <= 0 || substring == null) {
            throw new TextProcessingException("Wrong input data!");
        }
        char[] data = text.toCharArray();
        int delta;
        for (int i = 0; i < data.length; i++) {
            delta = 0;
            int j = i;
            for (; j < data.length && !isWordBoundary(data, j); j++) ;
            if ((j - i) == wordLength) {
                data = replace(data, i, j, substring.toCharArray());
                delta = substring.length() - wordLength;
            }
            i = j + delta;
        }
        return new String(data);
    }

    private boolean isWordBoundary(char[] data, int index) {
        char ch = data[index];
        char chNext = index == data.length - 1 ? SPACE_CHAR : data[index + 1];
        boolean result = false;
        if (index == data.length - 1) {
            return true;
        }
        if (ch == SPACE_CHAR || isNewLine(ch)) {
            result = true;
        }
        if ((isPunctuation(ch)) &&
                (chNext == SPACE_CHAR || isNewLine(chNext))) {
            result = true;
        }
        return result;
    }

    private boolean isPunctuation(char character) {
        boolean flag = false;
        for (int i = 0; i < PUNCTUATION.length(); i++) {
            if (character == PUNCTUATION.charAt(i)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean isNewLine(char character) {
        boolean flag = false;
        for (int i = 0; i < NEWLINES.length(); i++) {
            if (character == NEWLINES.charAt(i)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private char[] replace(char[] data, int start, int end, char[] sequence) {
        int delta = sequence.length - (end - start + 1);
        int length = data.length + delta + 1;
        char[] newData = new char[length];
        char[] head = Arrays.copyOfRange(data, 0, start);
        char[] tail = Arrays.copyOfRange(data, end, data.length);
        System.arraycopy(head, 0, newData, 0, head.length);
        System.arraycopy(sequence, 0, newData, head.length, sequence.length);
        System.arraycopy(tail, 0, newData, head.length + sequence.length,
                tail.length);
        return newData;
    }

    @Override
    public String deleteAllNotSpaceOrLetter(String text)
            throws TextProcessingException {
        if (text == null) {
            throw new TextProcessingException("Input text has null pointer!");
        }
        char[] data = text.toCharArray();
        int delta;
        for (int i = 0; i < data.length; i++) {
            int j = i;
            delta = 0;
            for (; j < data.length && !isSpaceOrLetter(data[j]); j++) ;
            if (j != i) {
                data = replace(data, i, j, SPACE.toCharArray());
                delta = i - j;
            }
            i = j + delta;
        }
        return new String(data);
    }

    private boolean isSpaceOrLetter(char character) {
        return (Character.isLetter(character) ||
                character == SPACE_CHAR);
    }

    @Override
    public String deleteConsonantWords(String text, int wordLength)
            throws TextProcessingException {
        if (text == null || wordLength <= 0) {
            throw new TextProcessingException("Wrong input data!");
        }
        char[] data = text.toCharArray();
        int delta;
        for (int i = 0; i < data.length; i++) {
            delta = 0;
            int j = i;
            for (; j < data.length && !isWordBoundary(data, j); j++) ;
            if ((j - i) == wordLength && isConsonant(data[i])) {
                data = replace(data, i, j, BLANK.toCharArray());
                delta = i - j;
            }
            i = j + delta;
        }
        return new String(data);
    }
}

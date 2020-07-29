package by.sokhaeduard.fifthhw.task5.service;

import by.sokhaeduard.fifthhw.task5.exception.TextProcessingException;

public interface TextProcessing {
    String replaceCharInWord(String text, int charNumber,
                             char charReplacement)
            throws TextProcessingException;

    String replaceOneWithAnother(String text, String target,
                                 String replacement)
            throws TextProcessingException;

    String replaceWordsToSubstring(String text, int wordLength,
                                   String substring)
            throws TextProcessingException;

    String deleteAllNotSpaceOrLetter(String text)
            throws TextProcessingException;

    String deleteConsonantWords(String text, int wordLength)
            throws TextProcessingException;
}

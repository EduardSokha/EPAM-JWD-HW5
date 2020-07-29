package test.kharitonov.day5.type;

public class TextProcessingData {
    public static final String SOURCE_TEXT;
    public static final String REPLACED_CHAR_IN_WORDS;
    public static final String REPLACED_ONE_TO_ANOTHER;
    public static final String REPLACED_WORD_TO_SUBSTRING;
    public static final String DELETED_NOT_LETTERS;
    public static final String DELETED_CONSONANT_WORDS;

    static {
        String ls = System.getProperty("line.separator");
        SOURCE_TEXT = "Однажды к пеликану неожиданно подошёл человек. " +
                "В это время котёнок сидел у птицы в клюве." + ls +
                "Once a man suddenly approached a pelican. " +
                "At this time, the kitten was sitting by " +
                "the bird in its beak." + ls +
                "РАботя25га был недо<<волен РАзмером зарпл_аты, " +
                "поэтому работал в пол322силы.";
        REPLACED_CHAR_IN_WORDS = "О!нажды к п!ликану н!ожиданно п!дошёл " +
                "ч!ловек. В э!о в!емя к!тёнок с!дел у п!ицы в к!юве." + ls +
                "O!ce a m!n s!ddenly a!proached a p!lican. " +
                "A! t!is t!me, t!e k!tten w!s s!tting b! " +
                "t!e b!rd i! i!s b!ak." + ls +
                "Р!ботя25га б!л н!до<<волен Р!змером з!рпл_аты, " +
                "п!этому р!ботал в п!л322силы.";
        REPLACED_ONE_TO_ANOTHER = "Однажды к пеликану неожиданно подошёл " +
                "человек. В это время котёнок сидел у птицы в клюве." + ls +
                "Once a man suddenly approached a pelican. " +
                "At this time, the kitten was sitting by " +
                "the bird in its beak." + ls +
                "РОботя25га был недо<<волен РОзмером зарпл_аты, " +
                "поэтому работал в пол322силы.";
        REPLACED_WORD_TO_SUBSTRING = "ЗАМЕНА к пеликану неожиданно ЗАМЕНА " +
                "ЗАМЕНА. В это время ЗАМЕНА сидел у птицы в клюве." + ls +
                "Once a man suddenly approached a ЗАМЕНА. " +
                "At this time, the kitten was ЗАМЕНА by " +
                "the bird in its beak." + ls +
                "РАботя25га был недо<<волен РАзмером зарпл_аты, " +
                "ЗАМЕНА ЗАМЕНА в пол322силы.";
        DELETED_NOT_LETTERS = "Однажды к пеликану неожиданно подошёл " +
                "человек  В это время котёнок сидел у птицы в клюве " +
                "Once a man suddenly approached a pelican  " +
                "At this time  the kitten was sitting by " +
                "the bird in its beak " +
                "РАботя га был недо волен РАзмером зарпл аты  " +
                "поэтому работал в пол силы ";
        DELETED_CONSONANT_WORDS = "Однажды к пеликану неожиданно  . " +
                "В это время  сидел у птицы в клюве." + ls +
                "Once a man suddenly approached a . " +
                "At this time, the kitten was  by " +
                "the bird in its beak." + ls +
                "РАботя25га был недо<<волен РАзмером зарпл_аты, " +
                "  в пол322силы.";
    }

    private TextProcessingData() {
    }
}

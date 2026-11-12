public class MagicWord {
    private static final int MAX_FAILS = 10;
    private static final String[] Words = {"empanadas", "microondas", "ordenador", "ventana", "bogabante", "espagueti", "cebolla", "pimiento", "cucurella", "baitybait", "illojuan"};
    private String hiddenWord;
    private boolean[] correctLetters;
    private int fails;

    public MagicWord () {
        fails = 0;
        int alea = (int)(Math.random() * Words.length);
        hiddenWord = Words[alea];
        correctLetters = new boolean[hiddenWord.length()];
        for (int i = 0; i < correctLetters.length; i++) {
            correctLetters[i] = false;
        }
    }

    public void reset() {
        fails = 0;
        int alea = (int)(Math.random() * Words.length);
        hiddenWord = Words[alea];
        correctLetters = new boolean[hiddenWord.length()];
        for (int i = 0; i < correctLetters.length; i++) {
            correctLetters[i] = false;
        }
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public boolean wins() {
        for (int i = 0; i < correctLetters.length; i++) {
            if (!correctLetters[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean looses() {
        return fails > MAX_FAILS;
    }
    public void shoot(String wordOrLetter) {
        boolean acierto = false;
        if (wordOrLetter == null || wordOrLetter.isEmpty()) {
            return;
        }
        if (wordOrLetter.length() == 1) { // It was a letter
            for (int i = 0; i < hiddenWord.length(); i++) {
                if (wordOrLetter.toUpperCase().charAt(0) == hiddenWord.toUpperCase().charAt(i)) {
                    correctLetters[i] = true;

                }
            }
            if (!acierto) {
                fails++;
            }
        } else { // It was a word
            if (hiddenWord.toUpperCase().equals(wordOrLetter.toUpperCase())) {
                for (int i = 0; i < correctLetters.length; i++) {
                    correctLetters[i] = true;
                }
            } else {
                fails = MAX_FAILS + 1;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < correctLetters.length; i++) {
            if (correctLetters[i]) {
                s += hiddenWord.charAt(i);
            } else {
                s += "-";
            }
        }
        return s;
    }
}

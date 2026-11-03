public class MagicWord {
    private static final String[] Words = {"empanadas", "microondas", "ordenador", "ventana", "bogabante", "espagueti", "cebolla", "pimiento", "cucurella", "baitybait", "IlloJuan"};
    private String hiddenWord;
    private boolean[] correctLetters;

    public MagicWord () {
        int alea = (int)(Math.random() * Words.length);
        hiddenWord = Words[alea];
        correctLetters = new boolean[hiddenWord.length()];
        for (int i = 0; i < correctLetters.length; i++) {
            correctLetters[i] = false;
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

    public boolean wins() {
        for (int i = 0; i < correctLetters.length; i++) {
            if (!correctLetters[i]) {
                return false;
            }
        }
        return true;
    }
    public  void shoot(String wordOrLetter) {
        if (wordOrLetter.length() == 1) {
            for (int i = 0; i < hiddenWord.length(); i++) {
                if (wordOrLetter.charAt(0) == hiddenWord.charAt(i)) {
                    correctLetters[i] = true;
                }
            }
        } else {
            if (hiddenWord.equals(wordOrLetter)) {
                for (int i = 0; i < correctLetters.length; i++) {
                    correctLetters[i] = true;
                }
            }
        }
    }
}

public class MagicWord {
    private static final String[] Words = {"empanadas", "microondas", "ordenador", "ventana", "bogabante", "espagueti", "cebolla", "pimiento", "cucurella", "baitybait", "IlloJuan"};
    private String hiddenWord;
    private boolean[] correctLetters;

    public MagicWord () {
        int alea = (int)(Math.random() + Words.length);
        hiddenWord = Words[alea];
        correctLetters = new boolean[hiddenWord.length()];
        for (int i = 0; i < correctLetters.length; i++) {
            correctLetters[i] = false;
        }
    }

    @Override
    public String toString() {
        String s = "";

    }
}

public class Main {
    public static void main(String[] args) {
        boolean gameOver = false;
        MagicWord magic = new MagicWord();

        while (!gameOver) {
            System.out.println(magic);
            System.out.println("Enter word or letter");
            String s = Input.readString();
            magic.shoot(s);
            if (magic.wins()) {
                System.out.println(magic);
                System.out.println("You WIN!!");
                magic.reset();
            } else {
                if (magic.looses()) {
                    System.out.println(magic);
                    System.out.println("You loose. The hidden word was: " + magic.getHiddenWord());
                    gameOver = true;
                }
            }
        }
    }
}

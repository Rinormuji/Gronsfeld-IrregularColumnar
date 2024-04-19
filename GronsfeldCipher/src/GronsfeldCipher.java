
// Definimi i klases
public class GronsfeldCipher {
    private String alphabet;
    private String key;

    //Konstruktori
    public GronsfeldCipher(String alphabet, String key) {
        this.alphabet = alphabet;
        this.key = key;
    }
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String key = "31415";
        GronsfeldCipher cipher = new GronsfeldCipher(alphabet, key);

        String plaintext = "HELLO WORLD";
        System.out.println("Original: " + plaintext);
    }
}

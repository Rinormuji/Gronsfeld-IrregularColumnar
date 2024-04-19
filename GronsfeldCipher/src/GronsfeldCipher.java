
// Definimi i klases
public class GronsfeldCipher {
    private String alphabet;
    private String key;

    //Konstruktori
    public GronsfeldCipher(String alphabet, String key) {
        this.alphabet = alphabet;
        this.key = key;
    }

    // Encryption part
    private char encryptChar(char originalChar, char keyChar) {
        if (!Character.isLetter(originalChar)) {
            return originalChar;
        }

        int alphabetIndex = alphabet.indexOf(Character.toUpperCase(originalChar));
        int keyOffset = keyChar - '0';

        int encryptedIndex = (alphabetIndex + keyOffset) % alphabet.length();
        char encryptedChar = alphabet.charAt(encryptedIndex);

        return Character.isLowerCase(originalChar) ? Character.toLowerCase(encryptedChar) : encryptedChar;
    }

    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        String repeatedKey = repeatKeyToMatchLength(plaintext);

        for (int i = 0; i < plaintext.length(); i++) {
            char originalChar = plaintext.charAt(i);
            char encryptedChar = encryptChar(originalChar, repeatedKey.charAt(i));
            ciphertext.append(encryptedChar);
        }

        return ciphertext.toString();
    }
        
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String key = "31415";
        GronsfeldCipher cipher = new GronsfeldCipher(alphabet, key);

        String plaintext = "HELLO WORLD";
        System.out.println("Original: " + plaintext);
    }
}

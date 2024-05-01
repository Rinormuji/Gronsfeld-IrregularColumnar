import java.util.Scanner;

// Definimi i klases
public class GronsfeldCipher {
    private String alphabet;
    private String key;

    //Konstruktori
    public GronsfeldCipher(String alphabet, String key) {
        this.alphabet = alphabet;
        this.key = key;
    }


    private String repeatKeyToMatchLength(String text) {
        StringBuilder repeatedKey = new StringBuilder();
        int keyIndex = 0;
        int keyLength = key.length();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                repeatedKey.append(key.charAt(keyIndex % keyLength));
                keyIndex++;
            } else {
                repeatedKey.append(' ');  // trajtimi i hapsirave
            }
        }

        return repeatedKey.toString();
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
     private char decryptChar(char encryptedChar, char keyChar) {

        if (!Character.isLetter(encryptedChar)) {

            return encryptedChar;

        }

        int alphabetIndex = alphabet.indexOf(Character.toUpperCase(encryptedChar));
        int keyOffset = keyChar - '0';
        int decryptedIndex = (alphabetIndex - keyOffset + alphabet.length()) % alphabet.length();
        char decryptedChar = alphabet.charAt(decryptedIndex);
        return Character.isLowerCase(encryptedChar) ? Character.toLowerCase(decryptedChar) : decryptedChar;

    }

    public String decrypt(String ciphertext) {

        StringBuilder decryptedText = new StringBuilder();
        String repeatedKey = repeatKeyToMatchLength(ciphertext);

        for (int i = 0; i < ciphertext.length(); i++) {

            char encryptedChar = ciphertext.charAt(i);
            char originalChar = decryptChar(encryptedChar, repeatedKey.charAt(i));
            decryptedText.append(originalChar);
        }

        return decryptedText.toString();

    }
        
    public static void main(String[] args) {
        // Scanneri
        Scanner scanner = new Scanner(System.in);
        // Alphabet Key
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "3156";

        GronsfeldCipher gronsfeldCipher = new GronsfeldCipher(alphabet, key);

        System.out.print("Ju lutem jepni tekstin për të enkriptuar: ");
        String plaintext = scanner.nextLine();
        String encryptedText = gronsfeldCipher.encrypt(plaintext);
        System.out.println("Teksti i enkriptuar: " + encryptedText);

        String decrypted = gronsfeldCipher.decrypt(encryptedText);
        System.out.println("Teksti i dekriptuar: " + decrypted);

       scanner.close();
    }
}

import java.util.*;
public class Irregular {
    static final String key = "HACK";  // celesi
    static Map<Character, Integer> keyMap = new TreeMap<>();



    // Metoda per te caktu vendin e permutacionit
    static void setPermutationOrder() {
        keyMap.clear();

        for (int i = 0; i < key.length(); i++) {
            keyMap.put(key.charAt(i), i);
        }
    }

    // Metoda per enkriptim
    static String encryptMessage(String msg) {
        int col = key.length();
        int row = (int) Math.ceil((double) msg.length() / col);
        char[][] matrix = new char[row][col];
        int msgIndex = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (msgIndex < msg.length()) {
                    matrix[i][j] = msg.charAt(msgIndex++);
                } else {
                    matrix[i][j] = ' ';  // mbushja me karakterin null ndryshimi me Columnar
                }
            }
        }

        StringBuilder cipherText = new StringBuilder();
        for (int idx : keyMap.values()) {
            for (int i = 0; i < row; i++) {
                cipherText.append(matrix[i][idx]);
            }
        }

        return cipherText.toString();
    }
    //dekriptimi
    static String decryptMessage(String cipher) {
        int col = key.length();
        int row = (int) Math.ceil((double) cipher.length() / col);
        char[][] matrix = new char[row][col];
        int charIndex = 0;

        for (int idx : keyMap.values()) {
            for (int i = 0; i < row; i++) {
                matrix[i][idx] = cipher.charAt(charIndex++);
            }
        }
        // rikrijo mesazhin rresht pas rreshtit
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)  {
                    plainText.append(matrix[i][j]);
            }
        }

        return plainText.toString();
    }

    // Metoda main
    public static void main(String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ju lutem jepni tekstin për të enkriptuar: ");
        String msg = scanner.nextLine();

        setPermutationOrder();

        String cipher = encryptMessage(msg);
        System.out.println("Teksti i enkriptuar: " + cipher);

        String decryptedMsg = decryptMessage(cipher);
        System.out.println("Decrypted Message: " + decryptedMsg);

        scanner.close();
    }
}
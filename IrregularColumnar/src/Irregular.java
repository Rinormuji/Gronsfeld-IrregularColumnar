import java.util.*;
public class Irregular {
    static final String key = "HACKER";  // celesi
    static Map<Character, Integer> keyMap = new TreeMap<>();
    static List<Integer> sortedKeyIndex = new ArrayList<>();


    // Metoda per te caktu vendin e permutacionit
    static void setPermutationOrder() {
        keyMap.clear();
        sortedKeyIndex.clear();

        for (int i = 0; i < key.length(); i++) {
            keyMap.put(key.charAt(i), i);
        }

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(keyMap.entrySet());
        sortedEntries.sort(Map.Entry.comparingByKey());

        for (Map.Entry<Character, Integer> entry : sortedEntries) {
            sortedKeyIndex.add(entry.getValue());
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
                    matrix[i][j] = '\0';  // mbushja me karakterin null ndryshimi me Columnar
                }
            }
        }

        StringBuilder cipherText = new StringBuilder();
        for (int idx : sortedKeyIndex) {
            for (int i = 0; i < row; i++) {
                if (matrix[i][idx] != '\0') {
                    cipherText.append(matrix[i][idx]);
                }
            }
        }

        return cipherText.toString();
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

        scanner.close();
    }
}


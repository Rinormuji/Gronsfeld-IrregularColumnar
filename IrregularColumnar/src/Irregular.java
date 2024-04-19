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

    // Metoda main
    public static void main(String[] args) {
        // Scanneri
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qa po doni me enkriptu: ");
        String msg = scanner.nextLine();

        setPermutationOrder();

        scanner.close();
    }
}


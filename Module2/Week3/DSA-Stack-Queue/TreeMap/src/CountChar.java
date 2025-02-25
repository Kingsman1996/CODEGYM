import java.util.TreeMap;

public class CountChar {
    public static void main(String[] args) {
        String input = "CodeGymVNHaNoiDaNangHoChiMinh";
        String[] words = input.split("");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].toUpperCase();
        }
        TreeMap<String, Integer> wordsTreeMap = new TreeMap<>();
        for (String eachWord : words) {
            String key = eachWord;
            if (wordsTreeMap.containsKey(key)) {
                wordsTreeMap.put(key, wordsTreeMap.get(key) + 1);
            } else {
                wordsTreeMap.put(key, 1);
            }
        }
        wordsTreeMap.forEach((key, value) -> {
            System.out.println("Char: " + key + " : " + value);
        });
    }
}

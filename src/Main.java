import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите текст:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toLowerCase();
        String[] words = text.split("\\W+");


        long wordCount = words.length;
        System.out.printf("В тексте %d слов%n", wordCount);


        Map<String, Long> wordFrequencies = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        List<Map.Entry<String, Long>> topWords = wordFrequencies.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("TOP10:");
        topWords.forEach(e -> System.out.printf("%d — %s%n", e.getValue(), e.getKey()));
    }
}
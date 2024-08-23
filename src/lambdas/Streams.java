package lambdas;

import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        for (Integer num: numbers) {
            System.out.println(num * num);
        }

        numbers.stream().forEach(x -> System.out.println(x * x));

        // Print even numbers.

        numbers.stream().forEach(x -> {
            if (x % 2 == 0) {
                System.out.println(x);
            }
        });

        // For a list of strings, filter out the strings which do not start with the
        // letter T and then uppercase the remaining strings.

        List<String> names = List.of("Tantia Tope", "Rani Lakshmibai", "Mangal Pandey", "Nana Sahib");
        List<String> filtered = names.stream()
                .filter(x -> x.charAt(0) == 'T')
                .map(x -> x.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(filtered);

    }
}
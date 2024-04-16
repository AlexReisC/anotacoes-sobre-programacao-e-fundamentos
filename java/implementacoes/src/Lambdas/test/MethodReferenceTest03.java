package Lambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferenceTest03 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("Fubanga", "Tonhão", "Silva"));
        strings.sort(String::compareTo);
        System.out.println(strings);

        Function<String, Integer> numStringToInteger = Integer::parseInt;
        Integer num = numStringToInteger.apply("15");
        System.out.println(num);

        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(strings, "Tonhão"));
    }
}

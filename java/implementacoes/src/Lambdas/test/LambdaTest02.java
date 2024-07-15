package Lambdas.test;

import java.util.List;
import java.util.function.Function;
import java.util.ArrayList;

public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> strings = List.of("Otorrinolaringologista", "Fiofó");
        List<Integer> integers = map(strings, (String s) -> s.length());
        System.out.println(integers);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> result = new ArrayList<>();
        for (T e : list) {
            R r = function.apply(e);
            result.add(r);
        }
        return result;
    }
}

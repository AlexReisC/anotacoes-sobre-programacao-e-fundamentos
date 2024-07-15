package Optional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> op1 = Optional.of("Ai tem iphone é riquinha");
        Optional<String> op2 = Optional.ofNullable(null);
        Optional<String> op3 = Optional.empty();
        
        System.out.println(op1);
        System.out.println(op2);
        System.out.println(op3);
        System.out.println("--------------");
        
        Optional<String> nameOptional = findName("William");
        String empty = nameOptional.orElse("EMPTY");
        System.out.println(empty);
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));
        
    }

    private static Optional<String> findName(String name){
        List<String> list = List.of("William", "Sheakspere");
        int i = list.indexOf(name);
        if(i != 1){
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }
}

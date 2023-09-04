package lambdaHW;

import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Lambda {
    public static void main(String[] someArgs){
    /*
    1. Написать лямбда-выражение, которое выполняет операцию (сложение, вычитание, умножение, деление)
    над двумя числами в зависимости от заданного оператора.
    2.Написать лямбда-выражение, которое принимает строку и возвращает её в верхнем регистре, если она
    короче 5 символов, и в нижнем регистре, если она длиннее или равна 5 символам
    3.Написать лямбда-выражение, которое из массива строк ["Один","два","три","четыре","Пять","шесть"]
    и тд возвращает массив цифр.
     */
        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        BinaryOperator<Integer> sum = (x, y) -> x + y;
        BinaryOperator<Integer> substract = (x, y) -> y - x;
        BinaryOperator<Double> division = (x, y) -> y / x;
        System.out.println("сложение: " + sum.apply(23, 324));
        System.out.println("вычитание: " + substract.apply(34, 68));
        System.out.println("умножение: " + multiply.apply(3, 5));
        System.out.println("деление: " + division.apply(34.46, 353.4));

        Function<String, String> transformStr = s -> s.length() < 5 ? s.toUpperCase() : s.toUpperCase();
        String str = transformStr.apply("лямбда");
        System.out.println(str);

        String[] strings = {"Один","два","три","четыре","Пять","шесть"};
        int[] integers = Arrays.stream(strings).flatMapToInt(s -> {
           switch (s.toLowerCase()){
               case "один":
                   return IntStream.of(1);
               case "два":
                   return IntStream.of(2);
               case "три":
                   return IntStream.of(3);
               case "четыре":
                   return IntStream.of(4);
               case "пять":
                   return IntStream.of(5);
               case "шесть":
                   return IntStream.of(6);
               default:
                   return IntStream.of(0);
           }
        }).toArray();
        for (int i : integers){
            System.out.println(i);
        }
    }
}

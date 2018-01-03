package com.ballistic.intface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nabeel on 12/27/2017.
 */
public class Main {

    // (boolean-valued function) of one argument
    public static void checkList(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer i: list) {
            if(predicate.test(i)){
               System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Stream.of(1, 1, 2, 3, 3, 4, 5, 6, 6).distinct().forEach(integer -> {
            System.out.print(integer + " ");
        });

        System.out.println("\n"+Count.cashPayment(2).pay(1111));

        checkList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), i -> i > 5);

        StreemTest.printList(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        StreemTest.printList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    }

    // it’s neither a data structure nor a collection object where we can store items
    // this is like pipe
    public static class StreemTest {

        // intermediate operations return another Stream which allows us to call next operation in a sequence
        public static void printList(List<Object> list) {

            System.out.println(list.stream().map(s -> {
                System.out.print("map: ["+ s + "]" + " ");
                return s;
            }).collect(Collectors.toList()));

            System.out.println("\n" + Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).
                    // Predicate get value and process and return true/false
                    filter(i -> (i % 2) == 0).
                    map(i -> "[" + i + "]").collect(Collectors.toList()));

            System.out.println(
                    Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(o -> {
                        System.out.print("filter: ["+ o + "]" + " => ");
                        return o <= 5;
                    }).map(o -> {
                        System.out.print("map: ["+ o + "]" + " \n");
                        return "Result: [" + o + "]";
                    }).limit(5).collect(Collectors.toList()));
        }
    }
}

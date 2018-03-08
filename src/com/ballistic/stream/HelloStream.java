package com.admaxim.mvc.stream;


import rx.Observable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class HelloStream {

    public static void main(String args[]) {

        List<String> number = new ArrayList<>();
        number.add("Ballistic");
        number.add("Admaxim");
        number.add("Barco");
        // take mean only two item exe
        Observable.from(number).take(2).subscribe((arg) -> { System.out.println(arg); });

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        list.stream().forEach(System.out::println);
        list.parallelStream().forEach(System.out::println);


        FilteringApples filteringApples = new FilteringApples();
        filteringApples.run();

    }


    public static class FilteringApples {

        private static List<Predicate<Apple>> predicateList = new ArrayList<>();


        static {
            predicateList.add(FilteringApples::isGreenApple);
            predicateList.add(FilteringApples::isHeavyApple);
        }


        public static void run () {

            List<Apple> inventory = Arrays.asList(
                    new Apple(80,"green"),
                    new Apple(155, "green"),
                    new Apple(120, "red"));

            // reference method
            System.out.println(filterApples(inventory, FilteringApples::isGreenApple));
            System.out.println(filterApples(inventory, FilteringApples::isHeavyApple));

            for (Predicate<Apple> apple: predicateList) {  System.out.println(filterApples(inventory, apple)); }

            // lamda method
            System.out.println(filterApples(inventory, (Apple a) -> "green".equals(a.getColor())));
            System.out.println(filter(inventory, new AppleColorPredicate("green")));
            System.out.println(filter(inventory, new AppleWeightPredicate(155)));
            System.out.println(filter(inventory, new AppleRedAndHeavyPredicate(new Apple(150, "red"))));
            // [Apple{color='red', weight=120}]
            List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
                public boolean test(Apple a){
                    return a.getColor().equals("red");
                }
            });
        }


        public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
            List<Apple> result = new ArrayList<>();
            for(Apple apple : inventory){
                if(p.test(apple)){
                    result.add(apple);
                }
            }

            return result;
        }


        public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> applePredicate) {

            List<Apple> result = new ArrayList<>();

            for (Apple app : inventory) {
                if(applePredicate.test(app)) {
                    result.add(app);
                }
            }

            return result;
        }


        public static List<Apple> filterGreenApples(List<Apple> inventory) {

            List<Apple> result = new ArrayList<>();

            for (Apple apple : inventory) {
                if("green".equals(apple.getColor())) {
                    result.add(apple);
                }
            }

            return result;
        }

        public static List<Apple> filterHeavyApples(List<Apple> inventory) {
            List<Apple> result = new ArrayList<>();

            for (Apple apple : inventory) {
                if(apple.getWeight() > 150) {
                    result.add(apple);
                }
            }

            return result;
        }


        public static boolean isGreenApple(Apple apple) { return "green".equals(apple.getColor()); }

        public static boolean isHeavyApple(Apple apple) { return apple.getWeight() > 150; }


        public static class Apple {

            private Integer weight = 0;
            private String color = "";

            public Apple(Integer weight, String color) {
                this.weight = weight;
                this.color = color;
            }

            public Integer getWeight() { return weight; }
            public void setWeight(Integer weight) { this.weight = weight; }

            public String getColor() { return color; }
            public void setColor(String color) { this.color = color; }

            @Override
            public String toString() {
                return "Apple{" + "weight=" + weight + ", color='" + color + '\'' + '}';
            }
        }



        // Behavior parameterization
        private interface ApplePredicate { public boolean test(Apple apple); }

        private static class AppleWeightPredicate implements ApplePredicate {

            private Integer findWeight = 0;

            public AppleWeightPredicate(Integer findWeight) {
                this.findWeight = findWeight;
            }

            @Override
            public boolean test(Apple apple) { return apple.getWeight() > getFindWeight(); }

            public Integer getFindWeight() { return findWeight; }
            public void setFindWeight(Integer findWeight) { this.findWeight = findWeight; }


        }


        private static class AppleColorPredicate implements ApplePredicate {

            private String findAppleColor = "";

            public AppleColorPredicate(String findAppleColor) {
                this.findAppleColor = findAppleColor;
            }

            @Override
            public boolean test(Apple apple) { return getFindAppleColor().equals(apple.getColor()); }

            public String getFindAppleColor() { return findAppleColor; }
            public void setFindAppleColor(String findAppleColor) { this.findAppleColor = findAppleColor; }

        }

        private static class AppleRedAndHeavyPredicate implements ApplePredicate {

            private Apple findApple = null;

            public AppleRedAndHeavyPredicate(Apple findApple) {
                this.findApple = findApple;
            }

            @Override
            public boolean test(Apple apple) {
                return findApple.getColor().equals(apple.getColor()) && apple.getWeight() > findApple.getWeight();
            }


            public Apple getFindApple() { return findApple; }
            public void setFindApple(Apple findApple) { this.findApple = findApple; }

        }
    }

}

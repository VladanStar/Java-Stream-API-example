package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> lista =  Arrays.asList("a1","a2","a3","b1","b2","b3","c1","c2","c3");
        lista
                .stream()
                .filter(s->s.startsWith("b"))
                .map(String::toUpperCase)
                .sorted()
                 .forEach(System.out::println);

        List<String> students = new ArrayList<>();
        students.add("Vladan Cupric");
        students.add("Aleksandar Kesic");
        students.add("Stefan Kostov");
        students.add("Igor Protic");
        students.add("Ivan Josevski");
        students.add("Adnan Corovic");
        students.add("Branko Riznic");
        students.add("Aleksa Kancelickic");
        students.add("Stevan Stasic");
        students.add("Boris Krstic");
        students.add("Leonardo Campana");
        students.add("Nemanja Petrika");
        students.add("Petar Stasic");
        students.add("Vladan Kostov");
        students.add("Slobodan Milickovic");
        students.add("Milan Radanovic");

        // intermediate operacije uvek vracaju string
        System.out.println("Filteri");
        students.stream().filter(s->s.startsWith("A")).forEach(System.out::println);

        //maping sve u veliko slovo
        System.out.println(" Mapping UperCasse");
        students.stream().filter(s->s.startsWith("S")).map(s -> s.toUpperCase()).forEach(System.out::println);

        // sortiranje
        System.out.println("Sortiranje liste");
        students.stream().sorted().map(s -> s.toUpperCase()).forEach(System.out::println);

        // terminalne operacije sluze da vrate neki oblik rezultata
        System.out.println("FOR EACH");
        students.stream().forEach(s -> System.out.println(s));

         // colect sluzi da se pokupe razultati iz stream i da se vrati kao kolekcija
        System.out.println("Collect");

       List<String>sortedStudents =  students.stream().sorted().map(s -> s.toLowerCase()).collect(Collectors.toList());
        System.out.println(sortedStudents);
        // match
        System.out.println("Match");
        boolean matchResult = students.stream().anyMatch(s -> s.startsWith("M"));
        System.out.println(matchResult);
        System.out.println("Duzina veca od 9");
        matchResult = students.stream().allMatch(s -> s.length()>15);
        System.out.println(matchResult);
        matchResult = students.stream().noneMatch(s -> s.length()<20);
        System.out.println(matchResult);

        System.out.println("Count");
       long total= students.stream().filter(s -> s.length()>15).count();
        System.out.println(total);

        // reuse
        System.out.println("Reduce");
        Optional<String> reduced = students.stream().reduce((s1, s2)->s1 +" "+  s2);
        reduced.ifPresent(s -> System.out.println(s));
        System.out.println(reduced);

        // find first koji ispunjava neki uslov
        System.out.println("Find first");
        String firstMatch = students.stream().filter(s -> s.startsWith("M")).findFirst().get();
        System.out.println(firstMatch);




    }
}

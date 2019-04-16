import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Voog1 {
    public static double hinne(String s){
        return Double.parseDouble(s.split(",")[1]);
    }
    public static void main(String[] args) throws Exception {
        //Sorteerimine keskmise hinde järgi ja tulemus kirjutamine faili
        PrintWriter pw =
                new PrintWriter(new FileWriter(
                        "vastus1.txt"));
        Files.readAllLines(Paths.get("test.txt")).stream().sorted(Comparator.comparingDouble(Voog1::hinne)).collect(Collectors.toList()).forEach(pw::println);
        pw.close();
        //suurim
        System.out.println(Files.readAllLines(Paths.get("test.txt")).stream().mapToDouble(s-> Double.parseDouble(s.split(",")[1])).max().getAsDouble());
        //keskmine hinne üle 4
        Files.readAllLines(Paths.get("test.txt")).stream().
                filter(s -> Double.parseDouble(s.split(",")[1])>4).forEach(System.out::println);
    }
}

/*
5.0
Toomas,4.2
Peeter,5.0
Kaali,4.75
*/
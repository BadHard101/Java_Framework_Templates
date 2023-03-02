package PR2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    List<Human> people;

    public List<Human> getPeople() {
        return people;
    }

    public App() {
        people = new ArrayList<>();
        people.add(new Human(
                "Ivan",
                "Ivanov",
                LocalDate.of(2003, Month.MARCH, 29),
                81)
        );
        people.add(new Human(
                "Petr",
                "Petrov",
                LocalDate.of(2000, Month.NOVEMBER, 14),
                75)
        );
        people.add(new Human(
                "Alex",
                "Petrov",
                LocalDate.of(1999, Month.APRIL, 3),
                79)
        );

        people.add(new Human(
                "Dmitry",
                "Ivanov",
                LocalDate.of(2004, Month.AUGUST, 17),
                72)
        );
    }

//    14)   Сортировка по сумме веса и возраста, фильтрация по весу кратно 5,
//          выбор первых четырёх элементов, конкатенация имён через пробел.
    public static void main(String[] args) {
        App app = new App();

        System.out.println("BEFORE-----------------------------------------------");
        Stream<Human> stream0 = app.getPeople().stream();
        stream0.forEach(System.out::println);

        System.out.println("SORTING----------------------------------------------");
        Stream<Human> stream1 = app.getPeople().stream();
        stream1.sorted(Comparator.comparingInt(
                o -> o.getFirstName().charAt(o.getFirstName().length()-1)
        )).forEach(System.out::println);

        System.out.println("FILTERING-------------------------  -------------------");
        Stream<Human> stream2 = app.getPeople().stream();
        stream2.filter(o -> o.getAge() > 20).forEach(System.out::println);

        System.out.println("INCREASE AGE BY 3----------------------------------------------");
        Stream<Human> stream3 = app.getPeople().stream();
        stream3.map(human -> human.setAge(3)).forEach(System.out::println);

        System.out.println("AVERAGE AGE----------------------------------------");
        Stream<Human> stream4 = app.getPeople().stream();

        System.out.println(stream4.mapToInt(Human::getAge).sum() / app.getPeople().size());

        System.out.println("ALL TOGETHER-----------------------------------------");
        Stream<Human> humanStream = app.getPeople().stream();
        System.out.println(humanStream
                .sorted(Comparator.comparingInt(o -> o.getAge() + o.getWeight()))
                .filter(o -> o.getWeight() % 5 == 0)
                .limit(4)
                .map(Human::getFirstName)
                .collect(Collectors.joining(" ")));
    }
}

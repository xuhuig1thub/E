package test.juc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-13 19:52
 */
public class TTest {



    public static void main(String[] args) throws InterruptedException {
        //使用lambda表达式
        Stream.of("A", "BB", "CCC", "DDDD", "FFFFF")
                .map(s -> s.length()) //lambda
                .forEach((x) -> {
                    System.out.println(x);
                });

        //使用静态方法引用
        Stream.of("A", "BB", "CCC", "DDDD", "FFFFF")
                .map(String::length) //静态方法引用
                .forEach((x) -> {
                    System.out.println(x);
                });

        //使用实例方法引用
        Stream.of(
                new ClassMate("1", "欧阳思海"),
                new ClassMate("2", "sihai")
        ).map(ClassMate::getName)//实例方法引用
                .forEach(x -> {
                    System.out.println(x);
                });



        //使用lambda表达式
        Stream.of("A", "BB", "CCC", "DDDD", "FFFFF")
                .map(s -> new ClassMate(s)) //lambda
                .collect(Collectors.toList());

        //使用构造函数引用
        Stream.of("A", "BB", "CCC", "DDDD", "FFFFF")
                .map(ClassMate::new) //构造函数引用,由上下文决定用哪一个构造函数
                .collect(Collectors.toList());

        String[] a={"1","2","3","4","5"};
            Integer[] b={9,1,2,3,4,5,6};
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(b));
        System.out.println(list);
        System.out.println("===============");
//        Stream<String> stream = list.stream(); //获取一个顺序流
//        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        Stream<Integer> stream=list.stream().map(e->e+10).sorted();
//        stream.map(e->e+10);

        stream.forEach(e-> System.out.print(e+","));

        System.out.println(list);

        System.out.println("===============");
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::println); // 0 2 4 6 8 10

        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::println);

//        Stream<String> parallelStream = list.parallelStream();
        testPeek();
        System.out.println("\n=============");
        testTask();
        testIntegerPool();
    }

    private static void testPeek() {
        ClassMate s1 = new ClassMate("aa", "10");
        ClassMate s2 = new ClassMate("bb", "20");
        List<ClassMate> studentList = Arrays.asList(s1, s2);
        studentList.stream()
                .peek(o -> o.setS(o.getS()+"SS"))
                .forEach(System.out::println);
        studentList.stream().map(e-> new ClassMate(e.getS()+"MM","33")).forEach(System.out::print);
        System.out.println();
        studentList.forEach(System.out::print);
//结果：

    }
    private static void testTask(){
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );
        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter( task -> task.getStatus() == Status.OPEN )
                .mapToInt( Task::getPoints )
                .sum();

        System.out.println( "Total points: " + totalPointsOfOpenTasks );
        System.out.println("tasks="+tasks);
    }

    private enum Status {
        OPEN, CLOSED
    };

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }

    private static void testIntegerPool(){
        Integer a=128;
        Integer b=128;
        Integer c=127;
        Integer d=127;
        System.out.println("a==b"+(a==b));
        System.out.println("c==d"+(c==d));
    }
}

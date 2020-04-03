import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * 测试stream
 * @author XieRW
 * @email 1429382875@qq.com
 */
public class StreamTest {

    private List<String> stringList = new ArrayList<>();

    private int max = 1000000;
    private List<String> values = new ArrayList<>(max);

    public List<String> setValues() {
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            this.values.add(uuid.toString());
        }
        return this.values;
    }
    public List<String> list() {
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");
        return stringList;
    }

    public static void main(String[] args) {
        //创建streamTest对象
        StreamTest streamTest = new StreamTest();
        //给list赋值
        List<String> list = streamTest.list();
        System.out.println(list.parallelStream());
        //测试filter过滤和foreach
        list
                .stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);

        System.out.println("filter==========分界线==========sort");

        //测试sort排序,sort函数不带参数默认排序也是从小到大
        list.
                stream().
                sorted((s1, s2) -> s1.compareTo(s2)).
                filter(s -> s.startsWith("a")).
                forEach(System.out::println);
        //sort不会改变list原本的顺序，filter也是
        System.out.println(list);

        System.out.println("sort==========分界线==========map");

        //测试map，将元素根据指定的Function接口来依次转换成另外的对象
        list.
                stream().
                map(String::toUpperCase).
                sorted((a, b) -> b.compareTo(a)).
                forEach(System.out::println);

        System.out.println("map==========分界线==========Match");

        //Match匹配
        boolean anyStartWithA = list.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartWithA);

        boolean allStartWithA = list.stream().allMatch(s -> s.startsWith("a"));
        System.out.println(allStartWithA);

        boolean noneStartWithZ = list.stream().noneMatch(s -> s.startsWith("z"));
        System.out.println(noneStartWithZ);

        System.out.println("Match==========分界线==========count");

        //count计数
        long startWithB = list.stream().filter(s -> s.startsWith("b")).count();
        System.out.println(startWithB);

        //Reduce规约，允许通过指定的函数来将stream中的多个元素规约为一个元素，规约后的结果是通过Optional 接口表示的
        Optional<String> reduce = list.stream().sorted().reduce((a, b) -> a + "#" + b);
        System.out.println(reduce);

        System.out.println("count==========分界线==========Stream");

        //Stream接口
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);

        System.out.println("Stream==========分界线==========Sequential Sort(串行排序)");

        //Sequential Sort(串行排序)
        long t0 = System.nanoTime();
        long count = streamTest.setValues().stream().sorted().count();
        System.out.println(count);
        long t1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(t1-t0);
        System.out.println(String.format("串行排序所用的时间--sequential sort took: %d ms",millis));

        //Parallel Sort(并行排序)
        streamTest.values.clear();
        long t2 = System.nanoTime();
        long count2 = streamTest.setValues().parallelStream().sorted().count();
        System.out.println(count2);
        long t3 = System.nanoTime();
        long millis2 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
        System.out.println(String.format("并行排序所用的时间--parallel sort took: %d ms", millis2));

        System.out.println("Sequential Sort(串行排序)==========分界线==========Maps");

        // Maps
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));
    }
}

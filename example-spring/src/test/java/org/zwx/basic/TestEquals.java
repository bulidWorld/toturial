package org.zwx.basic;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import static java.util.stream.Collectors.*;

public class TestEquals {

    @Test
    public void testList() {
        List<Coder> li = new ArrayList<Coder>();
        li.remove(new Coder());

//        li.stream().filter().collect(toList());
//        li.stream().sorted().collect(toList());
//        li.stream().map


        Collections.synchronizedList(li);

        Set set = Collections.emptySet();
        set.add(new Object());


    }

    public void testSet() {
        TreeSet<Coder> treeSet = new TreeSet<>((c1, c2) -> c2.age - c1.age);
    }


    public void testMap() {
        Map<String, Object> map = new HashMap<>();

        map.forEach((key, value) -> System.out.println(value));
    }

    public void testSyncColl() {
        LinkedHashMap map = new LinkedHashMap();

        Collections.synchronizedMap(map);

        TreeMap mp = new TreeMap();
    }

    @Test
    public void testLoop() {
        List<Integer> li = new ArrayList<>();
        li.add(2);
        li.add(20);
        li.add(12);
        li.add(1);

        List<Integer> li2 = Collections.synchronizedList(li);
        System.out.println(li2.size());

        li2.add(12);

        System.out.println(li.size());


    }

    long startTime;
    @Before
    public void before() {
        startTime = System.currentTimeMillis();
    }

    @Test
    public void testBox() {
        List<Integer> li = new ArrayList<>();
        int i = 2000;
        for (int m =1; m <20000; m++){
            Integer boxI = i;
            int count = i + m;
            li.add(count);
        }
        System.out.println(li.size());
    }


    @After
    public void after() {
        System.out.println(System.currentTimeMillis() - startTime);
    }



    @Test
    public void testEmptyList() {
        List<String> li = Collections.emptyList();
        li.forEach(System.out::println);
    }

    public List<String> returnList() {
       return Collections.emptyList();
    }


    private class Coder{
        int age;

        String name;

        double salary;

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null) return false;
            if(getClass() != o.getClass()) return false;

            Coder other = (Coder) o;

            return new EqualsBuilder().append(age, other.age)
                    .append(name, other.name)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(age)
                    .append(name)
                    .toHashCode();
        }
    }
}

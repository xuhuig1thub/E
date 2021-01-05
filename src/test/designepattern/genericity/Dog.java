package test.designepattern.genericity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-13 2:27
 */
public class Dog extends Animal{
    public void say(){
        System.out.println("Im dog");
    }

    public static void main(String[] args) {
        List<Dog> l= new ArrayList<Dog>();
        Dog dog1=new Dog();
        Dog dog2=new Dog();
        Dog dog3=new Dog();
        Animal animal=new Animal();
        l.add(dog1);
        l.add(dog2);
        List<? extends Animal> list=l;
    //    list.add(a);//compile error <? extends>无法向里面添加元素
       Animal animal1=list.get(0);
        animal1.say();

        System.out.println("-------------");
        List<Animal> l2= new ArrayList<Animal>();
        List<? super Animal> list2=l2;
        list2.add(animal);
        list2.add(new Dog());
        list2.add(new Cat());
        Consumer<? super Animal> consumer= (Animal a) -> a.say();
        l2.forEach(consumer);
        System.out.println("=============");
        Consumer<? super Object> consumer1 = (Object a) -> {((Animal) a).say();};
        list2.forEach(consumer1);

    }
    @Test
    public void testRegex(){
    String str="adf,23,32,fd,dd";
        System.out.println(Arrays.asList(str.split(",")));
        System.out.println(str.replaceAll("d*","xixi"));
    }
}

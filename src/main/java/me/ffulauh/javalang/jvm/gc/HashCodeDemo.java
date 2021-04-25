package me.ffulauh.javalang.jvm.gc;

import me.ffulauh.domain.Person;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class HashCodeDemo {
    public static void main(String[] args) {
        hashCodeChange();
    }

    // gc后地址与hashCode的变化
    private static void gcAffectHashCode(){
        Person person=new Person();
        System.out.println(person.hashCode());
        person.setName("hanshaohua");
        System.out.println(person.hashCode());
        Object obj=new Object();
        long address= VM.current().addressOf(obj);
        long hashCode=obj.hashCode();

        System.out.println("before GC : The memory address is " + address);
        System.out.println("before GC : The hash code is " + hashCode);

        System.gc();

        long afterAddress = VM.current().addressOf(obj);
        long afterHashCode = obj.hashCode();
        System.out.println("after GC : The memory address is " + afterAddress);
        System.out.println("after GC : The hash code is " + afterHashCode);
        System.out.println("---------------------");

        System.out.println("memory address = " + (address == afterAddress));
        System.out.println("hash code = " + (hashCode == afterHashCode));
    }

    private static void hashCodeChange(){

        // 创建对象并打印JVM中对象的信息
        Person person = new Person();
        person.setName("hanhanhan");
        printInstanceDetails(person);

        System.gc();
        printInstanceDetails(person);

        // 调用hashCode方法，如果重写了hashCode方法则调用System#identityHashCode方法
        System.out.println(person.hashCode());
        printInstanceDetails(person);

        // 再次打印对象JVM中的信息
        System.gc();
        printInstanceDetails(person);
    }

    private static void printInstanceDetails(Object obj){
        System.out.println("before GC : The memory address is " + VM.current().addressOf(obj));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}

package me.ffulauh.javalang.referencetest;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class Test {

    private static List list=new ArrayList();
    private static List list2=new ArrayList();

    public static void main(String[] args) {
        //testSoftReference();
        //testWeakReference();
        testEntryReference();
    }

    private static void testStrongReference(){
        byte[] buff=new byte[1024*1024*2];
    }

    private static void testSoftReference(){
        //达到一定的比例后才会回收
        for(int i=0;i<10;i++){
            byte[] buff=new byte[1024*1024];
            SoftReference<byte[]> sr=new SoftReference<>(buff);
            list.add(sr);
            //list2.add(buff);
            //System.gc();
        }
        System.gc();
        for(int i=0;i<list.size();i++){
            Object obj=((SoftReference)list.get(i)).get();
            System.out.println(obj);
        }
    }

    private static void testWeakReference(){
        //只要gc就会回收
        for(int i=0;i<10;i++){
            byte[] buff=new byte[1024*1024];
            WeakReference<byte[]> sr=new WeakReference<>(buff);
            list.add(sr);
        }
        System.gc();
        for(int i=0;i<list.size();i++){
            Object obj=((WeakReference)list.get(i)).get();
            System.out.println(obj);
        }
    }

    private static void testEntryReference(){
        //只要gc就会回收
        for(int i=0;i<10;i++){
            byte[] buff=new byte[1024*1024];
            String value=i+"";
            Entry sr=new Entry(buff,value);
            list.add(sr);
        }
        System.gc();
        for(int i=0;i<list.size();i++){
            Entry entry=(Entry) list.get(i);
            System.out.println(entry);
        }
    }

    static class Entry extends WeakReference {

        Object value;

        public Entry(Object referent,Object vallue) {
            super(referent);
            this.value=vallue;
        }
    }

}

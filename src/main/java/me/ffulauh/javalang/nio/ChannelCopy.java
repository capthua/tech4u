package me.ffulauh.javalang.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy {
    private static final int BSIZE=6;

    public static void main(String[] args)throws Exception {
        ByteBuffer bb=ByteBuffer.allocate(BSIZE);
//        int i=0;
//        while (i++<bb.limit()){
//            if(bb.get()!=0){
//                System.out.println(bb.get());
//            }
//        }
//        bb.asCharBuffer().put("hanshoahua");
//        System.out.println(bb.asCharBuffer().toString());
//        bb.rewind();
//        System.out.println(bb.asCharBuffer().toString());
        bb.put((byte)129);
        bb.put((byte)2);
        bb.put((byte)3);
        //bb.putInt(33);
        System.out.println("hehe");
    }
}

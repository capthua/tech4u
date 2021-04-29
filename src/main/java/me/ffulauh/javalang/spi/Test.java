package me.ffulauh.javalang.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        ServiceLoader<UploadCdn> uploadCdns=ServiceLoader.load(UploadCdn.class);
        Iterator<UploadCdn> iterator=uploadCdns.iterator();
        while (iterator.hasNext()){
            UploadCdn uploadCdn=iterator.next();
            uploadCdn.upload("hehe");
        }
    }
}

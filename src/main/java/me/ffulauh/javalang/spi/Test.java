package me.ffulauh.javalang.spi;

import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        ServiceLoader<KeyGenerator> keyGenerators=ServiceLoader.load(KeyGenerator.class);
        for (KeyGenerator generator : keyGenerators) {
            System.out.println(generator.gen());
        }
    }
}

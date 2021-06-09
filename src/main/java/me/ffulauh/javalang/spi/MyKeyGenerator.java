package me.ffulauh.javalang.spi;

public class MyKeyGenerator implements KeyGenerator {
    @Override
    public String gen() {
        return "my key";
    }
}

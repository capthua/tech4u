package me.ffulauh.javalang.spi;

public class YourKeyGenerator implements KeyGenerator {
    @Override
    public String gen() {
        return "your key";
    }
}

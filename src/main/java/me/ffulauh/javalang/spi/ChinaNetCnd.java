package me.ffulauh.javalang.spi;

public class ChinaNetCnd implements UploadCdn{
    @Override
    public void upload(String url) {
        System.out.println("upload to china net cdn");
    }
}

package me.ffulauh.javalang.spi;

public class QiyiCnd implements UploadCdn{
    @Override
    public void upload(String url) {
        System.out.println("upload to qiyi cdn");
    }
}

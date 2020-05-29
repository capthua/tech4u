package me.ffulauh.javalang.fp;

import java.io.File;
import java.io.FileFilter;

public class HiddenFilleTest {
    public static void main(String[] args) {
        File[] hiddenFiles=new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

//        lambda
        File[] hiddenFiles2=new File(".").listFiles( (file) -> file.isHidden());

//        将方法作为值传递
        File[] hiddenFiles3=new File(".").listFiles(File::isHidden);

    }

}

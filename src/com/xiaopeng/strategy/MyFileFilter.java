package com.xiaopeng.strategy;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter {

    @Test
    public void test_E001()
    {
        File file = new File("./src/com/xiaopeng/strategy");
        File[] files = file.listFiles(new DiyFileFilter());
        for(File f : files) {
            System.out.println(f.getName());
        }
    }

    class DiyFileFilter implements FileFilter{

        @Override
        public boolean accept(File file) {
            if(file.getName().endsWith(".java")){
                return true;
            }
            return false;
        }
    }

}

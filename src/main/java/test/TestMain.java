package test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestMain {
    public static void main(String[] args) {
        TestObject tO = new TestObject();
        tO.setA("序列化A");
        tO.setB("序列化B");

        ObjectOutputStream out = null;
        FileOutputStream font = null;

        System.getProperty("user");
    }
}

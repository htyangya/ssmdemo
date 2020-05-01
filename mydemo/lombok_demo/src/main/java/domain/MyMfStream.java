package domain;

import java.io.Closeable;
import java.io.IOException;

public class MyMfStream implements Closeable {
    public void close() throws IOException {
        System.out.println("我的流已经被关闭！");

    }
}

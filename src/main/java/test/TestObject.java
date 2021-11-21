package test;

import java.io.Serializable;

public class TestObject implements Serializable {
    private static final long serialVersionUID = -1407266155172499954L;
    private  transient String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}

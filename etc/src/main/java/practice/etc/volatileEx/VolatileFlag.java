package practice.etc.volatileEx;

public class VolatileFlag {

    private volatile boolean flag = false;

    public void setFlag() {
        flag = true;
    }

    public boolean getFlag() {
        return flag;
    }
}

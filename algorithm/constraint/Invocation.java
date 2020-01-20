package algorithm.constraint;

/**
 * @Author: mianba
 * @Date: 2019/10/16 11:49
 * @Description: 对请求的抽象
 */

public class Invocation {

    public Invocation(String key) {
        this.key = key;
    }

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}


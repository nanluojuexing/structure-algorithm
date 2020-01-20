package algorithm.constraint;

/**
 * @Author: mianba
 * @Date: 2019/10/21 11:35
 * @Description: hashcode实现
 */
public class JdkHashCodeStrategy implements HashStrategy {

    @Override
    public int getHashCode(String origin) {
        return origin.hashCode();
    }
}

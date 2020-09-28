package algorithm.TimeWheel;

/**
 * 监听过期事件
 * @param <E>
 */
public interface ExpirationListener<E> {

    /**
     * Invoking when a expired event occurs.
     *
     * @param expiredObject
     */
    void expired(E expiredObject);
}

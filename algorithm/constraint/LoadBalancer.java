package algorithm.constraint;

import java.util.List;

/**
 * @Author: mianba
 * @Date: 2019/10/16 11:47
 * @Description:
 */
public interface LoadBalancer {
    Server select(List<Server> servers, Invocation invocation);
}

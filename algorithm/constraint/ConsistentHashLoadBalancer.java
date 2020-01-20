package algorithm.constraint;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: mianba
 * @Date: 2019/10/21 11:31
 * @Description: 一致性hash算法的实现
 */
public class ConsistentHashLoadBalancer implements LoadBalancer {

    private HashStrategy hashStrategy = new JdkHashCodeStrategy();

    private final static int VIRTUAL_NODE_SIZE = 10;
    private final static String VIRTUAL_NODE_SUFFIX = "&&";

    @Override
    public Server select(List<Server> servers, Invocation invocation) {
        int hashCode = hashStrategy.getHashCode(invocation.getKey());
        TreeMap<Integer, Server> ring = buildConsistentHashRing(servers);
        Server server = locate(ring,hashCode);
        return server;
    }

    public Server locate(TreeMap<Integer, Server> ring,int hashCode){
        // ring.ceilingEntry 获取 环上最近的一个节点
        Map.Entry<Integer, Server> locateEntry = ring.ceilingEntry(hashCode);
        if (locateEntry == null) {
            locateEntry= ring.firstEntry();
        }
        return locateEntry.getValue();
    }

    public TreeMap<Integer,Server> buildConsistentHashRing(List<Server> servers){
        TreeMap<Integer, Server> virtualNodeRing = new TreeMap<>();
        for (Server server : servers) {
            // 10个虚拟环
            for (int i = 0; i < VIRTUAL_NODE_SIZE; i++) {
                virtualNodeRing.put(hashStrategy.getHashCode(server.getUrl()+VIRTUAL_NODE_SUFFIX+i),server);
            }
        }
        return virtualNodeRing;
    }
}

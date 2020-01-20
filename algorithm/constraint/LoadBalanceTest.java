package algorithm.constraint;

import com.google.common.util.concurrent.AtomicLongMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: mianba
 * @Date: 2019/10/21 11:35
 * @Description: 测试程序
 */
public class LoadBalanceTest {

    /**
     * 测试分布情况
     */
    public void testDistribution(){
        List<Server> servers = new ArrayList<>();
        // 生成动态ip
        String[] ips = GenerateIps.ips();
        for (String ip : ips) {
            servers.add(new Server(ip+":8080"));
        }

        ConsistentHashLoadBalancer balancer = new ConsistentHashLoadBalancer();
        //构造请求
        List<Invocation> invocations = new ArrayList<>();
        for (int i = 0; i < 100000 ; i++) {
            invocations.add(new Invocation(UUID.randomUUID().toString()));
        }
        //统计分布情况
        ConcurrentHashMap<Server,Long> map = new ConcurrentHashMap();

        for (Server server : servers) {
            map.put(server,0L);
        }

        for (Invocation invocation : invocations) {
            Server select = balancer.select(servers, invocation);
            synchronized (LoadBalanceTest.class){
                map.put(select,map.get(select)+1);
            }
        }

        System.out.println(StatisticsUtil.variance(map.values().toArray(new Long[]{})));
        System.out.println(StatisticsUtil.standardDeviation(map.values().toArray(new Long[]{})));
    }

    /**
     * 测试节点新增删除后的变化程度
     */
    public void testNodeAddAndRemove() {
        List<Server> servers = new ArrayList<>();
        for (String ip : GenerateIps.ips()) {
            servers.add(new Server(ip));
        }
        List<Server> serverChanged = servers.subList(0, 80);
        ConsistentHashLoadBalancer chloadBalance = new ConsistentHashLoadBalancer();
        // 构造 10000 随机请求
        List<Invocation> invocations = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            invocations.add(new Invocation(UUID.randomUUID().toString()));
        }
        int count = 0;
        for (Invocation invocation : invocations) {
            Server origin = chloadBalance.select(servers, invocation);
            Server changed = chloadBalance.select(serverChanged, invocation);
            if (origin.getUrl().equals(changed.getUrl())) count++;
        }
        System.out.println(count / 10000D);
    }

    public static void main(String[] args) {
        LoadBalanceTest loadBalanceTest = new LoadBalanceTest();
        loadBalanceTest.testDistribution();
    }
}

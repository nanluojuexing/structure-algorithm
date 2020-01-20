package algorithm.constraint;

/**
 * @Author: mianba
 * @Date: 2019/10/16 11:49
 * @Description: 对服务器的抽象 ip+port
 */
public class Server {

    private String url;

    public Server(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

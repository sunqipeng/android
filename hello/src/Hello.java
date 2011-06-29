/**
 * Created by IntelliJ IDEA.
 * User: sunqipeng
 * Date: 11-6-29
 * Time: 上午11:12
 * To change this template use File | Settings | File Templates.
 */
public class Hello {
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name="ceshi";
    private String address;

    public void hello() {
        name = String.valueOf(System.currentTimeMillis());
    }
}


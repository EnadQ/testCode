package enad.test.com.testapplication;

import java.io.Serializable;

/**
 * Created by User1 on 12/14/2016.
 */

public class ObjectBean implements Serializable {

    Object obj;
    String privateKey;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}

package businesslogic;

import businesslogicservice.loginservice;

/**
 * Created by huihantao on 2016/12/13.
 */
public class login implements loginservice {
    @Override
    public boolean login(String id, char[] password) {
        return true;
    }
}

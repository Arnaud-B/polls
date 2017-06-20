package filter;

import entities.User;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by nono on 20/06/2017.
 */
@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ModelData {

    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

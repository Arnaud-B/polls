package services;

import org.springframework.stereotype.Service;

/**
 * Created by Nico on 09/02/2016.
 */
@Service
public class HelloService implements IHelloService {
    @Override
    public String hello() {
        return "Hello from hello service";
    }
}

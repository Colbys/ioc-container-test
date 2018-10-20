package it.colbys.container;

import it.colbys.IOC.exception.KeyResolveException;

import java.util.HashMap;
import java.util.Map;

public class Container implements IContainer {

    private Map<String, Object> container;

    public Container() {
        container = new HashMap<>();
    }

    @Override
    public void register(String key, Object object) {
        container.put(key, object);
    }

    @Override
    public <T> T resolve(String key) throws KeyResolveException {
        T object = (T) container.get(key);
        if (object == null) {
            throw new KeyResolveException("Unable to resolve key \"" + key + "\"");
        }
        return object;
    }
}

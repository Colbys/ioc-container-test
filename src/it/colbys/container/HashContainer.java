package it.colbys.container;

import it.colbys.IOC.exception.KeyResolveException;
import it.colbys.map.HashMap;
import it.colbys.map.IMap;

public class HashContainer implements IContainer {

    private IMap<String, Object> container;

    public HashContainer() {
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

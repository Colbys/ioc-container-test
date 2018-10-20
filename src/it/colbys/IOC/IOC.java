package it.colbys.IOC;

import it.colbys.IOC.exception.KeyResolveException;
import it.colbys.container.HashContainer;
import it.colbys.container.IContainer;

public final class IOC {

    private static IContainer container;

    static {
        container = new HashContainer();
    }

    private IOC() {}

    public static void register(String key, Object object) {
        container.register(key, object);
    }

    public static <T> T resolve(String key) throws KeyResolveException {
        return container.resolve(key);
    }
}

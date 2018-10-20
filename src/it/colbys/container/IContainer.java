package it.colbys.container;

import it.colbys.IOC.exception.KeyResolveException;

public interface IContainer {

    void register(String key, Object object);

    <T> T resolve(String key) throws KeyResolveException;
}

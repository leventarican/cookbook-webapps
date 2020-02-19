package com.github.leventarican.postrges.dao;

/**
 * Data Access Layer (DAO): isolate business layer from persistence layer.
 * <p>do CRUD operations.</p>
 * 
 * @author Levent
 */
public interface Dao<T> {
    public T read(int id);
}

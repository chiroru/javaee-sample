package jp.ddo.chiroru.javaee.sample.integration;

import java.io.Serializable;
import java.util.List;

public interface CRUDDao<T extends Serializable> {
    
    void setClazz( Class<T> clazz);

    T findById( long id );

    List< T > findAll();

    List<T> findRange(int maxResults, int firstResult);

    long count();

    void regist( T entity );

    T update( T entity );

    void remove( T entity );

    void removeById( long entityId );
}

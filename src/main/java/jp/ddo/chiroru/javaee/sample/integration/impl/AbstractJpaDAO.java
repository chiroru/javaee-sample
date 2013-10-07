package jp.ddo.chiroru.javaee.sample.integration.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * ジェネリックDaoによってJPAに基づくCRUD処理を実現するための実装を提供する抽象クラスです。<br />
 * 
 * @author chiroru
 *
 * @param <T> JPAのエンティティ
 */
public abstract class AbstractJpaDAO<T extends Serializable> {

    private Class< T > clazz;

    @PersistenceContext
    EntityManager entityManager;

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    public List< T > findAll(){
        CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(clazz);
        Root<T> query = cq.from(clazz);
        cq.select(query);
        TypedQuery<T> q = entityManager.createQuery(cq);
        return q.getResultList();
    }

    public List<T> findRange(int maxResults, int firstResult) {
        CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(clazz);
        cq.select(cq.from(clazz));
        TypedQuery<T> q = entityManager.createQuery(cq);
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
        return q.getResultList();
    }

    public long count() {
        CriteriaBuilder qb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cq = qb.createQuery(Long.class);
        cq.select(qb.count(cq.from(clazz)));
        // cq.where(/*your stuff*/);
        TypedQuery<Long> query = entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    public void regist( T entity ){
        entityManager.persist( entity );
    }

    public T update( T entity ){
        return entityManager.merge( entity );
    }

    public void remove( T entity ){
        entityManager.remove( entity );
    }

    public void removeById( long entityId ){
        T entity = findById( entityId );
        remove( entity );
    }
}

package pl.edu.agh.soa;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public abstract class AbstractDao {

    @PersistenceContext(unitName = "soa_db") //wstrzyknięcie po nazwie z persistence.xml
    protected EntityManager entityManager;

    public <T> void create(T object) {
        entityManager.persist(object);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public <T> void createNewTransaction(T object) {
        entityManager.persist(object);
    }

    public <T> boolean update(T object) {
        entityManager.merge(object);
        return true;
    }

    public <T> boolean delete(Object pk) {
        T object = entityManager.find(getType(), pk);
        entityManager.remove(object);

        return true;
    }

    public <T> List<T> list(final int offset, final int limit) {
        final CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(getType());
        criteriaQuery.from(getType());
        final TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(offset).setMaxResults(limit);
        return query.getResultList();
    }

    public <T> T get(Object pk) {
        return entityManager.find(getType(), pk);
    }

    protected <T> Optional<T> getSingleResult(List<T> resultList) {
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }

    protected void fillQueryParameters(final Query query, final Map<String, Object> filters) {
        for (final Map.Entry<String, Object> filter : filters.entrySet()) {
            query.setParameter(filter.getKey(), filter.getValue());
        }
    }

    protected <T> T getSingleResult(final TypedQuery<T> query) {
        try {
            return query.getSingleResult();
        } catch (final NoResultException e) {
            return null;
        }
    }

    protected abstract <T> Class<T> getType();
}
package repository;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import model.BaseEntity;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public abstract class RepositoryBase<Key extends Serializable, Entity extends BaseEntity<Key>> implements Repository<Key,Entity> {
    private final Class<Entity> entityClass;
    @Getter
    private final Session session;

    @Override
    public Entity save(Entity entity) {
        session.persist(entity);
        return entity;
    }

    @Override
    public void delete(Key id) {
        session.remove(session.find(entityClass, id));
        session.flush();
    }

    @Override
    public void update(Entity entity) {
        session.merge(entity);
    }

    @Override
    public Optional<Entity> findById(Key id) {
        return Optional.ofNullable(session.find(entityClass, id));
    }

    @Override
    public List<Entity> findAll() {
        CriteriaQuery<Entity> criteriaQuery = session.getCriteriaBuilder().createQuery(entityClass);
        criteriaQuery.from(entityClass);
        return session.createQuery(criteriaQuery)
                .getResultList();
    }

}

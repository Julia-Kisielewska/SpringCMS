package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category) {
        entityManager.persist(category);
    }

    public void delete(Category category) {
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }

    public void update(Category category) {
        entityManager.merge(category);
    }
}

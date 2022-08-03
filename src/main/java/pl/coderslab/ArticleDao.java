package pl.coderslab;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
    public void update(Article article) {
        entityManager.merge(article);
    }

    public List<Article> findAll(){
        Query query = entityManager.createQuery("select a from Article a");
        List resultList = query.getResultList();
        return resultList;
    }

    public List<Article> findRecent5(){
        Query query = entityManager.createQuery("select a from Article a order by a.created desc");
        List resultList = query.setMaxResults(5).getResultList();
        return resultList;
    }
    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }
}

package pl.WL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class WeatherLadyRepository {
    private final EntityManager entityManager;

    public WeatherLadyRepository() {
        EntityManagerFactory entityManagerFactory =
                // Persistence.createEntityManagerFactory("weatherLady_entity_manager");
                Persistence.createEntityManagerFactory("weatherlady_entity_manager");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public Weather save(Weather weather) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(weather);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return null;
        }
        return weather;
    }
}

package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import peaksoft.config.HibernateConfig;
import peaksoft.model.Country;

import java.util.List;

public class CountryRepositoryImpl implements CountryRepository{
    private final EntityManagerFactory managerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public String saveCountry(Country country) {
        try {
            assert managerFactory != null;
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(country);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully...";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String saveCountries(List<Country> countries) {
        return null;
    }

    @Override
    public List<Country> getAllCountries() {
        try {
            assert managerFactory != null;
            EntityManager manager = managerFactory.createEntityManager();
            manager.getTransaction().begin();
            List<Country> resultList = manager.createQuery("select c from  Country  c", Country.class).getResultList();
            manager.getTransaction().commit();
            manager.close();
            return resultList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Country findCountryById(Long id) {
        try {
            assert managerFactory != null;
            EntityManager manager = managerFactory.createEntityManager();
            manager.getTransaction().begin();
            Country id1 = manager.createQuery("select  c from Country c", Country.class).setParameter("id", id).
                    getSingleResult();
            manager.getTransaction().commit();
            manager.close();
            return id1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteCountryById(Long id) {
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        Country country = manager.find(Country.class, id);
        manager.detach(country);
        manager.remove(country);
        manager.getTransaction().commit();
        manager.close();
        return "successful deleted";
    }

    @Override
    public String removeAllCountries()
    {
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.createNativeQuery("truncate table Country",Country.class).executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return "Successful deleted";
    }

    @Override
    public Country findTheLongestDescription() {
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.createNativeQuery("select c from Country c order by length(description)  desc limit 1",Country.class).executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return null;
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        Country country1 = manager.createQuery("select  c from Country c", Country.class).setParameter("id", id).
                getSingleResult();
        country1.setCountry(country.getCountry());
        country1.setDescription(country.getDescription());
        manager.getTransaction().commit();
        manager.close();
        return country1;
    }

    @Override
    public int CountProgrammerInSameCountry(String countryName) {
        EntityManager manager = managerFactory.createEntityManager();
        manager.getTransaction().begin();
        List<Country> resultList = manager.createQuery("select c from Country c where country=:countryName", Country.class).getResultList();
        manager.getTransaction().commit();
        manager.close();

        return resultList.size();
    }
}

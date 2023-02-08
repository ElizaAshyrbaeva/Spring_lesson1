package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import peaksoft.config.HibernateConfig;
import peaksoft.model.Address;
import peaksoft.model.Country;

import java.util.List;

public class AddressRepositoryImpl implements AddressRepository,AutoCloseable{
    private final EntityManagerFactory managerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public String saveAddress(Address address,Long countryId) {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Country country = entityManager.find(Country.class, countryId);
            address.setCountry(country);
            entityManager.merge(address);
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully!!!";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

        @Override
    public String saveAddresses(List<Address> addresses,Long countryId) {
        EntityManager entityManager = managerFactory.createEntityManager();
        entityManager.getTransaction().begin();
            for (Address address : addresses) {
                Country country = entityManager.find(Country.class, countryId);
                address.setCountry(country);
                entityManager.merge(address);
                entityManager.persist(address);
            }
        entityManager.getTransaction().commit();
        entityManager.close();

        return "success saved";
    }

    @Override
    public List<Address> getAllAddresses() {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List resultList = entityManager.createQuery("select  a from Address a").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return resultList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Address findById(Long id) {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Address singleResult = entityManager.createQuery("select a from Address a", Address.class).setParameter("id",id)
                    .getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return singleResult;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String removeById(Long id) {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Address address = entityManager.find(Address.class, id);
            entityManager.detach(address);
            entityManager.remove(address);
            entityManager.getTransaction().commit();
            entityManager.close();
            return address.getHomeNumber() + "Successfully deleted...";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String removeAllAddresses() {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("truncate table Address", Address.class).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Success deleted";
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        try {
            EntityManager entityManager = managerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Address address1 = entityManager.find(Address.class, id);
            address1.setRegionName(address.getRegionName());
            address1.setStreet(address.getStreet());
            address1.setHomeNumber(address.getHomeNumber());
            entityManager.getTransaction().commit();
            entityManager.close();
            return address1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        assert  managerFactory !=null;
        managerFactory.close();
    }
}

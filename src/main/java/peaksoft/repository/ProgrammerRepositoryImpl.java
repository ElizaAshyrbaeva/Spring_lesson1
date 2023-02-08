package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.HibernateConfig;
import peaksoft.model.Address;
import peaksoft.model.Country;
import peaksoft.model.Programmer;

import java.util.List;

public class ProgrammerRepositoryImpl implements ProgrammerRepository{
    private EntityManagerFactory entityManagerFactory;
    public ProgrammerRepositoryImpl(){
        this.entityManagerFactory= HibernateConfig.getEntityManagerFactory();
    }
    @Override
    public String saveProgrammer(Programmer programmer,Long addressId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class, addressId);
        programmer.setLocation(address);
        entityManager.merge(address);
        entityManager.persist(programmer);


        return "Success saved";
    }

    @Override
    public String saveProgrammers(List<Programmer> programmers,Long addressId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Address address = entityManager.find(Address.class, addressId);
        for (Programmer programmer : programmers) {
        programmer.setLocation(address);
        entityManager.merge(address);
        entityManager.persist(programmer);}
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved all";
    }

    @Override
    public void addConstraintToEmail() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("alter table Country add email unique(email)", Country.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Programmer> getAllProgrammers() {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        List resultList = manager.createNativeQuery("select  * from Programmer").getResultList();
        manager.getTransaction().commit();
        manager.close();
        return resultList;
    }

    @Override
    public Programmer findById(Long id) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Programmer id1 = manager.createQuery("select  c from Programmer c",Programmer.class).setParameter("id", id).
                getSingleResult();
        manager.getTransaction().commit();
        manager.close();

        return id1;
    }

    @Override
    public String deleteById(Long id) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Programmer programmer = manager.find(Programmer.class, id);
        manager.detach(id);
        manager.remove(id);
        manager.getTransaction().commit();
        manager.close();
        return "successful deleted";

    }

    @Override
    public String deleteAllProgrammers() {
        EntityManager manager =entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.createNativeQuery("truncate table Programmer",Programmer.class).executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return "Successful deleted";

    }

    @Override
    public Programmer updateProgrammer(Long id, Programmer programmer) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
      Programmer programmer1= manager.createQuery("select  c from Country c", Programmer.class).setParameter("id", id).
                getSingleResult();
        programmer.setLocation(programmer.getLocation());
        programmer.setProject(programmer.getProject());
        manager.getTransaction().commit();
        manager.close();
        return programmer1;
    }

    @Override
    public List<Programmer> getProgrammersWithSameCountry(String countryName) {
        return null;
    }

    @Override
    public Programmer findTheYoungestProgrammer() {
        return null;
    }

    @Override
    public Programmer findTheOldestProgrammer() {
        return null;
    }
}

package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.HibernateConfig;
import peaksoft.model.Programmer;
import peaksoft.model.Project;

import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository{
    private EntityManagerFactory entityManagerFactory;
    public ProjectRepositoryImpl(){
        this.entityManagerFactory= HibernateConfig.getEntityManagerFactory();

    }
    @Override
    public String saveProject(Project project) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved";
    }

    @Override
    public String saveProjects(List<Project> projects) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        for (Project project : projects) {
            entityManager.persist(project);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully...";
    }

    @Override
    public List<Project> getAllProjects() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Project> projectList = entityManager.createQuery("select p from Project p", Project.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return projectList;
    }

    @Override
    public Project findById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project singleResult = entityManager.createQuery("select p from Project p where id=:id", Project.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public String removeById(Long id) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project singleResult = entityManager.createQuery("select p from Project p ", Project.class).setParameter("id", id).getSingleResult();
        entityManager.detach(singleResult);
        entityManager.remove(singleResult);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted...";
    }

    @Override
    public String removeAllProjects() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("truncate table projects cascade",Project.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully...";
    }

    @Override
    public Project updateProject(Long id, Project project) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project singleResult = entityManager.createQuery("select p from Project p where id=:id", Project.class).setParameter("id", id).getSingleResult();
        singleResult.setProjectName(project.getProjectName());
        singleResult.setDescription(project.getDescription());
        singleResult.setDateOfStart(project.getDateOfStart());
        singleResult.setDateOfFinish(project.getDateOfFinish());
        singleResult.setPrice(project.getPrice());
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
    }

    @Override
    public String assignProgrammerToProject(Long progId, Long projId) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Project project1 = entityManager.createQuery("select p from Project p where id=:id", Project.class).setParameter("id", progId).getSingleResult();
        project1.getProgrammers().add(entityManager.find(Programmer.class,progId));
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully...";
    }

    @Override
    public int findTheBestExpensiveProject() {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        int i = entityManager.createNativeQuery("select p  from Project order by price desc  limit 1", Project.class).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return i;
    }

    @Override
    public void findTheFastWrittenProject() {
        EntityManager manager =entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.createNativeQuery("select *, from Project ");
        manager.getTransaction().commit();
        manager.close();

    }
}

package peaksoft.service;

import peaksoft.model.Programmer;
import peaksoft.model.Project;
import peaksoft.repository.ProjectRepository;
import peaksoft.repository.ProjectRepositoryImpl;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository  = new ProjectRepositoryImpl();

    @Override
    public String saveProject(Project project) {
        return projectRepository.saveProject(project);
    }

    @Override
    public String saveProjects(List<Project> projects) {
        return projectRepository.saveProjects(projects);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public String removeById(Long id) {
        return projectRepository.removeById(id)+" "+ "Successfully...";
    }

    @Override
    public String removeAllProjects() {
        projectRepository.removeAllProjects();
        return "Successfully";
    }

    @Override
    public Project updateProject(Long id, Project project) {
        return projectRepository.updateProject(id, project);
    }

    @Override
    public String assignProgrammerToProject(Long progId, Long projId) {
        projectRepository.assignProgrammerToProject(progId,projId);
        return "Successfully...";
    }

    @Override
    public int findTheBestExpensiveProject() {
        return projectRepository.findTheBestExpensiveProject();
    }

    @Override
    public void findTheFastWrittenProject() {
        projectRepository.findTheBestExpensiveProject();
    }
}
package peaksoft.repository;

import peaksoft.model.Project;

import java.util.List;

public interface ProjectRepository {
    String saveProject(Project project);
    String saveProjects(List<Project> projects);
    List<Project> getAllProjects();
    Project findById(Long id);
    String removeById(Long id);
    String removeAllProjects();
    Project updateProject(Long id, Project project);
    String assignProgrammerToProject(Long progId, Long projId);
    int findTheBestExpensiveProject();
    void findTheFastWrittenProject();

}

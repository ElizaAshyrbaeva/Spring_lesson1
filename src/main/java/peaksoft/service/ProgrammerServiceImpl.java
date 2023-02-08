package peaksoft.service;

import peaksoft.model.Programmer;
import peaksoft.repository.ProgrammerRepository;
import peaksoft.repository.ProgrammerRepositoryImpl;
import peaksoft.repository.ProjectRepository;
import peaksoft.repository.ProjectRepositoryImpl;

import java.util.List;

public class ProgrammerServiceImpl implements ProgrammerService{
ProgrammerRepository repository = new ProgrammerRepositoryImpl();

    @Override
    public String saveProgrammer(Programmer programmer,Long id) {
        return repository.saveProgrammer(programmer,id);
    }

    @Override
    public String saveProgrammers(List<Programmer> programmers,Long id) {
        return repository.saveProgrammers(programmers,id);
    }

    @Override
    public void addConstraintToEmail() {
        repository.addConstraintToEmail();
    }

    @Override
    public List<Programmer> getAllProgrammers() {
        return repository.getAllProgrammers();
    }

    @Override
    public Programmer findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public String deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public String deleteAllProgrammers() {
        return repository.deleteAllProgrammers();
    }

    @Override
    public Programmer updateProgrammer(Long id, Programmer programmer) {
        return repository.updateProgrammer(id,programmer);
    }

    @Override
    public List<Programmer> getProgrammersWithSameCountry(String countryName) {
        return repository.getProgrammersWithSameCountry(countryName);
    }

    @Override
    public Programmer findTheYoungestProgrammer() {
        return repository.findTheYoungestProgrammer();
    }

    @Override
    public Programmer findTheOldestProgrammer() {
        return null;
    }
}

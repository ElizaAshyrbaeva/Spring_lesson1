package peaksoft.service;

import peaksoft.model.Programmer;

import java.util.List;

public interface ProgrammerService {
    String saveProgrammer(Programmer programmer,Long id);
    String saveProgrammers(List<Programmer> programmers,Long id);
    void addConstraintToEmail();
    List<Programmer> getAllProgrammers();
    Programmer findById(Long id);
    String deleteById(Long id);
    String deleteAllProgrammers();
    Programmer updateProgrammer(Long id, Programmer programmer);
    List<Programmer> getProgrammersWithSameCountry(String countryName);
    Programmer findTheYoungestProgrammer();
    Programmer findTheOldestProgrammer();
}

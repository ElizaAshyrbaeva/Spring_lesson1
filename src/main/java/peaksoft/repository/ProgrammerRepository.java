package peaksoft.repository;

import peaksoft.model.Programmer;

import java.util.List;

public interface ProgrammerRepository {
    String saveProgrammer(Programmer programmer,Long addressId);
    String saveProgrammers(List<Programmer> programmers,Long addressId);
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

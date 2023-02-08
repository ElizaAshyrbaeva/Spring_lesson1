package peaksoft.service;

import peaksoft.model.Country;
import peaksoft.repository.CountryRepository;
import peaksoft.repository.CountryRepositoryImpl;

import java.util.List;

public class CountryServiceImpl implements CountryService{
    CountryRepository countryRepository = new CountryRepositoryImpl();
    @Override
    public String saveCountry(Country country) {
        return countryRepository.saveCountry(country);
    }

    @Override
    public String saveCountries(List<Country> countries) {
        return countryRepository.saveCountries(countries);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.getAllCountries();
    }

    @Override
    public Country findCountryById(Long id) {
        return countryRepository.findCountryById(id);
    }

    @Override
    public String deleteCountryById(Long id) {
        return countryRepository.deleteCountryById(id);
    }

    @Override
    public String removeAllCountries() {
        return countryRepository.removeAllCountries();
    }

    @Override
    public Country findTheLongestDescription() {
        return countryRepository.findTheLongestDescription();
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        return countryRepository.updateCountry(id,country);
    }

    @Override
    public int CountProgrammerInSameCountry(String countryName) {
        return countryRepository.CountProgrammerInSameCountry(countryName);
    }
}

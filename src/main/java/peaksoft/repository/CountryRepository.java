package peaksoft.repository;

import peaksoft.model.Country;

import java.util.List;

public interface CountryRepository {
        String saveCountry(Country country);
        String saveCountries(List<Country> countries);
        List<Country> getAllCountries();
        Country findCountryById(Long id);
        String deleteCountryById(Long id);
        String removeAllCountries();
        Country findTheLongestDescription();
        Country updateCountry(Long id, Country country);
        int CountProgrammerInSameCountry(String countryName);

}

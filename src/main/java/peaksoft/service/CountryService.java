package peaksoft.service;

import peaksoft.model.Country;

import java.util.List;

public interface CountryService {
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

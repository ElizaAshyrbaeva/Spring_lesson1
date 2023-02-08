package peaksoft.service;

import peaksoft.model.Address;

import java.util.List;

public interface AddressService {
        String saveAddress(Address address,Long countryId);

        //SaveWithCountry
        String saveAddresses(List<Address> addresses,Long countryId);

        List<Address> getAllAddresses();

        Address findById(Long id);

        String removeById(Long id);

        String removeAllAddresses();

        Address updateAddress(Long id, Address address);
    }


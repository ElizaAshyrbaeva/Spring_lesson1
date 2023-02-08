package peaksoft.repository;

import peaksoft.model.Address;

import java.util.List;

public interface AddressRepository {
        String saveAddress(Address address,Long countryId);
        String saveAddresses(List<Address> addresses,Long countryId);
        List<Address> getAllAddresses();
        Address findById(Long id);
        String removeById(Long id);
        String removeAllAddresses();
        Address updateAddress(Long id, Address address);
}

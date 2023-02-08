package peaksoft.service;

import peaksoft.model.Address;
import peaksoft.repository.AddressRepository;
import peaksoft.repository.AddressRepositoryImpl;

import java.util.List;

public class AddressServiceImpl implements AddressService{
    AddressRepository addressRepository = new AddressRepositoryImpl();
    @Override
    public String saveAddress(Address address,Long countryId) {
        return addressRepository.saveAddress(address,countryId);
    }

    @Override
    public String saveAddresses(List<Address> addresses,Long countryId) {
        return addressRepository.saveAddresses(addresses,countryId);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.getAllAddresses();
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public String removeById(Long id) {
        addressRepository.removeById(id);
        return "SuccessFully ...";
    }

    @Override
    public String removeAllAddresses() {
        return addressRepository.removeAllAddresses();
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        return addressRepository.updateAddress(id,address);
    }
}

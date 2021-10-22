package za.ca.cput.busticketing.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.user.UserIdentificationtype;
import za.ca.cput.busticketing.repository.user.UserIdentificationtypeRepository;
import za.ca.cput.busticketing.service.user.UserIdentificationtypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */
@Service
public class UserIdentificationtypeServiceImpl implements UserIdentificationtypeService {

private UserIdentificationtypeRepository userIdentificationtypeRepository;

   @Autowired
    public UserIdentificationtypeServiceImpl(UserIdentificationtypeRepository userIdentificationtypeRepository) {
        this.userIdentificationtypeRepository = userIdentificationtypeRepository;
    }

    @Override
    public List<UserIdentificationtype> getAll() {
        List<UserIdentificationtype> userIdentificationtypes = new ArrayList<UserIdentificationtype>();
        userIdentificationtypeRepository.findAll().forEach(userIdentificationtypes::add);
        return userIdentificationtypes;
    }

    @Override
    public UserIdentificationtype save(UserIdentificationtype userIdentificationtype) {
        return userIdentificationtypeRepository.save(userIdentificationtype);
    }

    @Override
    public Optional<UserIdentificationtype> getByID(Integer id) {
        return userIdentificationtypeRepository.findById(id);
    }

    @Override
    public UserIdentificationtype update(UserIdentificationtype userIdentificationtype) {
        return save(userIdentificationtype);
    }

    @Override
    public void delete(Integer id) {
        userIdentificationtypeRepository.deleteById(id);
    }
}


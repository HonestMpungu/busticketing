package za.ca.cput.busticketing.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.bus.Bus;
import za.ca.cput.busticketing.entity.user.UserIdentification;
import za.ca.cput.busticketing.repository.bus.BusRepository;
import za.ca.cput.busticketing.repository.user.UserIdentificationRepository;
import za.ca.cput.busticketing.service.user.UserIdentificationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author anongxa
 * Student No:204513723
 * 23/09/2021
 */
@Service
public class UserIdentificationServiceImpl implements UserIdentificationService {

    private UserIdentificationRepository userIdentificationRepository;

    @Autowired
    public UserIdentificationServiceImpl(UserIdentificationRepository userIdentificationRepository) {
        this.userIdentificationRepository = userIdentificationRepository;
    }

    @Override
    public List<UserIdentification> getAll()
    {
        List<UserIdentification> userIdentifications = new ArrayList<UserIdentification>();
        userIdentificationRepository.findAll().forEach(userIdentifications::add);
        return userIdentifications;
    }

    @Override
    public Optional<UserIdentification> getByID(Integer id )
    {
        return userIdentificationRepository.findById(id);
    }

    @Override
    public UserIdentification save( UserIdentification userIdentification )
    {
        userIdentificationRepository.save(userIdentification);
        return userIdentification;
    }

    @Override
    public UserIdentification update( UserIdentification userIdentification )
    {
        save(userIdentification);
        return userIdentification;
    }

    @Override
    public void delete( Integer id )
    {
        userIdentificationRepository.deleteById(id);
    }
}

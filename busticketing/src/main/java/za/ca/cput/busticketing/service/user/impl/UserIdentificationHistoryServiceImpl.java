package za.ca.cput.busticketing.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.bus.Bus;
import za.ca.cput.busticketing.entity.user.UserIdentificationHistory;
import za.ca.cput.busticketing.repository.bus.BusRepository;
import za.ca.cput.busticketing.repository.user.UserIdentificationHistoryRepository;
import za.ca.cput.busticketing.service.user.UserIdentificationHistoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author anongxa
 * Student No:204513723
 */
@Service
public class UserIdentificationHistoryServiceImpl implements UserIdentificationHistoryService {

    private UserIdentificationHistoryRepository userIdentificationHistoryRepository;

    @Autowired
    public UserIdentificationHistoryServiceImpl(UserIdentificationHistoryRepository userIdentificationHistoryRepository) {
        this.userIdentificationHistoryRepository = userIdentificationHistoryRepository;
    }

    @Override
    public List<UserIdentificationHistory> getAll()
    {
        List<UserIdentificationHistory> userIdentificationHistorys = new ArrayList<UserIdentificationHistory>();
        userIdentificationHistoryRepository.findAll().forEach(userIdentificationHistorys::add);
        return userIdentificationHistorys;
    }

    @Override
    public Optional<UserIdentificationHistory> getByID(Integer id )
    {
        return userIdentificationHistoryRepository.findById(id);
    }

    @Override
    public UserIdentificationHistory save( UserIdentificationHistory userIdentificationHistory )
    {
        userIdentificationHistoryRepository.save(userIdentificationHistory);
        return userIdentificationHistory;
    }

    @Override
    public UserIdentificationHistory update( UserIdentificationHistory userIdentificationHistory )
    {
        save(userIdentificationHistory);
        return userIdentificationHistory;
    }

    @Override
    public void delete( Integer id )
    {
        userIdentificationHistoryRepository.deleteById(id);
    }
}

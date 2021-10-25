package za.ca.cput.busticketing.service.bus.impl;
/*

Author : Asanda Mabaso - 205049990

 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.bus.Capacity;
import za.ca.cput.busticketing.repository.bus.CapacityRepository;
import za.ca.cput.busticketing.service.bus.CapacityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CapacityServiceImpl implements CapacityService {
    private CapacityRepository CapacityRepository;

    @Autowired
    public CapacityServiceImpl(CapacityRepository CapacityRepository) {
        this.CapacityRepository = CapacityRepository;
    }

    @Override
    public List<Capacity> getAllCapacity()
    {
        List<Capacity> capacityList = new ArrayList<Capacity>();
        CapacityRepository.findAll().forEach(capacityList::add);
        return capacityList;
    }

    @Override
    public Optional<Capacity> getByID(Integer id )
    {
        return CapacityRepository.findById(id);
    }

    @Override
    public Capacity save( Capacity capacity )
    {
        CapacityRepository.save(capacity);
        return capacity;
    }

    @Override
    public Capacity update( Capacity capacity )
    {
        save(capacity);
        return capacity;
    }

    @Override
    public void delete( Integer id )
    {
        CapacityRepository.deleteById(id);
    }

}


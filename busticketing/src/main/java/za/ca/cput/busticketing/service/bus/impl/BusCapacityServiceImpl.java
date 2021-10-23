package za.ca.cput.busticketing.service.bus.impl;

/*

Author : Asanda Mabaso - 205049990

 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.bus.BusCapacity;
import za.ca.cput.busticketing.repository.bus.BusCapacityRepository;
import za.ca.cput.busticketing.service.bus.BusCapacityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusCapacityServiceImpl implements BusCapacityService {


  private BusCapacityRepository busCapacityRepository;

	@Autowired
	public BusCapacityServiceImpl(BusCapacityRepository busCapacityRepository) {
		this.busCapacityRepository = busCapacityRepository;
	}

	@Override
	public List<BusCapacity> getAllBusCapacity()
	{
		List<BusCapacity> busC = new ArrayList<BusCapacity>();
		busCapacityRepository.findAll().forEach(busC::add);
		return busC;
	}

	@Override
	public Optional<BusCapacity> getByID(Integer id )
	{
		return busCapacityRepository.findById(id);
	}

	@Override
	public BusCapacity save( BusCapacity busCapacity )
	{
		busCapacityRepository.save(busCapacity);
		return busCapacity;
	}

	@Override
	public BusCapacity update( BusCapacity busCapacity)
	{
		save(busCapacity);
		return busCapacity;
	}

	@Override
	public void delete( Integer id )
	{
		busCapacityRepository.deleteById(id);
	}


}

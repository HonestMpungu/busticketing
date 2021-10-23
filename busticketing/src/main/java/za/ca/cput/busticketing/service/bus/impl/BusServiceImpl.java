package za.ca.cput.busticketing.service.bus.impl;
/*

Author : Asanda Mabaso - 205049990

 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.bus.Bus;
import za.ca.cput.busticketing.repository.bus.BusRepository;
import za.ca.cput.busticketing.service.bus.BusService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@Service
public class BusServiceImpl implements BusService
{

	private BusRepository busRepository;

	@Autowired
	public BusServiceImpl(BusRepository busRepository) {
		this.busRepository = busRepository;
	}

	@Override
	public List<Bus> getAllBuses()
	{
		List<Bus> buses = new ArrayList<Bus>();
		busRepository.findAll().forEach(buses::add);
		return buses;
	}

	@Override
	public Optional<Bus> getByID(Integer id )
	{
		return busRepository.findById(id);
	}

	@Override
	public Bus save( Bus bus )
	{
		busRepository.save(bus);
		return bus;
	}

	@Override
	public Bus update( Bus bus )
	{
		save(bus);
		return bus;
	}

	@Override
	public void delete( Integer id )
	{
		busRepository.deleteById(id);
	}

}

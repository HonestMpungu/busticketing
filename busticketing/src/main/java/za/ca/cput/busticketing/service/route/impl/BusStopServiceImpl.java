package za.ca.cput.busticketing.service.route.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.route.BusRoute;
import za.ca.cput.busticketing.entity.route.BusStop;
import za.ca.cput.busticketing.repository.route.BusRouteRepository;
import za.ca.cput.busticketing.repository.route.BusStopRepository;
import za.ca.cput.busticketing.service.route.BusStopService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */

@Service
public class BusStopServiceImpl implements BusStopService {

    private BusStopRepository busStopRepository;

    @Autowired
    public BusStopServiceImpl( BusStopRepository busStopRepository) {
        this.busStopRepository = busStopRepository;
    }


    @Override
    public List<BusStop> getAllStops()
    {
        List<BusStop> busStops = new ArrayList<BusStop>();
        busStopRepository.findAll().forEach(busStops::add);
        return busStops;
    }

    @Override
    public Optional<BusStop> getByID(Integer id )
    {
        return busStopRepository.findById(id);
    }

    @Override
    public BusStop save(BusStop busStop )
    {
        busStopRepository.save( busStop );
        return busStop;
    }

    @Override
    public BusStop update( BusStop busStop )
    {
        save(busStop);
        return busStop;
    }

    @Override
    public void delete( Integer id )
    {
        busStopRepository.deleteById(id);
    }


}

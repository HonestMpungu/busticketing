package za.ca.cput.busticketing.service.route.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.route.BusRoute;
import za.ca.cput.busticketing.repository.route.BusRouteRepository;
import za.ca.cput.busticketing.service.route.BusRouteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */

@Service
public class BusRouteServiceImpl implements BusRouteService {
    private BusRouteRepository busRouteRepository;

    @Autowired
    public BusRouteServiceImpl( BusRouteRepository busRouteRepository) {
        this.busRouteRepository = busRouteRepository;
    }


    @Override
    public List<BusRoute> getAllBusRoutes()
    {
        List<BusRoute> busRoutes = new ArrayList<BusRoute>();
        busRouteRepository.findAll().forEach(busRoutes::add);
        return busRoutes;
    }

    @Override
    public Optional<BusRoute> getByID(Integer id )
    {
        return busRouteRepository.findById(id);
    }

    @Override
    public BusRoute save(BusRoute busRoute )
    {
        busRouteRepository.save( busRoute );
        return busRoute;
    }

    @Override
    public BusRoute update( BusRoute busRoute )
    {
        save(busRoute);
        return busRoute;
    }

    @Override
    public void delete( Integer id )
    {
        busRouteRepository.deleteById(id);
    }


}

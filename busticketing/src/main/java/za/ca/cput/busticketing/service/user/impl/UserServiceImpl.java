package za.ca.cput.busticketing.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ca.cput.busticketing.entity.user.User;
import za.ca.cput.busticketing.repository.user.UserRepository;
import za.ca.cput.busticketing.service.user.UserService;

import java.util.List;
import java.util.Optional;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * UserServiceImpl class
 */
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getByID( Integer id )
	{
		return userRepository.findById( id );
	}

	/*public User getByFirstName(String firstName){

		return
	}*/

	@Override
	public User save( User user )
	{
		return userRepository.save( user );
	}

	@Override
	public User update( User user )
	{
		return save( user );
	}

	@Override
	public void delete( Integer id )
	{
			userRepository.deleteById( id );
	}

}

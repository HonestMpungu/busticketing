package za.ca.cput.busticketing.service.user;

import za.ca.cput.busticketing.entity.user.User;

import java.util.List;
import java.util.Optional;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * UserCardService class
 */
public interface UserService
{
	List<User> getAllUsers();

	Optional<User> getByID(Integer id);

	/*User getByFirstName(String firstName);*/

	User save(User user);

	User update(User user);

	void delete(Integer id);

}

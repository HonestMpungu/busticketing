package za.ca.cput.busticketing.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.user.User;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * User Repository class
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

}
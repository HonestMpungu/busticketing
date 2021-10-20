package za.ca.cput.busticketing.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.user.UserCard;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * UserCard Repository class
 */
@Repository
public interface UserCardRepository extends JpaRepository<UserCard, Integer> {
}

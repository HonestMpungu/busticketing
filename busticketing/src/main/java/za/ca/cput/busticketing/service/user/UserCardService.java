package za.ca.cput.busticketing.service.user;

import za.ca.cput.busticketing.entity.user.UserCard;

import java.util.List;
import java.util.Optional;

/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * UserCardService class
 */
public interface UserCardService {
     List<UserCard> getAll();

    Optional<UserCard> getByID(Integer id);

    UserCard save(UserCard userCard);

    UserCard update(UserCard userCard);

    void delete(Integer id);

}

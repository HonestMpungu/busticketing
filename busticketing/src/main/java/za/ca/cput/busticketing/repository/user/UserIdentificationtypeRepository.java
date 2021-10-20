package za.ca.cput.busticketing.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.user.UserIdentificationtype;

/**
 * @author anongxa
 * Student No:204513723
 */
@Repository
public interface UserIdentificationtypeRepository extends CrudRepository<UserIdentificationtype, Integer> {
}

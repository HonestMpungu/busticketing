package za.ca.cput.busticketing.service.user;


import org.springframework.data.jpa.repository.JpaRepository;
import za.ca.cput.busticketing.entity.user.UserIdentificationtype;

import java.util.List;
import java.util.Optional;

/**
 * @author anongxa
 * Student No:204513723
 */
public interface UserIdentificationtypeService  {

    List<UserIdentificationtype> getAll();

    Optional<UserIdentificationtype> getByID(Integer id);

    UserIdentificationtype save(UserIdentificationtype userIdentificationtype);

    UserIdentificationtype update(UserIdentificationtype userIdentificationtype);

    void delete(Integer id);
}

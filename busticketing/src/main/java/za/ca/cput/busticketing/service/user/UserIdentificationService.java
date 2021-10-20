package za.ca.cput.busticketing.service.user;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ca.cput.busticketing.entity.user.UserIdentification;

import java.util.List;
import java.util.Optional;

/**
 * @author anongxa
 * Student No:204513723
 */
public interface UserIdentificationService  {

    List<UserIdentification> getAll();

    Optional<UserIdentification> getByID(Integer id);

    UserIdentification save(UserIdentification userIdentification);

    UserIdentification update(UserIdentification userIdentification);

    void delete(Integer id);
}

package za.ca.cput.busticketing.service.user;


import org.springframework.data.repository.CrudRepository;
import za.ca.cput.busticketing.entity.user.UserIdentificationHistory;


import java.util.List;
import java.util.Optional;

/**
 * @author anongxa
 * Student No:204513723
 */

public interface UserIdentificationHistoryService  {

    List<UserIdentificationHistory> getAll();

    Optional<UserIdentificationHistory> getByID(Integer id);

    UserIdentificationHistory save(UserIdentificationHistory userIdentificationHistory);

    UserIdentificationHistory update(UserIdentificationHistory userIdentificationHistory);

    void delete(Integer id);
}

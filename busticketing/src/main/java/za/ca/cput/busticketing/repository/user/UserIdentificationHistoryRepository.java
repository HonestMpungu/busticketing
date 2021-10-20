package za.ca.cput.busticketing.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.user.UserIdentificationHistory;
/**
 * @author anongxa
 * Student No:204513723
 */
@Repository
public interface UserIdentificationHistoryRepository extends JpaRepository<UserIdentificationHistory, Integer> {
}

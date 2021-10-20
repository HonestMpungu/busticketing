package za.ca.cput.busticketing.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ca.cput.busticketing.entity.user.UserIdentification;
/**
 * @author anongxa
 * Student No:204513723
 */
@Repository
public interface UserIdentificationRepository extends JpaRepository<UserIdentification, Integer> {
}

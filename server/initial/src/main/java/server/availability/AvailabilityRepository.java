/**
 * Author: Olafur Palsson
 * HImail: olp6@gmail.com
 * Actual: olafur.palsson
 * Heiti verkefnis: server
 */

package server.availability;

import org.springframework.data.repository.CrudRepository;
import server.user.User;

public interface AvailabilityRepository extends CrudRepository<User, Long> { }

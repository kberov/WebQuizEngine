package engine;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pojos.TheUser;

@Repository
public interface UserRepo extends CrudRepository<TheUser, Long> {
    public TheUser findByEmail(String email);
}

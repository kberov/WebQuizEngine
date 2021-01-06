package engine;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pojos.TheQuiz;

@Repository
public interface QuizRepository extends CrudRepository<TheQuiz, Integer> {

}

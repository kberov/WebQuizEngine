package control;

import engine.WebQuizRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pojos.AnswerResponse;
import pojos.TheAnswer;
import pojos.TheQuiz;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * build the Spring app:
 * berov@berov-vb:~/opt/dev/Web Quiz Engine$ ./gradlew build --exclude-task test
 * Start the app:
 * berov@berov-vb:~/opt/dev/Web Quiz Engine$ java -jar ./Web\ Quiz\ Engine/task/build/libs/Web_Quiz_Engine-task.jar
 * POST several Questions:
 * berov@berov-vb:/media/sf_Documents/HyperskillProgress$ mojo get -v \
 * -H 'Content-Type: application/json' -M POST http://localhost:8889/api/quizes <quiz3.json
 * berov@berov-vb:/media/sf_Documents/HyperskillProgress$ mojo get -v \
 * -H 'Content-Type: application/json' -M POST http://localhost:8889/api/quizes <quiz1.json
 * GET a question
 * berov@berov-vb:/media/sf_Documents/HyperskillProgress$ mojo get -v \
 * -H 'Content-Type: application/json' http://localhost:8889/api/quizes/2
 */
@RestController
public class Quiz {
    final static Logger logger = LoggerFactory.getLogger(Quiz.class);

    @Autowired
    WebQuizRepository quizRepo;
    // Solve a quiz - none or more answers to a question.
    @PostMapping(value = "/api/quizzes/{id}/solve",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AnswerResponse handleAnswer(@PathVariable @Min(1) int id, @RequestBody @NotNull TheAnswer theAnswer)
            throws ResponseStatusException {

        TheQuiz quiz = quizRepo.findById(id).orElse(null);
        if (quiz == null) {
            logger.info(
                    String.format("The id %d for the question for answer %s was not found.",
                            id, theAnswer.getAnswer().toString()));
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        if (!quiz.getAnswer().toString().equals(theAnswer.getAnswer().toString())) {
            logger.warn(String.format("The expected answer is %s. But the given answer was %s",
                    quiz.getAnswer().toString(), theAnswer.getAnswer().toString()));
            return new AnswerResponse(false,
                    "Wrong answer! Please, try again.");
        }
        return new AnswerResponse(true, "Congratulations, you're right!");
    }

    // Create a new quiz
    @PostMapping("/api/quizzes")
    public TheQuiz addNewQuiz(@RequestBody @Valid TheQuiz newQuiz) {
        quizRepo.save(newQuiz);
        logger.info("param id:" + newQuiz.getId() + "the answer" + newQuiz.getAnswer());
        return newQuiz.clone();
    }

    @GetMapping("/api/quizzes/{id}")
    public TheQuiz theQuizByID(@PathVariable int id) throws ResponseStatusException {
        logger.info("param id:" + id);
        if (id > 0 && id <= quizRepo.count()) {
            return quizRepo.findById(id).orElseThrow(()->{new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            ); return null;
            });
        }
        logger.info("key not found:" + id);
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @GetMapping("/api/quizzes")
    public Iterable<TheQuiz> allQuizzes() {
        return quizRepo.findAll();
    }
}

package pojos;



import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class TheQuiz {
    private static Integer IDs = 0;
    private Integer id;
    @NotBlank(message = "Field 'title' cannot be blank!")
    private String title;
    @NotBlank(message = "Field 'test' cannot be blank!")
    private String text;
    @NotNull
    @Size(min = 2, message = "Field 'options' should contain at least 2 items!")
    private List<String> options;
    private List<Integer> answer = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    //custom getter to not be used bu Spring but only manually
    // , e.g. in @PostMapping("/api/quizzes/{id}/solve")
    public List<Integer> theAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    /**
     * Default constructor which is invoked by  @PostMapping("/api/quizes")
     * To avoid the following:
     * {
     * "timestamp":"2020-12-08T13:33:29.007+0000",
     * "status":500,
     * "error":"Internal Server Error",
     * "message":"No primary or default constructor found for class pojos.TheQuiz",
     * "path":"/api/quizes"
     * }
     **/
    public TheQuiz() {
        this.id = ++IDs;
    }

    public TheQuiz clone() {
        // The copy-constructor
        return new TheQuiz(this.getId(), this.getTitle(), this.getText(), this.getOptions());
    }

    //copy constructor to be returned to the client
    public TheQuiz(int id, String title, String text, List<String> options) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.id = id;
    }

    public TheQuiz(String title, String text, List<String> options, List<Integer> answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
        this.id = ++IDs;
    }

}

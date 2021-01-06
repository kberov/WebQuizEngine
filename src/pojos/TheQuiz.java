package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
public class TheQuiz implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TheUser user;


    @NotBlank(message = "Field 'title' cannot be blank!")
    private String title;

    @NotBlank(message = "Field 'test' cannot be blank!")
    private String text;

    @NotNull
    @Size(min = 2, message = "Field 'options' should contain at least 2 items!")
    // @ElementCollection() tells JPA to automatically create a table with options etc.
    @ElementCollection()
    private List<String> options;

    // Hide the answer from the produced JSON object but accept the value
    // when creating a new quiz to save it in the database.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    // @ElementCollection() tells JPA to automatically create a table with options etc.
    @ElementCollection()
    private List<Integer> answer;

    /**
     * Default constructor which is invoked by  @PostMapping("/api/quizzes")
     * To avoid the following:
     * {
     * "timestamp":"2020-12-08T13:33:29.007+0000",
     * "status":500,
     * "error":"Internal Server Error",
     * "message":"No primary or default constructor found for class pojos.TheQuiz",
     * "path":"/api/quizzes"
     * }
     **/
    public TheQuiz() {
    }

    //copy constructor to be returned to the client
    public TheQuiz(int id, String title, String text, List<String> options) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TheUser getUser() {
        return user;
    }

    public void setUser(TheUser user) {
        this.user = user;
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

    public List<Integer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    public TheQuiz clone() {
        // The copy-constructor
        return new TheQuiz(this.getId(), this.getTitle(), this.getText(), this.getOptions());
    }
}

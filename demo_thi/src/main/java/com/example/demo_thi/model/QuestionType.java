package com.example.demo_thi.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
    public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestionType;
    private String questionName;
/* Khi bạn truy cập vào trường questionContent trong một đối tượng QuestionType,
Hibernate (ORM framework được sử dụng trong Spring) sẽ tự động thực hiện truy vấn để lấy danh sách các đối tượng QuestionContent
liên quan đến QuestionType đó. Quá trình này dựa trên thông tin ánh xạ quan hệ giữa các lớp và cơ sở dữ liệu. */
    @OneToMany(mappedBy = "questionType",cascade = CascadeType.ALL)
    private List<QuestionContent> questionContent;
//cascade = CascadeType.ALL cho biết rằng mọi thay đổi trong QuestionType sẽ được áp dụng cho tất cả các QuestionContent tương ứng.
// Điều này có nghĩa là nếu bạn thực hiện các thao tác CRUD (Create, Read, Update, Delete) trên QuestionType,
// các thao tác tương ứng sẽ được tự động lan tỏa đến QuestionContent.

    public QuestionType() {
    }

    public Long getIdQuestionType() {
        return idQuestionType;
    }

    public void setIdQuestionType(Long idQuestionType) {
        this.idQuestionType = idQuestionType;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<QuestionContent> getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(List<QuestionContent> questionContent) {
        this.questionContent = questionContent;
    }
}
package com.example.validate.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="class_id")
    private CodegymClass codeGymClass;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CodegymClass getCodeGymClass() {
        return codeGymClass;
    }

    public void setCodeGymClass(CodegymClass codeGymClass) {
        this.codeGymClass = codeGymClass;
    }
}
//      CodegymClass A05 = new CodegymClass();
//      CodegymClass A03 = new CodegymClass();
//      A05.setClassName("Java");
//      A03.setClassName("PHP");
//
//        Student student1 = new Student();
//        student1.setStudentName("John Doe");
//        student1.setCodeGymClass(A05);
//
//        Student student2 = new Student();
//        student2.setStudentName("Jane Smith");
//        student2.setCodeGymClass(A03);

//        Student student3 = new Student();
//        student2.setStudentName("Leo Messi");
//        student2.setCodeGymClass(A03);
//
//        A05.getStudentList().add(student1);
//        A03.getStudentList().add(student2);
//        A03.getStudentList().add(student3);
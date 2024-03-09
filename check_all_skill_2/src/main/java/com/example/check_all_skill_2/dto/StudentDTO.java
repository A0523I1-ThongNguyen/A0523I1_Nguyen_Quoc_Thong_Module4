package com.example.check_all_skill_2.dto;

import com.example.check_all_skill_2.model.School;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

public class StudentDTO {
    private int idStudent;
    @NotBlank(message = "Ten Khong duoc rong")
    private String nameStudent;
    private String status;
    private int fkSchool;

    public StudentDTO() {
    }

    public StudentDTO(int idStudent, String nameStudent, String status, int fkSchool) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.status = status;
        this.fkSchool = fkSchool;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFkSchool() {
        return fkSchool;
    }

    public void setFkSchool(int fkSchool) {
        this.fkSchool = fkSchool;
    }
}

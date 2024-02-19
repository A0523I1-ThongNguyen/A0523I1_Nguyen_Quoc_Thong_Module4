package com.example.validate_form_dang_ki.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDTO implements Validator {
    @Size(min = 5, message = "> 5 characters")
    @Size(max = 45, message = "< 45  characters")
    private String firstName;

    @Size(min = 5, message = "> 5 characters")
    @Size(max = 45, message = "< 45  characters")
    private String lastName;
   @Pattern(regexp = "^0[0-9]{9,10}$", message = ("Nhập sai SDT"))
    private String phone;
//    @Min(value = 18,message = "Tuổi phải lớn hơn 18")
    private int age;
    @Pattern(regexp = "^[A-Za-z0-9]+@gmail\\.com$",message = ("Nhap dung dinh dang Email"))
    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String phone, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDto = (UserDTO) target;
        int age = userDto.getAge();
        if (age < 18) {
            errors.rejectValue("age", "205", "<Age must be older than 18>");
        }
    }

}

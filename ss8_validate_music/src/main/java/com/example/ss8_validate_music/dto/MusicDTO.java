package com.example.ss8_validate_music.dto;

import com.example.ss8_validate_music.model.Type;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicDTO implements Validator {
    private int idMusic;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 800, message = "< 800 characters")
//    @Pattern(regexp = "^[a-zA-Z0-9\\s\\u00C0-\\u1EF9]*$",message = ("Nhap dung dinh dang Email"))
    private String nameSong;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 300, message = "< 300 characters")
//    @Pattern(regexp = "^[a-zA-Z0-9\\s\\u00C0-\\u1EF9]*$",message = ("Nhap dung dinh dang Email"))
    private String singer;
    private int view;
    private String file;
    private int knType;

    public MusicDTO() {
    }

    public MusicDTO(String nameSong, String singer, String file, int knType) {
        this.nameSong = nameSong;
        this.singer = singer;
        this.file = file;
        this.knType = knType;
    }

    public int getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(int idMusic) {
        this.idMusic = idMusic;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public int getKnType() {
        return knType;
    }

    public void setKnType(int knType) {
        this.knType = knType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDTO musicDTO = (MusicDTO)  target;
        if (!musicDTO.getNameSong().matches("^[a-zA-Z0-9\\s\\u00C0-\\u1EF9]*$")){
            errors.rejectValue("nameSong",null,"Không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
        }
        if (!musicDTO.getSinger().matches("^[a-zA-Z0-9\\s\\u00C0-\\u1EF9]*$")){
            errors.rejectValue("singer",null,"Không chứa các kí tự đặc biệt như @ ; , . = - + , ….");
        }

    }
}

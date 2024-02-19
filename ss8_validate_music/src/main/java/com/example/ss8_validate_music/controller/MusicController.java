package com.example.ss8_validate_music.controller;

import com.example.ss8_validate_music.dto.MusicDTO;
import com.example.ss8_validate_music.model.Music;
import com.example.ss8_validate_music.model.Type;
import com.example.ss8_validate_music.service.music.IMusicService;
import com.example.ss8_validate_music.service.type.ITypeService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;
    @Autowired
    private ITypeService typeService;

    @ModelAttribute("listType")
    public List<Type> listType() {
        List<Type> listType = typeService.findAll();
        return listType;
    }

    @GetMapping("")
    public String showView(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Sort sort = Sort.by("view").descending();
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Music> musicPage = musicService.findAll(pageable);
        model.addAttribute("musicPage", musicPage);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musicDTO", new MusicDTO());
        return "/create";
    }

    @PostMapping("/createPost")
    public String createPost(@Valid @ModelAttribute("musicDTO") MusicDTO musicDTO, BindingResult bindingResult) {
        new MusicDTO().validate(musicDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO, music);
        Type type = typeService.findById(musicDTO.getKnType());
        music.setKnType(type);
        musicService.save(music);
        return "redirect:/music";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int idthoi) {
        musicService.delete(idthoi);
        return "redirect:/music";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, Model model) {
        MusicDTO musicDTO = new MusicDTO();
        Music music = musicService.findById(id);

        musicDTO.setKnType(music.getKnType().getIdType());//lấy ra đối tượng type>lấy id của nó> gắn vào biến int của MusicDTO
        // để show đúng kiểu type thôi
        BeanUtils.copyProperties(music, musicDTO);
        model.addAttribute("musicDTO", musicDTO);
        return "/update";
    }


    @PostMapping("/updatePost")
    public String updatePost(@Valid @ModelAttribute("musicDTO") MusicDTO musicDTO, BindingResult bindingResult) {
        new MusicDTO().validate(musicDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO, music);
        Type type = typeService.findById(musicDTO.getKnType()); // tìm đối tượng tương khóa chính ứng khóa phụ
        music.setKnType(type); // nhét đối tượng tương ứng khóa phụ vào
        musicService.save(music);
        return "redirect:/music";

//  Đúng, trong đoạn mã bạn đã cung cấp, Type type = typeService.findById(musicDTO.getKnType())
//   được sử dụng để tìm kiếm đối tượng Type tương ứng với khóa phụ (knType) trong MusicDTO.
//    Sau đó, music.setKnType(type) được sử dụng để gán đối tượng Type tìm được vào thuộc tính knType của đối tượng music.
//Ý nghĩa của việc thực hiện này là kết nối đối tượng Type (khóa phụ) với đối tượng Music (khóa chính).
// Bằng cách gán đối tượng Type vào thuộc tính knType của music, bạn đang thiết lập mối quan hệ giữa hai đối tượng này.
// Điều này cho phép bạn truy cập thông tin của đối tượng Type từ đối tượng Music khi cần thiết.
    }


    @GetMapping("getSearch")
    public String getSearch(@RequestParam(defaultValue = "0", required = false) int page, String searchName, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
//            Page<Music> pageSearchNameSong = musicService.findByNameSongContaining(pageable,searchName);
//            model.addAttribute("pageSearchNameSong",pageSearchNameSong);
        Page<Music> musicPage = musicService.searchSingerAndSong(pageable, searchName, searchName);
        model.addAttribute("musicPage", musicPage);
        return "/list";
    }

    @GetMapping("/type/{id}")
    public String type(@PathVariable int id, @RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Music> musicPage = musicService.searchForeignKeyOfMusic(pageable, id);
        model.addAttribute("musicPage", musicPage);
        return "/list";
    }

    @GetMapping("type2")
    public String type2(@RequestParam(defaultValue = "0", required = false) int page, Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Music> musicPage = musicService.listType2(pageable);
        model.addAttribute("musicPage", musicPage);
        return "/list";
    }
}

package com.example.ss1_thu_vien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/lib")
public class LibraryController {
    @GetMapping(value = "/tran")
    public String showView(Model model) {
        model.addAttribute("massage","Testting");
        return "/translation";
    }

    @PostMapping(value = "/tran")
    public String translate(@RequestParam ( name = "e" ,required = false , defaultValue = "No Choose") String e, String word, Model model) {
        String result = null;
        int count = 0;
        Map<String, String> list = new HashMap<String, String>();
        list.put("today", "hom nay");
        list.put("bye", "tam biet");
        list.put("keyboard", "ban phim");
        String proKey = null;

        // vòng lặp for đang lặp qua tất cả các cặp key-value trong list.
        // mỗi lần lặp entry dc gắn 1 phần tử(cặp key-value)
        //
        for (Map.Entry<String, String> entry : list.entrySet()) {
            if (e.equals("vn")) {
                proKey = entry.getKey();
                if (entry.getKey().equals(word)) {
                    result = word + " Translated Vietnamese is : " + entry.getValue();
                    count++;
                    break;
                }else {
                    result = word + " Không có trong từ điển";
                }
            } else if (e.equals("english")) {
                proKey = entry.getValue();
                if (entry.getValue().equals(word)) {
                    result = word + " Translated English is :" + entry.getKey();
                    count++;
                    break;
                }else {
                    result = word + " Không có trong từ điển";
                }
            }
        }

        String find = null;
        if (count > 0) {
            find = "Number of times a result was found: " + count;
        } else  {
            find = "Number of times a result was found: " + count;
        }

        model.addAttribute("find", find);

        model.addAttribute("result", result);
        return "/translation";
    }
}

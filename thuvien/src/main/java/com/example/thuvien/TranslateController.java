package com.example.thuvien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/word")
public class TranslateController {
    @GetMapping(value = "/trans")
    public String translate(Model model) {
        return "/index";
    }
    
    @PostMapping(value = "/trans")
    public String translated(@RequestParam String word, String e, Model model) {
        int count = 0;
        String result = null;
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "chao");
        map.put("cat", "meo");
        map.put("dog", "cho");

        String key = null;
        if (e.equals("eng")) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                key = entry.getKey();
                if (key.equals(word)) {
                    result = entry.getValue();
                    count++;
                }
            }
        }
        if (e.equals("vie")) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                key = entry.getValue();
                if (key.equals(word)) {
                    result = entry.getKey();
                    count++;
                }
            }
        }
        if (count > 0) {
            String c = "So lan tim thay kq la " +count;
            model.addAttribute("c", c);
        }
        if (count == 0) {
            String alert = "không tìm thấy trong từ điển";
            model.addAttribute("alert", alert);
        }
        model.addAttribute("result", result);
        return "/index";

    }

}

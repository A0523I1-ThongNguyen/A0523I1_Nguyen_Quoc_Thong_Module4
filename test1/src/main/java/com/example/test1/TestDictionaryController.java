package com.example.test1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Controller
@RequestMapping(value = "/dictionary")
public class TestDictionaryController {
    @GetMapping(value = "/get")
    public String getView(Model model) {
        model.addAttribute("entedmassenger", "day la 1 tin nhan");
        return "/list";
    }


    @PostMapping(value = "/post")
    public String settingPost(@RequestParam String e, String result, Model model) {
        Map<String, Integer> listDictionary = new HashMap<>();
        listDictionary.put("one", 1);
        listDictionary.put("two", 2);
        listDictionary.put("three", 3);
        String kq = null;
        Integer kq2 = 0;
        for (Map.Entry<String, Integer> proEntry : listDictionary.entrySet()) {
            if (e.equals("vie")) {
                if (proEntry.getValue().toString().equals(result)) {
                    kq = proEntry.getKey();
                    break;
                }
            } else if (e.equals("english")) {
                if (proEntry.getKey().equals(result)){
                    kq2 = proEntry.getValue();
                    break;
                }
            }
        }
        model.addAttribute("kq",kq);
        model.addAttribute("kq2",kq2);
        return "/list";

    }

}

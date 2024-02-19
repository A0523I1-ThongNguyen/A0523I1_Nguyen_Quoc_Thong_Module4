package com.example.ss7_check_blog.service.style;

import com.example.ss7_check_blog.model.Style;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStyleService {
    List<Style> getList();
}

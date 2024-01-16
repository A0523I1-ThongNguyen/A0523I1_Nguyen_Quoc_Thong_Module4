package com.example.spring2.repository.codegym_class;

import com.example.spring2.model.CodegymClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodegymClassRepository extends JpaRepository<CodegymClass,Long> {
}

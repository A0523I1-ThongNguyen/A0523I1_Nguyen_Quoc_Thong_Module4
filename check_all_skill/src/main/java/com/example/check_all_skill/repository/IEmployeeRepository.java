package com.example.check_all_skill.repository;

import com.example.check_all_skill.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee where name_em like %:nameEm%",nativeQuery = true)
    Page<Employee> searchByName(Pageable pageable, @Param("nameEm") String nameEm);

    @Query(value = "select * from employee where name_em like %:nameEm%",nativeQuery = true)
    List<Employee> searchByName2(@Param("nameEm") String nameEm);

    @Query(value = "select * from employee where fk_company = :idCompany",nativeQuery = true)
    List<Employee> searchByCompany(@Param("idCompany") int idCompany);

//    @Query(value = "SELECT * FROM music where id_type = :idType",nativeQuery = true)
//    Page<Music> searchForeignKeyOfMusic(Pageable pageable,@Param("idType") int idType);

}

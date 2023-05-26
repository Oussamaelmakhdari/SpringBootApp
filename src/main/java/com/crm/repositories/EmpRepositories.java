package com.crm.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crm.entity.*;
public interface EmpRepositories extends JpaRepository<Employer, Integer> {

}

package com.coolCompany.restCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coolCompany.restCRUD.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{

}

package com.example.office.repository1;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.office.entity1.Address;

@Repository
public interface AddresRepository extends JpaRepository<Address, Integer>{

}
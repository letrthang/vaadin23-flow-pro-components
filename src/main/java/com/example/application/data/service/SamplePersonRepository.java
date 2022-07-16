package com.example.application.data.service;

import com.example.application.data.entity.SamplePerson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, UUID> {

    Page<SamplePerson> findAllByOrderByFirstNameAscLastNameAsc(Pageable p);
}
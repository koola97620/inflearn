package com.example.demobootweb;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author choijaeyong on 20/03/2019.
 * @project demo-boot-web
 * @description
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

}

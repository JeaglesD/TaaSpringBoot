package taa.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import taa.springboot.domain.Wind;

@Transactional
@Component
public interface WindDao extends JpaRepository<Wind, Long> {

}
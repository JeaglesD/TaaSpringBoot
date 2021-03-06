package taa.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import taa.springboot.domain.Wave;

@Transactional
@Component
public interface WaveDao extends JpaRepository<Wave, Long> {

}

package taa.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import taa.springboot.domain.Weather;

@Transactional
@Component
public interface WeatherDao extends JpaRepository<Weather, Long> {

}

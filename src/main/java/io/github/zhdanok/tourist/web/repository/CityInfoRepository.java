package io.github.zhdanok.tourist.web.repository;

import io.github.zhdanok.tourist.web.bean.CityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityInfoRepository extends JpaRepository<CityInfo, Integer> {

}
package io.github.zhdanok.tourist.web.repository;

import io.github.zhdanok.tourist.web.bean.CityEn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityEnRepository extends JpaRepository<CityEn, Integer> {


}

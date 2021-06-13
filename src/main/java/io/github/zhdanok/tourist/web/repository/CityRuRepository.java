package io.github.zhdanok.tourist.web.repository;

import io.github.zhdanok.tourist.web.bean.CityRu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRuRepository extends JpaRepository<CityRu, Integer> {


}

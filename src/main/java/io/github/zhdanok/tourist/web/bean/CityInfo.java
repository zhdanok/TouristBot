package io.github.zhdanok.tourist.web.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "city_info")
public class CityInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "info_id")
    private Integer id;

    @Column(name = "info")
    private String info;

   @OneToOne(mappedBy = "cityInfo")
    private CityRu cityRu;

    @OneToOne(mappedBy = "cityInfo")
    private CityEn cityEn;
}

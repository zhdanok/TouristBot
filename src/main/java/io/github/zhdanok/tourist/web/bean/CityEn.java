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
@Table(name = "city_en")
public class CityEn implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_en")
    private Integer id;

    @Column(name = "name_en")
    private String nameEn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "info_id", referencedColumnName = "info_id")
    private CityInfo cityInfo;
}

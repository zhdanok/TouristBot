package io.github.zhdanok.tourist.web.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "city")
public class City implements Serializable {
    @Id
    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_en")
    private String nameEn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private CityInfo cityInfo;


}

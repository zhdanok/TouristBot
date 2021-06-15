package io.github.zhdanok.tourist.web.bean;

import lombok.*;

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
    @Column(name = "id")
    private Integer id;

    @Column(name = "info")
    private String info;

    @OneToOne(mappedBy = "cityInfo")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private City city;

    public CityInfo(String info) {
        this.info = info;
    }
}

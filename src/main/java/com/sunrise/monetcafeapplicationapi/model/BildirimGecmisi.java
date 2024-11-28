package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bildirim_gecmisi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BildirimGecmisi extends BaseEntity{

    @OneToMany(mappedBy = "bildirimGecmisi" , cascade = CascadeType.ALL , fetch = FetchType.EAGER , orphanRemoval = true)
    private List<Bildirim> bildirimler = new ArrayList<>();

}

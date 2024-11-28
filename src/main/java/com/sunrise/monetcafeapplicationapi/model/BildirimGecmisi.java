package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "bildirim_gecmisi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BildirimGecmisi extends BaseEntity{

    @OneToMany
    @JoinTable(name = "bildirimler" ,
    joinColumns = @JoinColumn(name = "bildirim_gecmisi_id"),
    inverseJoinColumns = @JoinColumn(name = "bildirim_id"))
    private List<Bildirim> bildirimler;

}

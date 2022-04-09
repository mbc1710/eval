package com.company.evaluationwebapi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "brand_entity",schema = "database")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer brandId;

    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    
    @OneToMany(mappedBy = "price", orphanRemoval = false, cascade = CascadeType.ALL)
    private List<Price> priceList;
    
    @ConstructorBinding
    public Brand(Integer brandId) {
        super();
        this.brandId = brandId;
    }
    
    

}

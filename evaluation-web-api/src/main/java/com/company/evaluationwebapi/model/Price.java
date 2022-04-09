package com.company.evaluationwebapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "price_entity",schema = "database")
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "price_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ratePriceId;

    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    
    @Basic(optional = false)
    @Column(name = "product_id")
    private Integer productId;
    
    @Basic(optional = false)
    @Column(name = "priority")
    private Integer priority;
    
    @Basic(optional = false)
    @Column(name = "price")
    private Double price;

    @Basic(optional = false)
    @Column(name = "curr")
    private String curr;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;

}

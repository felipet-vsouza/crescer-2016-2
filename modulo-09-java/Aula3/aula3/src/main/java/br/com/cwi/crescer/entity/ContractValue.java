package br.com.cwi.crescer.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRACT_VALUE")
public class ContractValue implements Serializable {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT_VALUE")
    @SequenceGenerator(name = "SEQ_CONTRACT_VALUE", sequenceName = "SEQ_CONTRACT_VALUE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT_VALUE")
    private long idContractValue;
    
    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;
    
    @Basic(optional = false)
    @Column(name = "DS_PERIODICITY")
    private String dsPeriodicity;
    
    @Basic(optional = false)
    @Column(name = "VL_AMOUNT_CONTRACT_VALUE")
    private double vlAmountContractValue;
    
    @Basic(optional = false)
    @Column(name = "VL_MONTHLY_USD")
    private double vlMonthlyUsd;
    
    @ManyToOne
    @JoinColumn(name = "CONTRACT_ID_CONTRACT")
    private Contract contract;
}

package br.com.cwi.crescer.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRACT")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CONTRACT")
    @SequenceGenerator(name = "SEQ_CONTRACT", sequenceName = "SEQ_CONTRACT", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CONTRACT")
    private long idContract;

    @Basic(optional = false)
    @Column(name = "DS_DESCRIPTION")
    private String dsDescription;

    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;

    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebsite;

    @Basic(optional = false)
    @Column(name = "NM_CONTRACT")
    private String nmContract;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID_CLIENT")
    private Client Client;
    
    @OneToMany(mappedBy = "CONTRACT")
    private List<ContractValue> contractValues;
}

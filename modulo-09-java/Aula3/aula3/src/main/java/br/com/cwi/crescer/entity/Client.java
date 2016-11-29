package br.com.cwi.crescer.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLIENT")
    @SequenceGenerator(name = "SEQ_CLIENT", sequenceName = "SEQ_CLIENT", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CLIENT")
    private long idClient;

    @Basic(optional = false)
    @Column(name = "DS_EMAIL")
    private String dsEmail;

    @Basic(optional = false)
    @Column(name = "DS_PASSWORD")
    private String dsPassword;

    @Basic(optional = false)
    @Column(name = "DS_PREFERRED_COIN")
    private String dsPreferredCoin;

    @Basic(optional = false)
    @Column(name = "DS_STATE")
    private String dsState;

    @Basic(optional = false)
    @Column(name = "DS_USER_NAME")
    private String dsUserName;

    @Basic(optional = false)
    @Column(name = "NM_CLIENT")
    private String nmClient;

    @Basic(optional = false)
    @Column(name = "TP_PERMISSION")
    private String tpPermission;

    @OneToMany(mappedBy = "CLIENT")
    private List<Contract> contracts;
}

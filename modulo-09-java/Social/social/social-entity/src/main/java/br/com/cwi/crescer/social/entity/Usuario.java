package br.com.cwi.crescer.social.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    
    @Basic(optional = false)
    @Column(name = "EM_USUARIO")
    private String emUsuario;
    
    @Basic(optional = false)
    @Column(name = "SN_USUARIO")
    private String snUsuario;

    public String getSnUsuario() {
        return snUsuario;
    }

    public void setSnUsuario(String snUsuario) {
        this.snUsuario = snUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmUsuario() {
        return emUsuario;
    }

    public void setEmUsuario(String emUsuario) {
        this.emUsuario = emUsuario;
    }

    public String getStUserName() {
        return stUserName;
    }

    public void setStUserName(String stUserName) {
        this.stUserName = stUserName;
    }
    
    @Basic(optional = false)
    @Column(name = "ST_USER_NAME")
    private String stUserName;
}

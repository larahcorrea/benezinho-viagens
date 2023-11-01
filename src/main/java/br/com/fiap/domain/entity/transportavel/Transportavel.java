package br.com.fiap.domain.entity.transportavel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "TB_TRANSPOTÁVEL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Transportavel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_TRANSPORTAVEL")
    @SequenceGenerator(name = "SQ_TRANSPORTAVEL",sequenceName = "SQ_TRANSPORTAVEL",allocationSize = 1,initialValue = 1)
    @Column(name = "ID_TRANSPORTAVEL")
    private Long id;

    @Column(name= "TP_TRANSPORTAVEL")
    private String tipo;


    public Transportavel() {
    }

    public Transportavel( String tipo) {
        this.tipo = tipo;
    }

    public Transportavel(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public Transportavel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Transportavel setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    @Override
    public String toString() {
        return "Transportavel{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

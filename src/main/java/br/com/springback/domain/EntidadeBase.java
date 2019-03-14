package br.com.springback.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeBase {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @LastModifiedBy
    private String alteradoPor;

    @LastModifiedDate
    private LocalDateTime alteradoEm;
    
    @Override
    public boolean equals(Object obj) {
        if (id == null) {
            throw new RuntimeException("Entidade "+this.getClass().getSimpleName()+": id não definido no equals.");
        }

        return obj !=null && (super.equals(obj)
            || (this.getClass().equals(obj.getClass()) && this.id.equals(((EntidadeBase) obj).getId())));
    }
}

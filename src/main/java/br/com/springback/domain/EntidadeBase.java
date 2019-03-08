package br.com.springback.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Getter;

@Entity
public abstract class EntidadeBase {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @CreatedBy
    private String createUser;

    @CreatedDate
    private LocalDateTime createDate;
    
    @LastModifiedBy
    private String modifyUser;

    @LastModifiedDate
    private LocalDateTime modifyDate;
    
    @Override
    public boolean equals(Object obj) {
        if (id == null) {
            throw new RuntimeException("Entidade "+this.getClass().getSimpleName()+": id não definido no equals.");
        }

        return obj !=null && (super.equals(obj)
            || (this.getClass().equals(obj.getClass()) && this.id.equals(((EntidadeBase) obj).getId())));
    }
}

package enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public enum TipoTelefone{
    
    RESIDENCIAL(0L,"Residencial"),
    COMERCIAL(1L,"Comercial"),
    CELULAR(2L,"Celular");
    
	@Getter
    public Long id;
	
	@Getter
    public String descricao;

}    
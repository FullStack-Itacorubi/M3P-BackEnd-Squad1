package br.senai.labmedicine.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum TipoExercicioEnum {
    RESISTENCIA_AEROBICA("Resistência Aeróbica"),
    RESISTENCIA_MUSCULAR("Resistência Muscular"),
    FLEXIBILIDADE("Flexibilidade"),
    FORCA("Força"),
    AGILIDADE("Agilidade"),
    OUTRO("Outro");

    private final String descricao;

    TipoExercicioEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static TipoExercicioEnum fromString(String value){
        for(TipoExercicioEnum tipo: TipoExercicioEnum.values()){
            try {
                if(tipo.ordinal() == Integer.parseInt(value)){
                    return tipo;
                }
            }catch (NumberFormatException erro){
                throw new NumberFormatException("Especialização Clínica inválida");
            }
        }
        throw new IllegalArgumentException("Especialização Clínica inválida");
    }
}

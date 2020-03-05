package hebaja.com.example.agenda.database.converter;

import androidx.room.TypeConverter;

import hebaja.com.example.agenda.model.TipoTelefone;

public class ConversorTipoTelefone {

    @TypeConverter
    public String paraString(TipoTelefone tipo) {
        return tipo.name();
    }

    @TypeConverter
    public TipoTelefone paraTipoTelefone(String valor) {
        if(valor != null) {
            return TipoTelefone.valueOf(valor);
        }
        return TipoTelefone.FIXO;
    }

}

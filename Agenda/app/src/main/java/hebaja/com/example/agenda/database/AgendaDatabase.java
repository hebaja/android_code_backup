package hebaja.com.example.agenda.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import hebaja.com.example.agenda.database.converter.ConversorCalendar;
import hebaja.com.example.agenda.database.converter.ConversorTipoTelefone;
import hebaja.com.example.agenda.database.dao.AlunoDAO;
import hebaja.com.example.agenda.database.dao.TelefoneDAO;
import hebaja.com.example.agenda.model.Aluno;
import hebaja.com.example.agenda.model.Telefone;

import static hebaja.com.example.agenda.database.AgendaMigrations.TODAS_MIGRATIONS;

@Database(entities = {Aluno.class, Telefone.class}, version = 5, exportSchema = false)
@TypeConverters({ConversorCalendar.class, ConversorTipoTelefone.class})
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";
    public abstract AlunoDAO getRoomAlunoDAO();
    public abstract TelefoneDAO getTelefoneDAO();

    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)

                .addMigrations(TODAS_MIGRATIONS)
                .build();
    }
}

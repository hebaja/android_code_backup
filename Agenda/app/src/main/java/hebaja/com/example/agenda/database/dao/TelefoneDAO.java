package hebaja.com.example.agenda.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import hebaja.com.example.agenda.model.Telefone;

@Dao
public interface TelefoneDAO {

    @Query("SELECT * FROM Telefone WHERE aluno_id = :alunoId LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int alunoId);

    @Insert
    void salva(Telefone... telefones);

    @Query("SELECT * FROM Telefone WHERE aluno_id = :alunoId")
    List<Telefone> buscaTodosTelefonesDoAluno(int alunoId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void atualiza(Telefone... telefones);

//    @Insert
//    void salva(Telefone telefoneFixo, Telefone telefoneCelular);
}

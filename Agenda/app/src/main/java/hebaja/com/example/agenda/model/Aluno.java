package hebaja.com.example.agenda.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

@Entity
public class Aluno implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nome;
    private String email;
    private Calendar momentoDeCadastro = Calendar.getInstance();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getMomentoDeCadastro() {
        return momentoDeCadastro;
    }

    public void setMomentoDeCadastro(Calendar momentoDeCadastro) {
        this.momentoDeCadastro = momentoDeCadastro;
    }

    @NonNull
    @Override
    public String toString() {
        return nome;
    }

    public boolean temIdValido() {
        return id > 0;
    }

//    public String dataFormatada() {
//        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
//        return formatador.format(momentoDeCadastro.getTime());
//    }
}

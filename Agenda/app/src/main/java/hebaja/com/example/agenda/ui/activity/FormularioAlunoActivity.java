package hebaja.com.example.agenda.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.List;

import hebaja.com.example.agenda.R;
import hebaja.com.example.agenda.asynctask.BuscaTotosTelefonesDoAlunoTask;
import hebaja.com.example.agenda.asynctask.EditaAlunoTask;
import hebaja.com.example.agenda.asynctask.SalvaAlunoTask;
import hebaja.com.example.agenda.database.AgendaDatabase;
import hebaja.com.example.agenda.database.dao.AlunoDAO;
import hebaja.com.example.agenda.database.dao.TelefoneDAO;
import hebaja.com.example.agenda.model.Aluno;
import hebaja.com.example.agenda.model.Telefone;
import hebaja.com.example.agenda.model.TipoTelefone;

import static hebaja.com.example.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class FormularioAlunoActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR_NOVO_ALUNO = "Novo aluno";
    private static final String TITULO_APPBAR_EDITA_ALUNO = "Edita aluno";
    private EditText campoNome;
    private EditText campoTelefoneFixo;
    private EditText campoTelefoneCelular;
    private EditText campoEmail;
    private AlunoDAO alunoDAO;
    private Aluno aluno;
    private TelefoneDAO telefoneDAO;
    private List<Telefone> telefonesDoAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        AgendaDatabase database = AgendaDatabase.getInstance(this);
        alunoDAO = database.getRoomAlunoDAO();
        telefoneDAO = database.getTelefoneDAO();
        inicializacaoDosCampos();
//        configuraBotaoSalvar();
        carregaAluno();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_formulario_aluno_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_formulario_aluno_menu_salvar) {
            finalizaFormulario();
        }

        return super.onOptionsItemSelected(item);
    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_ALUNO)) {
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
            preencheCampos();
        } else {
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
            aluno = new Aluno();
        }
    }

    private void preencheCampos() {
        campoNome.setText(aluno.getNome());
        campoEmail.setText(aluno.getEmail());

        preencheCamposDeTelefone();
    }

    private void preencheCamposDeTelefone() {
        new BuscaTotosTelefonesDoAlunoTask(telefoneDAO, aluno, telefones -> {
            this.telefonesDoAluno = telefones;
            for (Telefone telefone :
                    telefonesDoAluno) {
                if (telefone.getTipo() == TipoTelefone.FIXO) {
                    campoTelefoneFixo.setText(telefone.getNumero());
                } else {
                    campoTelefoneCelular.setText(telefone.getNumero());
                }
            }
        }).execute();
    }

    private void finalizaFormulario() {

        preencheAluno();

        Telefone telefoneFixo = criaTelefone(campoTelefoneFixo, TipoTelefone.FIXO);

        Telefone telefoneCelular = criaTelefone(campoTelefoneCelular, TipoTelefone.CELULAR);

        if(aluno.temIdValido()) {
            editaAluno(telefoneFixo, telefoneCelular);
        } else {
            salvaAluno(telefoneFixo, telefoneCelular);
        }
    }

    private Telefone criaTelefone(EditText campoTelefoneFixo, TipoTelefone fixo) {
        String numeroFixo = campoTelefoneFixo.getText().toString();
        return new Telefone(numeroFixo, fixo);
    }

    private void salvaAluno(Telefone telefoneFixo, Telefone telefoneCelular) {
        new SalvaAlunoTask(alunoDAO, aluno, telefoneFixo, telefoneCelular, telefoneDAO, this::finish).execute();

    }

    private void editaAluno(Telefone telefoneFixo, Telefone telefoneCelular) {
        new EditaAlunoTask(alunoDAO, aluno, telefoneFixo, telefoneCelular, telefoneDAO, telefonesDoAluno, this::finish).execute();
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefoneFixo = findViewById(R.id.activity_formulario_aluno_telefone_fixo);
        campoTelefoneCelular = findViewById(R.id.activity_formulario_aluno_telefone_celular);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void preencheAluno() {
        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();
        aluno.setNome(nome);
        aluno.setEmail(email);
    }
}

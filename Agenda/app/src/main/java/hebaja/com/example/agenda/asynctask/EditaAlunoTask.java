package hebaja.com.example.agenda.asynctask;

import java.util.List;

import hebaja.com.example.agenda.database.dao.AlunoDAO;
import hebaja.com.example.agenda.database.dao.TelefoneDAO;
import hebaja.com.example.agenda.model.Aluno;
import hebaja.com.example.agenda.model.Telefone;
import hebaja.com.example.agenda.model.TipoTelefone;

public class EditaAlunoTask extends BaseAlunoComTelefoneTask {

    private final AlunoDAO alunoDAO;
    private final Aluno aluno;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private final TelefoneDAO telefoneDAO;
    private final List<Telefone> telefonesDoAluno;

    public EditaAlunoTask(AlunoDAO alunoDAO, Aluno aluno, Telefone telefoneFixo, Telefone telefoneCelular, TelefoneDAO telefoneDAO, List<Telefone> telefonesDoAluno, FinalizadaListener listener) {
        super(listener);
        this.alunoDAO = alunoDAO;
        this.aluno = aluno;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.telefoneDAO = telefoneDAO;
        this.telefonesDoAluno = telefonesDoAluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        alunoDAO.edita(aluno);
        vinculaAlunoComTelefone(aluno.getId(),telefoneFixo, telefoneCelular);
        atualizaIdsDosTelefones(telefoneFixo, telefoneCelular);
        telefoneDAO.atualiza(telefoneFixo, telefoneCelular);
        return null;
    }

    private void atualizaIdsDosTelefones(Telefone telefoneFixo, Telefone telefoneCelular) {
        for (Telefone telefone :
                telefonesDoAluno) {
            if (telefone.getTipo() == TipoTelefone.FIXO) {
                telefoneFixo.setId(telefone.getId());
            } else {
                telefoneCelular.setId(telefone.getId());
            }
        }
    }
}

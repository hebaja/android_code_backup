package hebaja.com.example.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import hebaja.com.example.agenda.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorId = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorId);
        alunos.add(aluno);
        atualizaIds();

    }

    private void atualizaIds() {
        contadorId++;
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPeloId(aluno);
        if (alunoEncontrado != null) {
            int posicaoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoAluno, aluno);
        }
    }

    private Aluno buscaAlunoPeloId(Aluno aluno) {
        //noinspection unused
        Aluno alunoEncontrado = null;
        for (Aluno a:
             alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }

    public void remove(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPeloId(aluno);
        if(alunoDevolvido != null) {
            alunos.remove(alunoDevolvido);
        }
    }
}

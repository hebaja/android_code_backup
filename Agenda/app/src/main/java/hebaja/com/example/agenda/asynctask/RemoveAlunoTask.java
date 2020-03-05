package hebaja.com.example.agenda.asynctask;

import android.os.AsyncTask;

import hebaja.com.example.agenda.database.dao.AlunoDAO;
import hebaja.com.example.agenda.model.Aluno;
import hebaja.com.example.agenda.ui.adapter.ListaAlunosAdapter;

public class RemoveAlunoTask extends AsyncTask<Void, Void, Void> {

    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;
    private final Aluno aluno;

    public RemoveAlunoTask(AlunoDAO dao, ListaAlunosAdapter adapter, Aluno aluno) {
        this.dao = dao;
        this.adapter = adapter;
        this.aluno = aluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.remove(aluno);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        adapter.remove(aluno);

    }
}

package model;

import java.util.Date;
import java.util.Objects;

public class Emprestimo {

    private int idEmprestimo;
    private int idLivro;
    private int idMembro;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private String status;

    public Emprestimo() {
    }

    public Emprestimo(int idEmprestimo, int id_livro, int idMembro, Date dataEmprestimo, Date dataDevolucao, String status) {
        this.idEmprestimo = idEmprestimo;
        this.idLivro = id_livro;
        this.idMembro = idMembro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdMembro() {
        return idMembro;
    }

    public void setIdMembro(int idMembro) {
        this.idMembro = idMembro;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id_emprestimo=" + idEmprestimo +
                ", id_livro=" + idLivro +
                ", id_membro=" + idMembro +
                ", data_emprestimo=" + dataEmprestimo +
                ", data_devolucao=" + dataDevolucao +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return idEmprestimo == that.idEmprestimo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idEmprestimo);
    }

    public void setId(int id) {
    }
}

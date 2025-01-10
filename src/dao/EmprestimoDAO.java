package dao;

import model.Emprestimo;
import util.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {

    public void registrarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimo (id_livro, id_membro, data_emprestimo, data_devolucao, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, emprestimo.getIdLivro());
            stmt.setInt(2, emprestimo.getIdMembro());
            stmt.setDate(3, new java.sql.Date(emprestimo.getDataEmprestimo().getTime()));
            stmt.setDate(4, new java.sql.Date(emprestimo.getDataDevolucao().getTime()));
            stmt.setString(5, emprestimo.getStatus());
            stmt.executeUpdate();
        }
    }

    public List<Emprestimo> listarEmprestimos() throws SQLException {
        String sql = "SELECT * FROM emprestimo";
        List<Emprestimo> emprestimos = new ArrayList<>();
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getInt("id"));
                emprestimo.setIdLivro(rs.getInt("id_livro"));
                emprestimo.setIdMembro(rs.getInt("id_membro"));
                emprestimo.setDataEmprestimo(rs.getDate("data_emprestimo"));
                emprestimo.setDataDevolucao(rs.getDate("data_devolucao"));
                emprestimo.setStatus(rs.getString("status"));
                emprestimos.add(emprestimo);
            }
        }
        return emprestimos;
    }

    public void atualizarStatusEmprestimo(int id, String status) throws SQLException {
        String sql = "UPDATE emprestimo SET status = ? WHERE id_emprestimo = ?";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}

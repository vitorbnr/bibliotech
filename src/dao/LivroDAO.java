package dao;

import model.Livro;
import util.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    public void adicionarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO livro (titulo, autor, editora, ano_publicacao) VALUES (?, ?, ?, ?)";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setInt(4, livro.getAnoPublicacao());
            stmt.executeUpdate();
        }
    }

    public List<Livro> listarLivros() throws SQLException {
        String sql = "SELECT * FROM livro";
        List<Livro> livros = new ArrayList<>();
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setEditora(rs.getString("editora"));
                livro.setAnoPublicacao(rs.getInt("ano"));
                livros.add(livro);
            }
        }
        return livros;
    }

    public void atualizarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, editora = ?, ano_publicacao = ? WHERE id_livro = ?";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getEditora());
            stmt.setInt(4, livro.getAnoPublicacao());
            stmt.setInt(5, livro.getId());
            stmt.executeUpdate();
        }
    }

    public void removerLivro(int id) throws SQLException {
        String sql = "DELETE FROM livro WHERE id_livro = ?";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

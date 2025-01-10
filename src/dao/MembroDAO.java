package dao;

import model.Membro;
import util.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembroDAO {

    public void adicionarMembro(Membro membro) throws SQLException {
        String sql = "INSERT INTO membro (nome, email, telefone) VALUES (?, ?, ?)";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, membro.getNome());
            stmt.setString(2, membro.getEmail());
            stmt.setString(3, membro.getTelefone());
            stmt.executeUpdate();
        }
    }

    public List<Membro> listarMembros() throws SQLException {
        String sql = "SELECT * FROM membro";
        List<Membro> membros = new ArrayList<>();
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Membro membro = new Membro();
                membro.setId(rs.getInt("id"));
                membro.setNome(rs.getString("nome"));
                membro.setEmail(rs.getString("email"));
                membro.setTelefone(rs.getString("telefone"));
                membros.add(membro);
            }
        }
        return membros;
    }

    public void atualizarMembro(Membro membro) throws SQLException {
        String sql = "UPDATE membro SET nome = ?, email = ?, telefone = ? WHERE id_membro = ?";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, membro.getNome());
            stmt.setString(2, membro.getEmail());
            stmt.setString(3, membro.getTelefone());
            stmt.setInt(4, membro.getId());
            stmt.executeUpdate();
        }
    }

    public void removerMembro(int id) throws SQLException {
        String sql = "DELETE FROM membro WHERE id_membro = ?";
        try (Connection conexao = ConexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

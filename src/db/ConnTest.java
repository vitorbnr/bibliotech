package db;

import java.sql.Connection;

public class ConnTest {
    public static void main(String[] args) {
        try (Connection conexao = ConnProps.getConnection()) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}

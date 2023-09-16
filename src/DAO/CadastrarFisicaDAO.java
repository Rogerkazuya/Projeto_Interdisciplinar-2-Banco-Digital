
package DAO;

import DTO.CadastrarFisicaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;



public class CadastrarFisicaDAO {
    
    Connection conn;
    PreparedStatement pstm; 
    public void cadastrarFisica(CadastrarFisicaDTO cadastrardto){
        String sql = 
                "insert into pessoa_fisica (Nome, Sobrenome, Endereco, Numero, Telefone, DataNascimento, Cpf, Senha) values (?,?,?,?,?,?,?,?)";
        
        conn = new ConexaoDAO().Conexao();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cadastrardto.getNome());
            pstm.setString(2, cadastrardto.getSobrenome());
            pstm.setString(3, cadastrardto.getEndereco());
            pstm.setString(4, cadastrardto.getNumero());
            pstm.setString(5, cadastrardto.getTelefone());
            pstm.setString(6, cadastrardto.getDatanascimento());
            pstm.setString(7, cadastrardto.getCpf());
            pstm.setString(8, cadastrardto.getSenha());
            
            pstm.execute();
            pstm.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CadastrarFisicaDAO: " + e);
        }
    }
}

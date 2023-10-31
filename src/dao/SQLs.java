package dao;

public enum SQLs {
    INSERT_SOCIO("INSERT INTO socio (nome, email, endereco, nascimento) VALUES (?, ?, ?, ?)"), 
    LISTALL_SOCIO("select * from socio"),
    UPDATE_SOCIO("update socio set nome=?, email=?, endereco=?, dataNasc=? where nome=?"),
    DELETE_SOCIO("delete from socio where nome=? "),
    FIND_BY_NOME_SOCIO("SELECT * FROM socio WHERE nome=?");
	
    private final String sql;
    SQLs(String sql){
        this.sql = sql; 
    
    }

    public String getSql() {
        return sql;
    }    
}


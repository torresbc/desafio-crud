package br.com.clothes.business;

import br.com.clothes.DAO.DAO;
import br.com.clothes.DAO.RepositoryTxtDAO;
import br.com.clothes.comum.Repository;

public class CreateRepository {

    public static DAO Create() {
        if(Config.getInstance().getRepositoryType() == Repository.FileTXT){
            return new RepositoryTxtDAO();
        }
        else
            return null;
    }
}

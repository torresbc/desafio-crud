package br.com.clothes.business;

import br.com.clothes.DAO.DAO;
import br.com.clothes.DAO.RepositoryTxtDAO;
import br.com.clothes.comum.Repository;

/**
 *
 * Set the repository that will be used
 * @return repository DAO instance
 */
public class CreateRepository {

    public static DAO Create() {
        if(Config.getInstance().getRepositoryType() == Repository.FileTXT){
            return new RepositoryTxtDAO();
        }
        else
            return null;
    }
}

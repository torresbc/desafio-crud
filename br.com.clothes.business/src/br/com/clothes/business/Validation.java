package br.com.clothes.business;

import br.com.clothes.DAO.DAO;

public class Validation {

    public boolean isValidProductID(int id){
        DAO dao = CreateRepository.Create();

        if(dao.read(id) == null){
            return false;
        }
        else{
            return true;
        }
    }

}

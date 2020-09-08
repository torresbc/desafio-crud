package br.com.clothes.business;

import br.com.clothes.DAO.DAO;
import br.com.clothes.comum.Color;
import br.com.clothes.comum.Size;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;



public class Validation {

    public static boolean ProductIDExists(int id){
        DAO dao = CreateRepository.Create();

        if(dao.read(id) == null){
            return false;
        }
        else{
            return true;
        }
    }

    public static boolean ValidInt(String value){
        try {
            Integer.parseInt(value);
            return true;
        }
        catch (Exception erro){
            return false;
        }
    }

    public static boolean ValidString(String value){
        return !value.isEmpty();
    }

    public static boolean ValidFloat(String value){
        try {
            Float.parseFloat(value);
            return true;
        }
        catch (Exception erro){
            return false;
        }
    }

    public static boolean ValidColor(String id){
        if(!ValidInt(id))
            return false;
        if(Color.CaseColor(Integer.parseInt(id))==null){
            return false;
        }
        return true;
    }

    public static boolean ValidSize(String id){
        if(!ValidInt(id))
            return false;
        if(Size.CaseSize(Integer.parseInt(id))==null){
            return false;
        }
        return true;
    }

    public static boolean ValidDate(String date){
        Date date2 = null;
        try{
            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            return true;
        }
        catch (Exception erro){
            return false;
        }
    }

}

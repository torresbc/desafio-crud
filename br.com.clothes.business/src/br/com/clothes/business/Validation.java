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

    public static final SimpleDateFormat dtFormat = inicializeDtFormat();

    private static SimpleDateFormat inicializeDtFormat() {
        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        dt.setLenient(false);
        return dt;
    }


    public static boolean ProductIDExists(int id){
        DAO dao = CreateRepository.Create();
        if(dao.read(id) == null){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean ValidInt(String value){
        try {
            return Integer.parseInt(value)>-1;
        }
        catch (Exception erro){
            return false;
        }
    }

    public static boolean ValidString(String value){
        return !value.trim().isEmpty()&&!value.contains("|");
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
        return Color.CaseColor(Integer.parseInt(id)) != null;
    }

    public static boolean ValidSize(String id){
        if(!ValidInt(id))
            return false;
        return Size.CaseSize(Integer.parseInt(id)) != null;
    }

    public static boolean ValidDate(String date){
        Date date2 = null;
        try{
            date2 = dtFormat.parse(date);
            return date.trim().length()==10;
        }
        catch (Exception erro){
            return false;
        }
    }

}

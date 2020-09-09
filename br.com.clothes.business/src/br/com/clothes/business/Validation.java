package br.com.clothes.business;

import br.com.clothes.DAO.DAO;
import br.com.clothes.comum.Color;
import br.com.clothes.comum.Size;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.text.DateFormat;
import java.text.ParseException;
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

    /**
     *
     * @param id int to be validated as a valid new id
     * @return true if is a non existing id for a product
     */
    public static boolean ProductIDValid(int id){
        DAO dao = CreateRepository.Create();
        return dao.read(id) == null;
    }

    /**
     *
     * @param value string to be validated as convertible to int
     * @return true if the string can be converted to int, false otherwise
     */
    public static boolean ValidInt(String value){
        try {
            return Integer.parseInt(value)>-1;
        }
        catch (Exception erro){
            return false;
        }
    }

    /**
     *
     * @param value the string to be validated
     * @return false if the string is empty or contains the char '|', true otherwise
     */
    public static boolean ValidString(String value){
        return !value.trim().isEmpty()&&!value.contains("|");
    }

    /**
     *
     * @param value string to be validated as convertible to float
     * @return true if the string can be converted to float, false otherwise
     */
    public static boolean ValidFloat(String value){
        try {
            Float.parseFloat(value);
            return true;
        }
        catch (Exception erro){
            return false;
        }
    }

    /**
     *
     * @param id string containing a id to mach a color in the Color enumerator
     * @return true if the string con be associated to a valid color id (number between 0 and 10), false otherwise
     */
    public static boolean ValidColor(String id){
        if(!ValidInt(id))
            return false;
        return Color.CaseColor(Integer.parseInt(id)) != null;
    }

    /**
     *
     * @param id string containing a id to mach a size in the Size enumerator
     * @return true if the string con be associated to a valid size id (number between 0 and 3), false otherwise
     */
    public static boolean ValidSize(String id){
        if(!ValidInt(id))
            return false;
        return Size.CaseSize(Integer.parseInt(id)) != null;
    }


    /**
     *
     * @param date string to be validated as convertible to Date
     * @return true if the string represents a Date in format 'dd/MM/yyyy', false otherwise
     */
    public static boolean ValidDate(String date){
        try{
            dtFormat.parse(date);
            return date.trim().length()==10;
        }
        catch (ParseException erro){
            return false;
        }
    }
}

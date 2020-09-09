package br.com.clothes.console;

import br.com.clothes.business.Config;
import br.com.clothes.comum.Repository;
import br.com.clothes.console.states.StateConsole;
import br.com.clothes.console.states.States;
import br.com.clothes.business.CreateRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static StateConsole state;


    public static void main(String[] args) {
        Config.getInstance().setRepositoryType(Repository.FileTXT);
        CreateRepository.Create();

        state = States.Menu.getState();
        boolean exit = false;

        while (!exit){
            exit = state.execute();
        }
    }
}

package br.com.clothes.console;

import br.com.clothes.business.Config;
import br.com.clothes.comum.Repository;
import br.com.clothes.console.states.StateConsole;
import br.com.clothes.console.states.States;

public class Main {
    public static StateConsole state;

    public static void main(String[] args) {

        Config.getInstance().setRepositoryType(Repository.FileTXT);
        state = States.CRUD.getState();
        boolean exit = false;

        while (!exit){
            exit = state.execute();
        }
    }
}

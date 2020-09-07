package br.com.clothes.console.states;


public enum States {

    CRUD(new StateCRUD()),
    List(new StateList()),
    Menu(new StateMenu());

    StateConsole state;

    States(StateConsole estado){
        this.state = estado;
    }

    public StateConsole getState(){
        return state;
    }

}

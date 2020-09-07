package br.com.clothes.console.states;

import java.util.*;
import br.com.clothes.console.Main;

public class StateMenu extends StateConsole {

    @Override
    public boolean execute(){

        System.out.println("Bem Vindo(a) ao Sistema de Cadastro de Roupas");
        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("1 - Gestão de Estoque\n2 - Listar todos os Produtos\n3 - Sair");

        String opcao = "";
        Scanner input = new Scanner(System.in);
        opcao = input.next();

        switch (opcao){
            case "1":
                Main.state = States.CRUD.getState();
                break;
            case "2":
                Main.state = States.List.getState();
                break;
            case "3":
                return true;
            default:
                System.out.println("Selecione uma opção válida");
        }

        return false;
    }

}

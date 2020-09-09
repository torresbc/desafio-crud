package br.com.clothes.console.states;

import br.com.clothes.DAO.RepositoryTxtDAO;
import br.com.clothes.business.Validation;
import br.com.clothes.comum.Product;
import br.com.clothes.console.Main;

import java.util.Scanner;

public class StateList extends StateConsole {

    @Override
    public boolean execute(){

        if(RepositoryTxtDAO.products.size()!=0)
            System.out.println("Aqui estão todos os produtos cadastrados:\n\n");
        else
            System.out.println("Não existem produtos cadastrados :/");

        for (Product p:
        RepositoryTxtDAO.products) {

            System.out.println("Código: " + p.getCode());
            System.out.println("Data de Entrada: " + Validation.dtFormat.format(p.getDate()));
            System.out.println("Local da Compra: " + p.getLocal());
            System.out.println("Tipo: " + p.getType());
            System.out.println("Marca: " + p.getBrand());
            System.out.println("Características: " + p.getDescription());
            System.out.println("Tamanho: " + p.getSize());
            System.out.println("Cor: " + p.getColor());
            System.out.println("Valor de Etiqueta na compra: " + p.getValueTag());
            System.out.println("Valor pago na compra: " + p.getValuePaid());
            System.out.println("Valor para margem de 100%: " + p.getValueBase());
            System.out.println("Preço sugerido: " + p.getPrice());

            System.out.println("\n\n");
        }

        System.out.println("Digite:\n1 - Retornar ao menu\n2 - Retornar ao estoque");

        String opcao = "";
        Scanner input = new Scanner(System.in);
        opcao = input.next();

        if(opcao.equals("2"))
            Main.state = States.CRUD.getState();
        else
            Main.state = States.Menu.getState();

        return false;
    }

}

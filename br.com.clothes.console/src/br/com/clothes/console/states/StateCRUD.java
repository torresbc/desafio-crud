package br.com.clothes.console.states;

import br.com.clothes.DAO.DAO;
import br.com.clothes.DAO.RepositoryTxtDAO;
import br.com.clothes.business.CreateRepository;
import br.com.clothes.console.Main;
import br.com.clothes.comum.Product;

import java.util.Scanner;

public class StateCRUD extends StateConsole{

    @Override
    public boolean execute(){

        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("C - Cadastrar novo produto\nR - Localizar produto\n"
                + "U - Atualizar produto\nD - Deletar produto");

        String opcao = "";
        Scanner input = new Scanner(System.in);
        opcao = input.next().toUpperCase();

        switch (opcao){
            case "C":
                Main.state = States.CRUD.getState();
                break;
            case "R":
                Main.state = States.List.getState();
                break;
            case "U":
                return true;
            case "D":
                Delete();
            default:
                System.out.println("Selecione uma opção válida");
        }

        return false;
    }

    private void Delete(){
        DAO dao = CreateRepository.Create();

        for (Product p:
             dao.products) {
            System.out.println("Código: " + p.getCode() + ", Descrição: " + p.getDescription());
        }
        boolean valido = false;
        String opcao = "";

        while (!valido){
            System.out.println("Digite o código do produto a ser deletado:");

            Scanner input = new Scanner(System.in);
            opcao = input.next().toUpperCase();


            try {
                Integer.parseInt(opcao);
            }
            catch (Exception erro){
                System.out.println("Digite um código valido");
            }


        }

    }

}

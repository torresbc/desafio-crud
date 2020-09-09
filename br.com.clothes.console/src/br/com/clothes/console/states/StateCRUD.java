package br.com.clothes.console.states;

import br.com.clothes.DAO.DAO;
import br.com.clothes.business.CreateRepository;
import br.com.clothes.console.Main;
import br.com.clothes.comum.Product;

import java.util.Date;
import br.com.clothes.comum.Size;
import br.com.clothes.comum.Color;
import br.com.clothes.business.Validation;


import java.util.Scanner;

public class StateCRUD extends StateConsole{

    /**
     *
     * Initialize CRUD menu
     */
    @Override
    public boolean execute(){

        System.out.println("Selecione uma das opções abaixo:");
        System.out.println("C - Cadastrar novo produto\nR - Localizar produto\n"
                + "U - Atualizar produto\nD - Deletar produto\n0 - Para voltar");

        String opcao = "";
        Scanner input = new Scanner(System.in);
        opcao = input.next().toUpperCase();

        switch (opcao){
            case "C":
                try{
                    Create();
                }
                catch (Exception erro){
                    System.out.println("Create() inválido");
                }
                break;
            case "R":
                Read();
                break;
            case "U":
                try{
                    Update();
                }
                catch (Exception erro){
                    System.out.println("Update() inválido");
                }
                break;
            case "D":
                Delete();
                break;
            case "0":
                Main.state = States.Menu.getState();
                break;
            default:
                System.out.println("Selecione uma opção válida");
        }

        return false;
    }


    private void Delete(){
        DAO dao = CreateRepository.Create();

        if(DAO.products.size()==0){
            System.out.println("Nenhum produto cadastrado para deletar");
            return;
        }

        for (Product p:
             DAO.products) {
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

                while (!valido){
                    System.out.println("Confirmar deleção? S/N");
                    String confirm = input.next().toUpperCase();
                    if (confirm.equals("S")){
                        dao.delete(Integer.parseInt(opcao));
                        System.out.println("Deletado com sucesso");
                        valido = true;
                    }
                    else if(confirm.equals("N")){
                        valido = true;
                    }
                }
            }
            catch (Exception erro){
                System.out.println("Digite um código valido");
            }


        }

    }

    private void Update() throws Exception{
        String opcao = "";
        Scanner input = new Scanner(System.in);
        int code;

        DAO dao = CreateRepository.Create();

        if(DAO.products.size()==0){
            System.out.println("Nenhum produto cadastrado para atualizar");
            return;
        }

        System.out.println("Digite o código do produto a ser atualizado:");
        opcao = input.next();
        while (!(Validation.ValidInt(opcao)&&
                !Validation.ProductIDValid(Integer.parseInt(opcao)))){
            System.out.println("Digite um código válido");
            opcao = input.next();
        }
        code = Integer.parseInt(opcao);

        Product prodUpdated = CRmethod(code);



        Product oldProd = dao.read(code);
        oldProd.setDate(prodUpdated.getDate());
        oldProd.setLocal(prodUpdated.getLocal());
        oldProd.setType(prodUpdated.getType());
        oldProd.setBrand(prodUpdated.getBrand());
        oldProd.setDescription(prodUpdated.getDescription());
        oldProd.setSize(prodUpdated.getSize());
        oldProd.setColor(prodUpdated.getColor());
        oldProd.setValueTag(prodUpdated.getValueTag());
        oldProd.setValuePaid(prodUpdated.getValuePaid());
        oldProd.setPrice(prodUpdated.getPrice());

        dao.update(oldProd);
    }

    private void Create() throws Exception{

        String opcao = "";
        Scanner input = new Scanner(System.in);
        int code;

        System.out.println("Digite o código do novo produto:");
        opcao = input.next();
        while (!(Validation.ValidInt(opcao)&&
                Validation.ProductIDValid(Integer.parseInt(opcao)))){
            System.out.println("Digite um código válido");
            opcao = input.next();
        }
        code = Integer.parseInt(opcao);

        Product p = CRmethod(code);
        p.setCode(code);

        DAO dao = CreateRepository.Create();

        dao.create(p);
    }

    /**
     *
     * @param id inserted by user
     * @return a new product with user-entered assignments
     */
    private Product CRmethod(int id) throws Exception{
        String opcao = "";
        Scanner input = new Scanner(System.in);

        Date date;
        String local;
        String type;
        String brand;
        String description;
        Size size;
        Color color;
        float valueTag;
        float valuePaid;
        float price;

        System.out.println("Digite a data (dd/MM/yyyy):");

        opcao = input.next();
        while (!Validation.ValidDate(opcao)){
            System.out.println("Digite uma data válida");
            opcao = input.next();
        }
        date = Validation.dtFormat.parse(opcao);


        System.out.println("Digite o local da compra:");

        opcao = input.next();
        while (!Validation.ValidString(opcao)){
            System.out.println("Digite um local válido");
            opcao = input.next();
        }
        local = opcao;

        System.out.println("Digite o tipo do produto:");

        opcao = input.next();
        while (!Validation.ValidString(opcao)){
            System.out.println("Digite um tipo válido");
            opcao = input.next();
        }
        type = opcao;


        System.out.println("Digite a marca do produto:");

        opcao = input.next();
        while (!Validation.ValidString(opcao)){
            System.out.println("Digite uma marca válida");
            opcao = input.next();
        }
        brand = opcao;


        System.out.println("Digite as características do produto:");

        opcao = input.next();
        while (!Validation.ValidString(opcao)){
            System.out.println("Digite características válidas");
            opcao = input.next();
        }
        description = opcao;

        System.out.println("Selecione o tamanho do produto:");
        System.out.println("0 - P\n1 - M\n2 - G\n3 - GG");

        opcao = input.next();
        while (!Validation.ValidSize(opcao)){
            System.out.println("Selecione um tamanho válido");
            opcao = input.next();
        }
        size = Size.CaseSize(Integer.parseInt(opcao));


        System.out.println("Selecione a cor do produto:");
        System.out.println("0 - Azul\n1 - Verde\n2 - Amarelo\n3 - Vermelho\n4 - Rosa\n5 - Roxo\n" +
                "6 - Preto\n7 - Branco\n8 - Cinza\n9 - Laranja\n10 - Marrom");

        opcao = input.next();
        while (!Validation.ValidColor(opcao)){
            System.out.println("Selecione uma cor válida");
            opcao = input.next();
        }
        color = Color.CaseColor(Integer.parseInt(opcao));


        System.out.println("Digite o valor de etiqueta na compra:");

        opcao = input.next();
        while (!Validation.ValidFloat(opcao)){
            System.out.println("Digite um valor válido");
            opcao = input.next();
        }
        valueTag = Float.parseFloat(opcao);


        System.out.println("Digite o valor pago na compra:");

        opcao = input.next();
        while (!Validation.ValidFloat(opcao)){
            System.out.println("Digite um valor válido");
            opcao = input.next();
        }
        valuePaid = Float.parseFloat(opcao);


        System.out.println("Digite o preço sugerido:");

        opcao = input.next();
        while (!Validation.ValidFloat(opcao)){
            System.out.println("Digite um valor válido");
            opcao = input.next();
        }
        price = Float.parseFloat(opcao);

        return new Product(-1, date, local, type, brand, description,
                size, color, valueTag, valuePaid, price);
    }

    private void Read(){

        DAO dao = CreateRepository.Create();

        if(DAO.products.size()==0){
            System.out.println("Nenhum produto cadastrado para ser visualizado");
            return;
        }

        String opcao;
        Scanner input = new Scanner(System.in);
        int code;

        System.out.println("Digite o código do produto a ser visualizado:");
        opcao = input.next();
        while (!(Validation.ValidInt(opcao)&&
                !Validation.ProductIDValid(Integer.parseInt(opcao)))){
            System.out.println("Digite um código válido");
            opcao = input.next();
        }
        code = Integer.parseInt(opcao);

        Product p = dao.read(code);

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
}

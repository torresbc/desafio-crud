
package br.com.clothes.DAO;

import br.com.clothes.comum.Product;
import br.com.clothes.comum.Size;
import br.com.clothes.comum.Color;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.nio.file.*;
import java.io.*;


public class RepositoryTxtDAO extends DAO {
    static List<Product> products = new ArrayList<Product>();

    public RepositoryTxtDAO() throws Exception{
        loadProducts();
    }


    private void loadProducts() throws Exception{

        List<Product> products = new ArrayList<Product>();

        File file = new File("stock.txt");

        if(file.exists()){
            List<String> linhas = new ArrayList<String>();
            try{
                linhas = Files.readAllLines(file.toPath(), Charset.defaultCharset());
            }
            catch (IOException error){

            }
            for (String line:
                linhas) {
                String[] res = line.split("\\|");

                Size size;
                Color color;

                //passar para metodo dps
                switch (Integer.parseInt(res[6])){
                    case 0:
                        size = Size.P;
                        break;
                    case 1:
                        size = Size.M;
                        break;
                    case 2:
                        size = Size.G;
                        break;
                    case 3:
                        size = Size.GG;
                        break;
                    default:
                        size = null;
                }

                switch (Integer.parseInt(res[7])){
                    case 0:
                        color = Color.BLUE;
                        break;
                    case 1:
                        color = Color.GREEN;
                        break;
                    case 2:
                        color = Color.YELLOW;
                        break;
                    case 3:
                        color = Color.RED;
                        break;
                    case 4:
                        color = Color.PINK;
                        break;
                    case 5:
                        color = Color.PURPLE;
                        break;
                    case 6:
                        color = Color.BLACK;
                        break;
                    case 7:
                        color = Color.WHITE;
                        break;
                    case 8:
                        color = Color.GRAY;
                        break;
                    case 9:
                        color = Color.ORANGE;
                        break;
                    case 10:
                        color = Color.BROWN;
                        break;
                    default:
                        color = null;
                }

                Product prod = new Product(Integer.parseInt(res[0]), (new SimpleDateFormat("dd/MM/yyyy").parse(res[1])),
                        res[2], res[3], res[4], res[5], size, color, Float.parseFloat(res[8]),
                        Float.parseFloat(res[9]), Float.parseFloat(res[10]), Float.parseFloat(res[11]));

                products.add(prod);
            }
        }

        /*
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            sc.useDelimiter("|");

            sc.next();


        }*/
    }



    public Product read(int id){
        return null;
    }

    public void update(Product p){

    }

    public void delete(int id){

    }

    public void create(Product p){

    }

}

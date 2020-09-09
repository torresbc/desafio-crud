package br.com.clothes.DAO;

import br.com.clothes.business.Validation;
import br.com.clothes.comum.Product;
import br.com.clothes.comum.Size;
import br.com.clothes.comum.Color;

import java.io.*;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.Date;
import java.util.function.Predicate;

public class RepositoryTxtDAO extends DAO {

    public RepositoryTxtDAO() {
        try{
            loadProducts();
        }
        catch (Exception erro){

        }
    }

    private void loadProducts() throws Exception {
        File file = new File("stock.txt");
        products = new ArrayList<>();
        if (file.exists()) {
            List<String> linhas = new ArrayList<String>();

            linhas = Files.readAllLines(file.toPath(), Charset.defaultCharset());

            for (String line :
                    linhas) {
                ;
                products.add(prodToProduct(line));
            }
        } else {

            file.createNewFile();
        }
    }

    public Product read(int id) {
        File file = new File("stock.txt");

        try {
            FileOutputStream newLine = new FileOutputStream(file, true);

            for (String line : Files.readAllLines(file.toPath(), Charset.defaultCharset())) {
                if (Integer.toString(id).equals(line.split("\\|")[0])) {
                    return prodToProduct(line);
                }
            }
        } catch (IOException error) {
        }
        return null;
    }

    public void update(Product p) throws Exception {
        File file = new File("stock.txt");
        List<String> lines = new ArrayList<String>();

        try {
            for (String line : Files.readAllLines(file.toPath(), Charset.defaultCharset())) {

                if (prodToString(p).split("\\|")[0].equals(line.split("\\|")[0])) {
                    lines.add(prodToString(p));
                } else {
                    lines.add(line);
                }
            }

            Files.write(file.toPath(), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            loadProducts();
        } catch (IOException error) {

        }
    }

    public void delete(int id) throws Exception {
        File file = new File("stock.txt");

        try {
            List<String> lines = new ArrayList<String>();

            for (String line : Files.readAllLines(file.toPath(), Charset.defaultCharset())) {

                if (!(Integer.toString(id).equals(line.split("\\|")[0]))) {
                    lines.add(line);
                }
            }

            Files.write(file.toPath(), lines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            loadProducts();
        } catch (IOException error) {
        }
    }

    public void create(Product p) throws Exception {
        File file = new File("stock.txt");
        products.add(p);

        try {
            FileOutputStream newLine = new FileOutputStream(file, true);
            newLine.write((prodToString(p) + "\n").getBytes());
            newLine.flush();
            newLine.close();
            loadProducts();
        } catch (IOException error) {

        }
    }

    private String prodToString(Product p) {
        String prod = p.getCode() + "|" + Validation.dtFormat.format(p.getDate()) + "|" + p.getLocal() + "|" + p.getType() + "|" + p.getBrand()
                + "|" + p.getDescription() + "|" + p.getSize().getSize() + "|" + p.getColor().getColor() + "|" +
                p.getValueTag() + "|" + p.getValuePaid() + "|" + p.getPrice();
        return prod;
    }

    private Product prodToProduct(String p) {
        String[] res = p.split("\\|");
        Size size = Size.CaseSize(Integer.parseInt(res[6]));;
        Color color = Color.CaseColor(Integer.parseInt(res[7]));

        Date dt = new Date();
        try {
            dt = Validation.dtFormat.parse(res[1]);
        }
        catch (Exception erro){
        }

        Product prod = new Product(Integer.parseInt(res[0]), dt,
                res[2], res[3], res[4], res[5], size, color, Float.parseFloat(res[8]),
                Float.parseFloat(res[9]), Float.parseFloat(res[10]));
        return prod;
    }
}

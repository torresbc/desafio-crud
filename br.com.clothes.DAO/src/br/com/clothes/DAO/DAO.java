package br.com.clothes.DAO;
import br.com.clothes.comum.Product;

import java.util.ArrayList;
import java.util.List;

public abstract class DAO {
    public static List<Product> products;

    public abstract Product read (int id);

    public abstract void update(Product p) throws Exception;

    public abstract void delete(int id) throws Exception;

    public abstract void create(Product p) throws Exception;
}

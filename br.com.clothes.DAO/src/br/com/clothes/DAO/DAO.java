package br.com.clothes.DAO;
import br.com.clothes.comum.Product;

public abstract class DAO {
    public abstract Product read (int id) throws Exception;

    public abstract void update(Product p) throws Exception;

    public abstract void delete(int id) throws Exception;

    public abstract void create(Product p) throws Exception;
}

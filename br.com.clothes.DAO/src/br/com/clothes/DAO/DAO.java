package br.com.clothes.DAO;
import br.com.clothes.comum.Product;

public abstract class DAO {
    public abstract Product read(int id);

    public abstract void update(Product p);

    public abstract void delete(int id);

    public abstract void create(Product p);
}

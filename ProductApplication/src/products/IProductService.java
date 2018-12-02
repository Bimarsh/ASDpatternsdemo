package products;

public interface IProductService {
    Product getProduct(int productNumber);
    public int getNumberInStock(int productNumber);
}

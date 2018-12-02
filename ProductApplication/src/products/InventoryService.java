package products;

public class InventoryService implements IInventoryServices {

	@Override
	public int getNumberInStock(int productNumber) {
		// TODO Auto-generated method stub
		return productNumber-200;
	}

}

package sql;

import java.util.List;

public interface Dao {
	public List<Cart> viewAll();
	public void insert(Cart cart);
	public Cart detail(String id);
	public void update(Cart cart);
	public boolean check(String id,int product_id);
	public void delete(String id);
}

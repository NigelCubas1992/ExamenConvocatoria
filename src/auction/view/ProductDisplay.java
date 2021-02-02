package auction.view;

import auction.model.Product;

/**
 *
 * @author Nigel
 */
public interface ProductDisplay {
    
    public void update();
    
    void display(Product product);
    
    public Product product();
    
}





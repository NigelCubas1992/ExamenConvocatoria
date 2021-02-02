package auction.view;

import auction.model.Auction;

/**
 *
 * @author Nigel
 */
public interface AuctionDisplay extends Auction.Observer {
    
    @Override
    public void update();
    
    void display(Auction auction);
    
    public Auction auction();
    
}


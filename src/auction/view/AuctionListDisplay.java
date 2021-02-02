package auction.view;

import java.util.List;
import auction.model.Auction;


/**
 *
 * @author Nigel
 */
public interface AuctionListDisplay {
    
    public void update();

    void display(List<Auction> auctions);
    
    void on(AuctionSelected auctionSelected);
        
    public interface AuctionSelected {
        void auction(Auction auction);
    }
    
}






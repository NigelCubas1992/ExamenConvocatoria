package auction.control;


import java.util.List;
import auction.model.Auction;
import auction.view.AuctionDisplay;
import auction.view.AuctionListDisplay;
import auction.view.AuctionLoader;
import auction.view.ProductDisplay;

public class AuctionsCommand implements Command {
    
    private final AuctionLoader auctionLoader;
    private final AuctionDisplay auctionDisplay;
    private final AuctionListDisplay auctionListDisplay;
    private final ProductDisplay productDisplay;

    public AuctionsCommand(AuctionLoader auctionLoader, AuctionDisplay auctionDisplay, AuctionListDisplay auctionListDisplay ,ProductDisplay productDisplay) {
        this.auctionLoader = auctionLoader;
        this.auctionDisplay = auctionDisplay;
        this.auctionListDisplay = auctionListDisplay;
        this.productDisplay = productDisplay;
    }
    
    @Override
    public void execute() {
        List<Auction> auctions = auctionLoader.load();
        for (Auction auction : auctions) {
            auction.subscribe((Auction.Observer) auctionListDisplay);
        }
        this.auctionListDisplay.display(auctions);
        this.auctionListDisplay.on(auctionSelected());
    }

    private AuctionListDisplay.AuctionSelected auctionSelected() {
        return new AuctionListDisplay.AuctionSelected() {
            @Override
            public void auction(Auction auction) {
                protect(auctionDisplay.auction()).unsubscribe(auctionDisplay);
                auction.subscribe(auctionDisplay);
                auctionDisplay.display(auction);
            }
        };
    }
    
    private Auction protect(Auction auction){
        return auction != null ? auction : auction.Null;
    }
    
    
}



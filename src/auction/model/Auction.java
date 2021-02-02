package auction.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nigel
 */
public class Auction {
    
    List<Observer> observers = new ArrayList<>();
    List<Product> product = new ArrayList<>();

    public static Auction Null = new Auction(){
        @Override
        public void unsubscribe(Observer observer) {
        }

        @Override
        public void subscribe(Observer observer) {
        }
        
    };

    public void subscribe(Observer observer) {   
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }
    
    public interface Observer {
        void update();
    }
    
}




package NightOwlTV.WebMovie.entityPK;

import java.io.Serializable;

public class ProductPK implements Serializable{
    private String id;
    private int ep, ss;

    public ProductPK(String id, int ep, int ss) {
        this.id = id;
        this.ep = ep;
        this.ss = ss;
    }

    public ProductPK() {
    }
    
}

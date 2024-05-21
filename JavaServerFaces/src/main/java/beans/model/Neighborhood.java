package beans.model;

public class Neighborhood {
    private int neighborhoodId;
    private String neighborhoodName;
    private int postalCode;

    public Neighborhood() {}

    public Neighborhood (int neighborhoodId, String neighborhoodName, int postalCode){
        this.neighborhoodId = neighborhoodId;
        this.neighborhoodName = neighborhoodName;
        this.postalCode = postalCode;
    }

    public int getNeighborhoodId() {
        return neighborhoodId;
    }

    public void setNeighborhoodId(int neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}

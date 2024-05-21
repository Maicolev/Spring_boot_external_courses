package beans.services;

import beans.model.Neighborhood;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class NeighborhoodService {

    public List <Neighborhood>getNeighborhoods(){
        List<Neighborhood> list = new ArrayList<Neighborhood>();
        Neighborhood neighborhood1 = new Neighborhood(1, "Cansas", 666);
        Neighborhood neighborhood2 = new Neighborhood(2, "London", 668);
        Neighborhood neighborhood3 = new Neighborhood(3, "Seattle", 6667);

        list.add(neighborhood1);
        list.add(neighborhood2);
        list.add(neighborhood3);

        return list;
    }

    public Neighborhood getNeighborhoodIdById(int neighborhoodId){
        Neighborhood neighborhoodFind = null;
        List<Neighborhood> neighborhoods = this.getNeighborhoods();

        for(Neighborhood neighborhood: neighborhoods){
            if(neighborhood.getNeighborhoodId() == neighborhoodId){
                neighborhoodFind = neighborhood;
                break;
            }
        }
        return neighborhoodFind;
    }

    public int getNeighborhoodIdByName(String neighborhoodName){
        int neighborhoodId = 0;
        List<Neighborhood> neighborhoods = this.getNeighborhoods();

        for(Neighborhood neighborhood: neighborhoods){
            if(neighborhood.getNeighborhoodName().equals(neighborhoodName)){
                neighborhoodId = neighborhood.getNeighborhoodId();
                break;
            }
        }
        return neighborhoodId;
    }

    public int getNeighborhoodIdByPC(int postalCode){
        int neighborhoodId = 0;
        List<Neighborhood> neighborhoods = this.getNeighborhoods();
        for(Neighborhood neighborhood: neighborhoods){
            if(neighborhood.getPostalCode() == postalCode){
                neighborhoodId = neighborhood.getNeighborhoodId();
                break;
            }
        }
        return neighborhoodId;
    }

    public List<SelectItem> getSelectItems(){
        List<SelectItem> selectItems = new ArrayList<>();
        List<Neighborhood> neighborhoods = this.getNeighborhoods();
        for(Neighborhood neighborhood: neighborhoods){
            SelectItem selectItem = new SelectItem(neighborhood.getNeighborhoodId(),
                    neighborhood.getNeighborhoodName());
            selectItems.add(selectItem);
        }
        return selectItems;
    }


}

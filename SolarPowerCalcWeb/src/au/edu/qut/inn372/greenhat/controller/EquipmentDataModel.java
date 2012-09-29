package au.edu.qut.inn372.greenhat.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

import au.edu.qut.inn372.greenhat.bean.Equipment;

public class EquipmentDataModel extends ListDataModel<Equipment> implements Serializable, SelectableDataModel<Equipment> {  

    /**
	 * 
	 */
	private static final long serialVersionUID = -1961324370319227557L;

	public EquipmentDataModel() {
    }

    public EquipmentDataModel(List<Equipment> data) {
        super(data);
    }
    
    @Override
    public Equipment getRowData(String rowKey) {
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data
        
        List<Equipment> cars = (List<Equipment>)getWrappedData();
        
        for(Equipment car : cars) {
            if(car.getKitName().equals(rowKey))
                return car;
        }
        
        return null;
    }

    @Override
    public Object getRowKey(Equipment car) {
        return car.getKitName();
    }
}
                    
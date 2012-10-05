package au.edu.qut.inn372.greenhat.controller;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import au.edu.qut.inn372.greenhat.bean.*;

public class CalculatorDataModel extends ListDataModel<Calculator> implements SelectableDataModel<Calculator> {    
  
    public CalculatorDataModel() {  
    }  
  
    public CalculatorDataModel(List<Calculator> data) {  
        super(data);  
    }  
      
    @Override  
    public Calculator getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<Calculator> calculators = (List<Calculator>) getWrappedData();  
          
        for(Calculator calculator : calculators) {  
            if(calculator.getKey().equals(rowKey))  
                return calculator;  
        }  
          
        return null;  
    }  
  
    @Override  
    public Object getRowKey(Calculator calculator) {  
        return calculator.getKey(); 
    }  
}  

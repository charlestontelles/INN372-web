package au.edu.qut.inn372.greenhat.controller;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
@SessionScoped
public class Chart implements Serializable {

	private static final long serialVersionUID = -5553240037289506783L;
	
	private CartesianChartModel costsCategoryModel = new CartesianChartModel();
    private CartesianChartModel savingsCategoryModel = new CartesianChartModel();

    public CartesianChartModel getCostsCategoryModel() {
        return costsCategoryModel;
    }
    
    /**
	 * @param categoryModel the categoryModel to set
	 */
	public void setCostsCategoryModel(CartesianChartModel costsCategoryModel) {
		this.costsCategoryModel = costsCategoryModel;
	}

	/**
	 * @return the categoryModelFinancial
	 */
	public CartesianChartModel getSavingsCategoryModel() {
		return savingsCategoryModel;
	}

	/**
	 * @param categoryModelFinancial the categoryModelFinancial to set
	 */
	public void setSavingsCategoryModel(CartesianChartModel savingsCategoryModel) {
		this.savingsCategoryModel = savingsCategoryModel;
	}
}
                    
                    
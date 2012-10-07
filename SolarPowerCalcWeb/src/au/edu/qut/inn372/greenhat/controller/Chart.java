package au.edu.qut.inn372.greenhat.controller;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
@SessionScoped
public class Chart implements Serializable {

    private CartesianChartModel categoryModelPower;
    private CartesianChartModel categoryModelFinancial;

    public CartesianChartModel getCategoryModelPower() {
        return categoryModelPower;
    }
    
    /**
	 * @param categoryModel the categoryModel to set
	 */
	public void setCategoryModelPower(CartesianChartModel categoryModelPower) {
		this.categoryModelPower = categoryModelPower;
	}

	/**
	 * @return the categoryModelFinancial
	 */
	public CartesianChartModel getCategoryModelFinancial() {
		return categoryModelFinancial;
	}

	/**
	 * @param categoryModelFinancial the categoryModelFinancial to set
	 */
	public void setCategoryModelFinancial(CartesianChartModel categoryModelFinancial) {
		this.categoryModelFinancial = categoryModelFinancial;
	}
}
                    
                    
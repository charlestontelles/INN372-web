package au.edu.qut.inn372.greenhat.controller;

import static org.junit.Assert.*;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChartTest {

	private CartesianChartModel costsCategoryModel;
    private CartesianChartModel savingsCategoryModel;
    private Chart chart;
	
	@Before
	public void setUp() throws Exception {
		savingsCategoryModel = new CartesianChartModel();
		costsCategoryModel = new CartesianChartModel();
		chart = new Chart();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetGetCostCategoryModel() {
		chart.setCostsCategoryModel(costsCategoryModel);
		assertEquals(chart.getCostsCategoryModel(), costsCategoryModel);
	}
	
	@Test
	public void testSetGetSavingsCategoryModel(){
		chart.setSavingsCategoryModel(savingsCategoryModel);
		assertEquals(chart.getSavingsCategoryModel(), savingsCategoryModel);
	}

}

package com.navi.tests;


import com.navi.actions.BaseAction;
import com.navi.core.BrowserInit;
import com.navi.dataprovider.MakeMyTripDataProvider;
import org.testng.annotations.Test;

public class NaviTest extends BrowserInit {

    @Test(testName = "MakeMyTrip count flights",
        dataProvider = "makeMyTripSourceToDestination",
        dataProviderClass = MakeMyTripDataProvider.class)
    public void search_flights(String source, String destination) {
        BaseAction baseAction = new BaseAction()
                .navigateUrl()
                .hasLoaded()
                .enterFromCity(source)
                .enterToCity(destination)
                .search();
    }
}


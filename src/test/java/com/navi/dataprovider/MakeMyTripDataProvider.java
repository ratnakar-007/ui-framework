package com.navi.dataprovider;

import org.testng.annotations.DataProvider;

public class MakeMyTripDataProvider {

    @DataProvider
    public Object[][] makeMyTripSourceToDestination() {
        return new Object[][] {
                {"Delhi", "Bengaluru"},
                {"Delhi", "Jaipur"}
        };
    }
}

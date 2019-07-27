package com.codingblocks.unittesting

object FareUtils
{
     fun calcFare(km: Float, min: Float): Float {
        var fare = 0f
        if (km > 5) fare += (km - 5) * 10
        if (min > 10) fare += (min - 10) * 5
        return fare + 60f


    }
}
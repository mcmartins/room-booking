package com.mcmartins.api;

import java.util.List;
import java.util.Map;

/**
 * Datasource is any kind of driver that loads the data
 *
 * @author Manuel Martins
 */
public interface Datasource {

    /**
     * Reads the datasource and returns the data structure
     *
     * @return map
     */
    Map<Resource, List<BookingInfo>> read();
}

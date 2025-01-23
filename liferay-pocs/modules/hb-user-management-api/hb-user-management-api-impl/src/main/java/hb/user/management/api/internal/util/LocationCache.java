package hb.user.management.api.internal.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.RegionServiceUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationCache {

    private static Map<String, Long> countryMap = new HashMap<>();
    private static Map<String, Map<String, Long>> regionMap = new HashMap<>();

    public static void preloadLocationData() throws PortalException {
        // Preload all countries
        List<Country> countries = CountryServiceUtil.getCountries();
        for (Country country : countries) {
            countryMap.put(country.getName().toLowerCase(), country.getCountryId());
            
            // Preload all regions for each country
            List<Region> regions = RegionServiceUtil.getRegions(country.getCountryId());
            Map<String, Long> stateMap = new HashMap<>();
            for (Region region : regions) {
                stateMap.put(region.getName().toLowerCase(), region.getRegionId());
            }
            regionMap.put(country.getName().toLowerCase(), stateMap);
        }
    }

    public static Long getCountryId(String countryName) {
        return countryMap.get(countryName.toLowerCase());
    }

    public static Long getRegionId(String countryName, String regionName) {
        Map<String, Long> stateMap = regionMap.get(countryName.toLowerCase());
        return (stateMap != null) ? stateMap.get(regionName.toLowerCase()) : null;
    }
}

package com.system.setting.configurable.e1.category;

import com.liferay.configuration.admin.category.ConfigurationCategory;

import org.osgi.service.component.annotations.Component;

@Component(service = ConfigurationCategory.class)
public class AddressInformationConfigurationCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {
		// TODO Auto-generated method stub
		return "address-information-1";
	}

	@Override
	public String getCategorySection() {
		// TODO Auto-generated method stub
		return "address-information-1";
	}
	
	

}

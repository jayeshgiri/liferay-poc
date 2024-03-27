package com.aimdek.insurance.portal.configuration.category;

import org.osgi.service.component.annotations.Component;
import com.liferay.configuration.admin.category.ConfigurationCategory;

/**
 * @author Jeel.Mavani
 */
@Component(service = ConfigurationCategory.class)
public class InsurancePortalConfigurationCategory implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {
		return CATEGORY_KEY;
	}

	@Override
	public String getCategorySection() {
		return CATEGORY_SECTION;
	}

	private static final String CATEGORY_KEY = "insurance-portal-configurations";
	private static final String CATEGORY_SECTION = "rules-configurations";
}

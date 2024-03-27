package com.aimdek.insurance.portal.configuration.bean.declaration;
import com.aimdek.insurance.portal.configuration.configuration.InsurancePortalSalaryRuleConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

/**
 * @author Jeel.Mavani
 */
public class InsurancePortalSalaryRuleConfigurationBeanDeclaration implements ConfigurationPidMapping {
	
	@Override
	public Class<?> getConfigurationBeanClass() {
		return InsurancePortalSalaryRuleConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return "com.aimdek.insurance.portal.configuration.configuration.InsurancePortalConfiguration";
	}
}

package com.aimdek.insurance.portal.configuration.provider;

import com.aimdek.insurance.portal.configuration.configuration.InsurancePortalSalaryRuleConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(configurationPid = "com.aimdek.insurance.portal.configuration.configuration.InsurancePortalConfiguration", enabled = true, immediate = true)
public class InsurancePortalSalaryRuleProvider {
	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		log.info("-----Active InsurancePortalSalaryRuleProvider Configuration Start-----");
		insurancePortalSalaryRuleConfiguration = ConfigurableUtil.createConfigurable(InsurancePortalSalaryRuleConfiguration.class,
				properties);
		setSalaryRule(insurancePortalSalaryRuleConfiguration.getSalaryRule());
		setSalarySlot(insurancePortalSalaryRuleConfiguration.getSalarySlot());
		log.info(insurancePortalSalaryRuleConfiguration.getSalaryRule());
		log.info(insurancePortalSalaryRuleConfiguration.getSalarySlot());
	}
	
	private static String salarySlot;
	private static String salaryRule;
	
	public static String getSalarySlot() {
		return salarySlot;
	}
	public static void setSalarySlot(String salarySlot) {
		InsurancePortalSalaryRuleProvider.salarySlot = salarySlot;
	}
	public static String getSalaryRule() {
		return salaryRule;
	}
	public static void setSalaryRule(String salaryRule) {
		InsurancePortalSalaryRuleProvider.salaryRule = salaryRule;
	}

	private Log log = LogFactoryUtil.getLog(InsurancePortalSalaryRuleProvider.class);
	private volatile InsurancePortalSalaryRuleConfiguration insurancePortalSalaryRuleConfiguration;
	
}

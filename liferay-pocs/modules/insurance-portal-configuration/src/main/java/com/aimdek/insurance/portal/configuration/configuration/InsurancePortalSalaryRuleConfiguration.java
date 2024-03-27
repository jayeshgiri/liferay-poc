package com.aimdek.insurance.portal.configuration.configuration;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Jeel.Mavani
 */

@ExtendedObjectClassDefinition(category = "insurance-portal-configurations", scope = ExtendedObjectClassDefinition.Scope.SYSTEM)
@Meta.OCD(id = "com.aimdek.insurance.portal.configuration.configuration.InsurancePortalConfiguration", localization = "content/Language", name = "salary-rules-configuration-name")
public interface InsurancePortalSalaryRuleConfiguration {
	
	@Meta.AD( name = "salary-slot",required=false,deflt = "5LPA-7LPA")
	public String getSalarySlot();
	
	@Meta.AD( name = "salary-rule",required=false,deflt = "None")
	public String getSalaryRule();
	
}

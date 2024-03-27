package com.poc.school.porlet.web.actions;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.poc.school.porlet.web.constants.PocSchoolPortletWebPortletKeys;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import poc.service.builder.model.School;
import poc.service.builder.service.SchoolLocalService;

@Component(
		immediate = true,
		property = { 
				"javax.portlet.name=" + PocSchoolPortletWebPortletKeys.POCSCHOOLPORTLETWEB,
				"mvc.command.name=/save/schooldetails" 
			},
		service = MVCActionCommand.class
)
public class SaveSchoolDetailsMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		Map<Locale, String> name = LocalizationUtil.getLocalizationMap(actionRequest, "name");
		Map<Locale, String> city = LocalizationUtil.getLocalizationMap(actionRequest, "city");
		Map<Locale, String> address = LocalizationUtil.getLocalizationMap(actionRequest, "address");
		Map<Locale, String> state = LocalizationUtil.getLocalizationMap(actionRequest, "state");
		
		/**
		 * If its not multi language then you can get the value using ParamUtil
		 * long programMasterId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.PROGRAM_MASTER_ID, 0);
		 */
		
		_log.info("name " + name.toString());
		_log.info("city " + city.toString());
		_log.info("address " + address.toString());
		_log.info("state " + state.toString());
		
		long schoolId = counterLocalService.increment(this.getClass().getName());
		
		School school = schoolLocalService.createSchool(schoolId);
		school.setName(name.get(themeDisplay.getLocale()));
		school.setCity(city.get(themeDisplay.getLocale()));
		school.setAddress(address.get(themeDisplay.getLocale()));
		school.setState(state.get(themeDisplay.getLocale()));
		
		/**
		 * If you want to add multi language then make the attribute localized in service builder
		 */
		
		try {
			schoolLocalService.addSchoolDetails(school, themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
		
		_log.info("School Added Successfully schoolId : " + schoolId);
		
		return true;
	}
	
	private Log _log = LogFactoryUtil.getLog(this.getClass());
	
	@Reference
	private SchoolLocalService schoolLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	

}

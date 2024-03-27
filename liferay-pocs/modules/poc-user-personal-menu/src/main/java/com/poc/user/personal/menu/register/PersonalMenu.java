package com.poc.user.personal.menu.register;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.product.navigation.personal.menu.PersonalMenuEntry;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;


/**
 * 
 * @author Jayesh Goswami
 * 
 */

/**
 *  1. This class just listdown the entry in menu User personal menu.
 * 	2. We can set the icon and other properties
 *	3. We can pass the Portlet URL where its deployed.
 */

@Component(
	immediate = true,
	property = {
		
		  "product.navigation.personal.menu.group:Integer=500",
		  "product.navigation.personal.menu.entry.order:Integer=100"
		 
	},
	service = PersonalMenuEntry.class
)
public class PersonalMenu implements PersonalMenuEntry {

	@Override
	public String getLabel(Locale locale) {
		// TODO Auto-generated method stub
		
		return LanguageUtil.get(locale, "personal-menu");
	}

	@Override
	public String getPortletURL(HttpServletRequest httpServletRequest) throws PortalException {
		// TODO Auto-generated method stub
		
		return "http://localhost:8080/personal-menu";
	}

}
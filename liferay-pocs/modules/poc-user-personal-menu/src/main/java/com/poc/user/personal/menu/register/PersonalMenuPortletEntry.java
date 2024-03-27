package com.poc.user.personal.menu.register;

import com.liferay.product.navigation.personal.menu.BasePersonalMenuEntry;
import com.liferay.product.navigation.personal.menu.PersonalMenuEntry;
import com.poc.user.personal.menu.constants.PocUserPersonalMenuPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Jayesh Goswami
 *
 * 1. Register Portlet
 * 2. It will show the porltet name in personal menu 
 */

@Component(
	immediate = true,
	property = {
		"product.navigation.personal.menu.entry.order:Integer=100",
		"product.navigation.personal.menu.group:Integer=500"
	},
	service = PersonalMenuEntry.class
)
public class PersonalMenuPortletEntry extends BasePersonalMenuEntry {

	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		
		return PocUserPersonalMenuPortletKeys.POCUSERPERSONALMENU;
	}

}

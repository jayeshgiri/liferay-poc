package com.poc.custom.panel.app.application.list;

import com.poc.custom.panel.app.constants.PocCustomPanelAppPanelCategoryKeys;
import com.poc.custom.panel.app.constants.PocCustomPanelAppPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jayesh Goswami
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + PocCustomPanelAppPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class PocCustomPanelAppPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return PocCustomPanelAppPortletKeys.POCCUSTOMPANELAPP;
	}

	@Reference(
		target = "(javax.portlet.name=" + PocCustomPanelAppPortletKeys.POCCUSTOMPANELAPP + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		this.portlet = portlet;
	}

	@Override
	public Portlet getPortlet() {
		// TODO Auto-generated method stub
		return portlet;
	}
	
	private Portlet portlet;
}
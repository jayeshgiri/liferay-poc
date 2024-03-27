package poc.rule.engine.drool.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import poc.rule.engine.drool.constants.PocRuleEngineDroolPortletKeys;
import poc.rule.engine.drool.custom.DroolsExample;

/**
 * @author Jayesh Goswami
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PocRuleEngineDrool",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + PocRuleEngineDroolPortletKeys.POCRULEENGINEDROOL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PocRuleEngineDroolPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		_log.info("PocRuleEngineDroolPortlet ::: render");
		
		DroolsExample droolsExample = new DroolsExample();
		droolsExample.executeDrools();
		
		super.render(renderRequest, renderResponse);
	}
	
	private Log _log = LogFactoryUtil.getLog(this.getClass());
}
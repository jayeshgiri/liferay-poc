package poc.custom.jsp.bag.update.passowrd;

import com.liferay.portal.custom.jsp.bag.BaseCustomJspBag;
import com.liferay.portal.deploy.hot.CustomJspBag;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jayesh Goswami
 */
@Component(
	immediate = true,
	property = {
			"context.id=poc.custom.jsp.bag.update.passowrd.PocCustomJspBagUpdatePassowrd",
			"context.name=Update Custom JSP Bag",
	    	"service.ranking:Integer=100"
	},
	service = CustomJspBag.class


)
public class PocCustomJspBagUpdatePassowrd extends BaseCustomJspBag	 {

	@Override
	public String getCustomJspDir() {
		return "META-INF/custom_jsps";
	}
}
package liferay.jwt.custom.token.internal.resource.v1_0;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import liferay.jwt.custom.token.dto.v1_0.HelloResponse;
import liferay.jwt.custom.token.resource.v1_0.HelloResponseResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author JayeshGoswami
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/hello-response.properties",
        scope = ServiceScope.PROTOTYPE, service = HelloResponseResource.class
)
public class HelloResponseResourceImpl extends BaseHelloResponseResourceImpl {

//    @Override
//    public HelloResponse getHello() {
//        HelloResponse response = new HelloResponse();
//        response.setMessage("Hello "); // Change this to your desired message
//        return response;
//    }

    @Override
    public HelloResponse getHello() {
        HelloResponse response = new HelloResponse();
        String userName = "Guest";

        try {


            long userId = ServiceContextThreadLocal.getServiceContext().getUserId();

            User user = UserLocalServiceUtil.getUserById(userId);

            if (user != null) {
                userName = user.getFullName();
            }
        } catch (PrincipalException e){
            System.out.println("Hello PrincipalException");
            e.printStackTrace();
        } catch (PortalException e) {
            System.out.println("Hello PortalException");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Hello NullPointerException");
            e.printStackTrace();
        }

        response.setMessage("Hello " + userName);
        return response;
    }
}
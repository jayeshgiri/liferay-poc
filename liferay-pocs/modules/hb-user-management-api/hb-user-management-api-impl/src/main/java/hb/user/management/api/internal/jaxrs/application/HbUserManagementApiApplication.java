package hb.user.management.api.internal.jaxrs.application;

import javax.annotation.Generated;

import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;

/**
 * @author JayeshGoswami
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/hb-user-management-api",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=HbUserManagementApi"
	},
	service = Application.class
)
@Generated("")
public class HbUserManagementApiApplication extends Application {
}
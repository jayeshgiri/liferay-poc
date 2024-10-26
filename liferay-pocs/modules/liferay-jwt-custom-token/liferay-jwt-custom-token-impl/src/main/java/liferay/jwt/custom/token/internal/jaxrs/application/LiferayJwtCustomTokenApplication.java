package liferay.jwt.custom.token.internal.jaxrs.application;

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
		"osgi.jaxrs.application.base=/liferay-jwt-custom-token",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=LiferayJwtCustomToken"
	},
	service = Application.class
)
@Generated("")
public class LiferayJwtCustomTokenApplication extends Application {
}
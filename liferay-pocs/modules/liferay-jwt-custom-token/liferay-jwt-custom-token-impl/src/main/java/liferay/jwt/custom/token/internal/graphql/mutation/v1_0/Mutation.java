package liferay.jwt.custom.token.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import liferay.jwt.custom.token.dto.v1_0.JWTTokenRequest;
import liferay.jwt.custom.token.dto.v1_0.JWTTokenResponse;
import liferay.jwt.custom.token.resource.v1_0.JWTTokenResponseResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setJWTTokenResponseResourceComponentServiceObjects(
		ComponentServiceObjects<JWTTokenResponseResource>
			jwtTokenResponseResourceComponentServiceObjects) {

		_jwtTokenResponseResourceComponentServiceObjects =
			jwtTokenResponseResourceComponentServiceObjects;
	}

	@GraphQLField
	public JWTTokenResponse getDecodedJwtToken(
			@GraphQLName("jwtTokenRequest") JWTTokenRequest jwtTokenRequest)
		throws Exception {

		return _applyComponentServiceObjects(
			_jwtTokenResponseResourceComponentServiceObjects,
			this::_populateResourceContext,
			jwtTokenResponseResource ->
				jwtTokenResponseResource.getDecodedJwtToken(jwtTokenRequest));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			JWTTokenResponseResource jwtTokenResponseResource)
		throws Exception {

		jwtTokenResponseResource.setContextAcceptLanguage(_acceptLanguage);
		jwtTokenResponseResource.setContextCompany(_company);
		jwtTokenResponseResource.setContextHttpServletRequest(
			_httpServletRequest);
		jwtTokenResponseResource.setContextHttpServletResponse(
			_httpServletResponse);
		jwtTokenResponseResource.setContextUriInfo(_uriInfo);
		jwtTokenResponseResource.setContextUser(_user);
		jwtTokenResponseResource.setGroupLocalService(_groupLocalService);
		jwtTokenResponseResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<JWTTokenResponseResource>
		_jwtTokenResponseResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}
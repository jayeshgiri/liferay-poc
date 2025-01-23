package hb.user.management.api.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import hb.user.management.api.dto.v1_0.HBOrganizationOnboardedRequest;
import hb.user.management.api.dto.v1_0.HBOrganizationOnboardedResponse;
import hb.user.management.api.dto.v1_0.HBUser;
import hb.user.management.api.dto.v1_0.UserCreationResponse;
import hb.user.management.api.resource.v1_0.HBOrganizationOnboardedResponseResource;
import hb.user.management.api.resource.v1_0.UserCreationResponseResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class Mutation {

	public static void
		setHBOrganizationOnboardedResponseResourceComponentServiceObjects(
			ComponentServiceObjects<HBOrganizationOnboardedResponseResource>
				hbOrganizationOnboardedResponseResourceComponentServiceObjects) {

		_hbOrganizationOnboardedResponseResourceComponentServiceObjects =
			hbOrganizationOnboardedResponseResourceComponentServiceObjects;
	}

	public static void setUserCreationResponseResourceComponentServiceObjects(
		ComponentServiceObjects<UserCreationResponseResource>
			userCreationResponseResourceComponentServiceObjects) {

		_userCreationResponseResourceComponentServiceObjects =
			userCreationResponseResourceComponentServiceObjects;
	}

	@GraphQLField
	public HBOrganizationOnboardedResponse updateOrganizationOnboardingStatus(
			@GraphQLName("hbOrganizationOnboardedRequest")
				HBOrganizationOnboardedRequest hbOrganizationOnboardedRequest)
		throws Exception {

		return _applyComponentServiceObjects(
			_hbOrganizationOnboardedResponseResourceComponentServiceObjects,
			this::_populateResourceContext,
			hbOrganizationOnboardedResponseResource ->
				hbOrganizationOnboardedResponseResource.
					updateOrganizationOnboardingStatus(
						hbOrganizationOnboardedRequest));
	}

	@GraphQLField
	public java.util.Collection<UserCreationResponse> createUsers(
			@GraphQLName("hbUsers") HBUser[] hbUsers)
		throws Exception {

		return _applyComponentServiceObjects(
			_userCreationResponseResourceComponentServiceObjects,
			this::_populateResourceContext,
			userCreationResponseResource -> {
				Page paginationPage = userCreationResponseResource.createUsers(
					hbUsers);

				return paginationPage.getItems();
			});
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
			HBOrganizationOnboardedResponseResource
				hbOrganizationOnboardedResponseResource)
		throws Exception {

		hbOrganizationOnboardedResponseResource.setContextAcceptLanguage(
			_acceptLanguage);
		hbOrganizationOnboardedResponseResource.setContextCompany(_company);
		hbOrganizationOnboardedResponseResource.setContextHttpServletRequest(
			_httpServletRequest);
		hbOrganizationOnboardedResponseResource.setContextHttpServletResponse(
			_httpServletResponse);
		hbOrganizationOnboardedResponseResource.setContextUriInfo(_uriInfo);
		hbOrganizationOnboardedResponseResource.setContextUser(_user);
		hbOrganizationOnboardedResponseResource.setGroupLocalService(
			_groupLocalService);
		hbOrganizationOnboardedResponseResource.setRoleLocalService(
			_roleLocalService);
	}

	private void _populateResourceContext(
			UserCreationResponseResource userCreationResponseResource)
		throws Exception {

		userCreationResponseResource.setContextAcceptLanguage(_acceptLanguage);
		userCreationResponseResource.setContextCompany(_company);
		userCreationResponseResource.setContextHttpServletRequest(
			_httpServletRequest);
		userCreationResponseResource.setContextHttpServletResponse(
			_httpServletResponse);
		userCreationResponseResource.setContextUriInfo(_uriInfo);
		userCreationResponseResource.setContextUser(_user);
		userCreationResponseResource.setGroupLocalService(_groupLocalService);
		userCreationResponseResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects
		<HBOrganizationOnboardedResponseResource>
			_hbOrganizationOnboardedResponseResourceComponentServiceObjects;
	private static ComponentServiceObjects<UserCreationResponseResource>
		_userCreationResponseResourceComponentServiceObjects;

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
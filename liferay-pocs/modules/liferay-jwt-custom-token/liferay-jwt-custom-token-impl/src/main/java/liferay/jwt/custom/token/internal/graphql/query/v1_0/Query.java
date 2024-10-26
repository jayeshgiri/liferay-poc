package liferay.jwt.custom.token.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import liferay.jwt.custom.token.dto.v1_0.HelloResponse;
import liferay.jwt.custom.token.dto.v1_0.JWTTokenResponse;
import liferay.jwt.custom.token.resource.v1_0.HelloResponseResource;
import liferay.jwt.custom.token.resource.v1_0.JWTTokenResponseResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class Query {

	public static void setHelloResponseResourceComponentServiceObjects(
		ComponentServiceObjects<HelloResponseResource>
			helloResponseResourceComponentServiceObjects) {

		_helloResponseResourceComponentServiceObjects =
			helloResponseResourceComponentServiceObjects;
	}

	public static void setJWTTokenResponseResourceComponentServiceObjects(
		ComponentServiceObjects<JWTTokenResponseResource>
			jwtTokenResponseResourceComponentServiceObjects) {

		_jwtTokenResponseResourceComponentServiceObjects =
			jwtTokenResponseResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {hello{message}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public HelloResponse hello() throws Exception {
		return _applyComponentServiceObjects(
			_helloResponseResourceComponentServiceObjects,
			this::_populateResourceContext,
			helloResponseResource -> helloResponseResource.getHello());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {jwtToken{jwtToken}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public JWTTokenResponse jwtToken() throws Exception {
		return _applyComponentServiceObjects(
			_jwtTokenResponseResourceComponentServiceObjects,
			this::_populateResourceContext,
			jwtTokenResponseResource -> jwtTokenResponseResource.getJwtToken());
	}

	@GraphQLName("HelloResponsePage")
	public class HelloResponsePage {

		public HelloResponsePage(Page helloResponsePage) {
			actions = helloResponsePage.getActions();

			items = helloResponsePage.getItems();
			lastPage = helloResponsePage.getLastPage();
			page = helloResponsePage.getPage();
			pageSize = helloResponsePage.getPageSize();
			totalCount = helloResponsePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<HelloResponse> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("JWTTokenResponsePage")
	public class JWTTokenResponsePage {

		public JWTTokenResponsePage(Page jwtTokenResponsePage) {
			actions = jwtTokenResponsePage.getActions();

			items = jwtTokenResponsePage.getItems();
			lastPage = jwtTokenResponsePage.getLastPage();
			page = jwtTokenResponsePage.getPage();
			pageSize = jwtTokenResponsePage.getPageSize();
			totalCount = jwtTokenResponsePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<JWTTokenResponse> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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

	private void _populateResourceContext(
			HelloResponseResource helloResponseResource)
		throws Exception {

		helloResponseResource.setContextAcceptLanguage(_acceptLanguage);
		helloResponseResource.setContextCompany(_company);
		helloResponseResource.setContextHttpServletRequest(_httpServletRequest);
		helloResponseResource.setContextHttpServletResponse(
			_httpServletResponse);
		helloResponseResource.setContextUriInfo(_uriInfo);
		helloResponseResource.setContextUser(_user);
		helloResponseResource.setGroupLocalService(_groupLocalService);
		helloResponseResource.setRoleLocalService(_roleLocalService);
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

	private static ComponentServiceObjects<HelloResponseResource>
		_helloResponseResourceComponentServiceObjects;
	private static ComponentServiceObjects<JWTTokenResponseResource>
		_jwtTokenResponseResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}
package liferay.jwt.custom.token.internal.graphql.servlet.v1_0;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import liferay.jwt.custom.token.internal.graphql.mutation.v1_0.Mutation;
import liferay.jwt.custom.token.internal.graphql.query.v1_0.Query;
import liferay.jwt.custom.token.internal.resource.v1_0.HelloResponseResourceImpl;
import liferay.jwt.custom.token.internal.resource.v1_0.JWTTokenResponseResourceImpl;
import liferay.jwt.custom.token.resource.v1_0.HelloResponseResource;
import liferay.jwt.custom.token.resource.v1_0.JWTTokenResponseResource;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author JayeshGoswami
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setJWTTokenResponseResourceComponentServiceObjects(
			_jwtTokenResponseResourceComponentServiceObjects);

		Query.setHelloResponseResourceComponentServiceObjects(
			_helloResponseResourceComponentServiceObjects);
		Query.setJWTTokenResponseResourceComponentServiceObjects(
			_jwtTokenResponseResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "LiferayJwtCustomToken";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/liferay-jwt-custom-token-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#getDecodedJwtToken",
						new ObjectValuePair<>(
							JWTTokenResponseResourceImpl.class,
							"getDecodedJwtToken"));

					put(
						"query#hello",
						new ObjectValuePair<>(
							HelloResponseResourceImpl.class, "getHello"));
					put(
						"query#jwtToken",
						new ObjectValuePair<>(
							JWTTokenResponseResourceImpl.class, "getJwtToken"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<JWTTokenResponseResource>
		_jwtTokenResponseResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<HelloResponseResource>
		_helloResponseResourceComponentServiceObjects;

}
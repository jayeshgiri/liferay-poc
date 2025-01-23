package hb.user.management.api.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import hb.user.management.api.internal.graphql.mutation.v1_0.Mutation;
import hb.user.management.api.internal.graphql.query.v1_0.Query;
import hb.user.management.api.resource.v1_0.HBOrganizationOnboardedResponseResource;
import hb.user.management.api.resource.v1_0.UserCreationResponseResource;

import javax.annotation.Generated;

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
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.
			setHBOrganizationOnboardedResponseResourceComponentServiceObjects(
				_hbOrganizationOnboardedResponseResourceComponentServiceObjects);
		Mutation.setUserCreationResponseResourceComponentServiceObjects(
			_userCreationResponseResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/hb-user-management-api-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<HBOrganizationOnboardedResponseResource>
		_hbOrganizationOnboardedResponseResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<UserCreationResponseResource>
		_userCreationResponseResourceComponentServiceObjects;

}
package hb.user.management.api.internal.resource.v1_0;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import hb.user.management.api.dto.v1_0.HBOrganizationOnboardedRequest;
import hb.user.management.api.dto.v1_0.HBOrganizationOnboardedResponse;
import hb.user.management.api.resource.v1_0.HBOrganizationOnboardedResponseResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;

/**
 * @author JayeshGoswami
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/hb-organization-onboarded-response.properties",
	scope = ServiceScope.PROTOTYPE,
	service = HBOrganizationOnboardedResponseResource.class
)
public class HBOrganizationOnboardedResponseResourceImpl
	extends BaseHBOrganizationOnboardedResponseResourceImpl {
	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<HBOrganizationOnboardedResponse>, UnsafeFunction<HBOrganizationOnboardedResponse, HBOrganizationOnboardedResponse, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}

	@Override
	public HBOrganizationOnboardedResponse updateOrganizationOnboardingStatus(HBOrganizationOnboardedRequest hbOrganizationOnboardedRequest) throws Exception {
		HBOrganizationOnboardedResponse response = new HBOrganizationOnboardedResponse();
		try {
			// Retrieve the organization
			Organization organization = OrganizationLocalServiceUtil.getOrganization(hbOrganizationOnboardedRequest.getOrganizationId());

			// Define company ID, class name, and table name for Expando
			long companyId = organization.getCompanyId();
			String className = Organization.class.getName();
			String tableName = ExpandoTableConstants.DEFAULT_TABLE_NAME;
			String expandoFieldName = "Is Org Onboarded ?";
			boolean fieldValue = hbOrganizationOnboardedRequest.getIsOnboarded();
			// Get the Expando Table
			ExpandoTable expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, className);

			// Get the Expando Column (field) - assumes field already exists
			ExpandoColumn expandoColumn = ExpandoColumnLocalServiceUtil.getColumn(expandoTable.getTableId(), expandoFieldName);

			// Update the Expando field value for the organization
			ExpandoValueLocalServiceUtil.addValue(
					companyId,
					className,
					tableName,
					expandoFieldName,
					organization.getOrganizationId(),
					fieldValue
			);

			_log.info("Expando field '" + expandoFieldName + "' updated to '" + fieldValue + "' for organization " + organization.getOrganizationId());

			response.setStatus("Success");
			response.setOrganizationId((int) organization.getOrganizationId());
			response.setMessage("Organization " + organization.getOrganizationId() + " updated to " + fieldValue);
		} catch (PortalException e) {
			_log.error("Error updating Expando field for organization: " + e.getMessage());
			response.setStatus("Failed");
			response.setOrganizationId(hbOrganizationOnboardedRequest.getOrganizationId());
			response.setMessage(e.getMessage());
		}
		return response;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
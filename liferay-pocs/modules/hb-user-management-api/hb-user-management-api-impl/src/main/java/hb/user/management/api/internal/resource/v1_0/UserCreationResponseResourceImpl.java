package hb.user.management.api.internal.resource.v1_0;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.vulcan.pagination.Page;
import hb.user.management.api.dto.v1_0.CustomAddress;
import hb.user.management.api.dto.v1_0.CustomFields;
import hb.user.management.api.dto.v1_0.HBUser;
import hb.user.management.api.dto.v1_0.UserCreationResponse;
import hb.user.management.api.internal.util.LocationCache;
import hb.user.management.api.resource.v1_0.UserCreationResponseResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.io.Serializable;
import java.util.*;

/**
 * @author JayeshGoswami
 */
@Component(
        properties = "OSGI-INF/liferay/rest/v1_0/user-creation-response.properties",
        scope = ServiceScope.PROTOTYPE, service = UserCreationResponseResource.class
)
public class UserCreationResponseResourceImpl
        extends BaseUserCreationResponseResourceImpl {
    @Override
    public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<UserCreationResponse>, UnsafeFunction<UserCreationResponse, UserCreationResponse, Exception>, Exception> contextBatchUnsafeBiConsumer) {

    }

    @Override
    public Page<UserCreationResponse> createUsers(HBUser[] hbUsers) throws Exception {
        List<UserCreationResponse> responseList = new ArrayList<>();
        ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
        long userId = 20122; //serviceContext.getUserId();

        long companyId = CompanyThreadLocal.getCompanyId();
        long groupId = GroupLocalServiceUtil.getGroup(companyId, "Guest").getGroupId();
        User user = UserLocalServiceUtil.getUserById(userId);

        LocationCache.preloadLocationData();

        for (HBUser hbUser : hbUsers) {

            UserCreationResponse userResponse = new UserCreationResponse();
            userResponse.setEmailAddress(hbUser.getEmailAddress());

            try {
                boolean isCreated = true;
                // Create User in Liferay
                Calendar calendar = Calendar.getInstance();
                int birthdayYear = calendar.get(Calendar.YEAR);
                int birthdayMonth = calendar.get(Calendar.MONTH);
                int birthdayDay = calendar.get(Calendar.DAY_OF_MONTH);
                boolean sex = "female".equalsIgnoreCase(hbUser.getSex());

                // Create Liferay User
                List<Integer> roleIds = List.of(hbUser.getRoleIds());
                User lrUser = userLocalService.fetchUserByEmailAddress(user.getCompanyId(), hbUser.getEmailAddress());
                if (Validator.isNull(lrUser)) {
                    lrUser = userLocalService.addUser(user.getUserId(), user.getCompanyId(), true,
                            StringPool.BLANK, StringPool.BLANK, true, StringPool.BLANK, hbUser.getEmailAddress(),
                            user.getLocale(), hbUser.getFirstName(), hbUser.getMiddleName(), hbUser.getLastName(), 0L, 0L, sex,
                            birthdayMonth, birthdayDay, birthdayYear, hbUser.getJobTitle(), 1, null, new long[]{hbUser.getOrganizationId().longValue()},
                            roleIds.stream().mapToLong(Integer::longValue).toArray(), null, true, new ServiceContext());

                } else {
                    lrUser = userLocalService.updateUser(lrUser.getUserId(), StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, false,
                            StringPool.BLANK, StringPool.BLANK, lrUser.getScreenName(), hbUser.getEmailAddress(), false, null,
                            lrUser.getLanguageId(), lrUser.getTimeZoneId(), lrUser.getGreeting(), lrUser.getComments(), hbUser.getFirstName(), hbUser.getMiddleName(),
                            hbUser.getLastName(), 0l, 0l, sex, birthdayMonth, birthdayDay, birthdayYear,
                            StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, hbUser.getJobTitle(), lrUser.getGroupIds(),
                            lrUser.getOrganizationIds(), lrUser.getRoleIds(), null, lrUser.getUserGroupIds(), new ServiceContext());
                    isCreated = false;
                }

                // Deactivate User
                if (Validator.isNotNull(lrUser)) {
                    if (!hbUser.getIsActive()) {
                        deactivateUser(lrUser);
                    }
                }

                 // Set custom fields
                CustomFields customFields = hbUser.getCustomFields();
                ExpandoBridge expandoBridge = lrUser.getExpandoBridge();
                setCustomFields(expandoBridge, hbUser);


                // Assign the user to the specified site
                assignUsersToSite(lrUser.getUserId(), lrUser.getEmailAddress(), groupId, "Guest");
                userResponse.setStatus(isCreated ? "Created" : "Updated");

            } catch (Exception e) {
                // In case of failure, capture the error message and status
                _log.error(e.getMessage());
                userResponse.setStatus("Failed");
                userResponse.setMessage(e.getMessage());
            }
            responseList.add(userResponse);
        }
        return Page.of(responseList);
    }

    private void setCustomFields(ExpandoBridge expandoBridge, HBUser hbUser){
        CustomFields customFields = hbUser.getCustomFields();
        CustomAddress  customAddress = hbUser.getAddress();
        expandoBridge.setAttribute("City", customAddress.getCity());
        expandoBridge.setAttribute("County", customAddress.getCountry());
        expandoBridge.setAttribute("State", customAddress.getState());
        expandoBridge.setAttribute("Zipcode", customAddress.getPostalCode());
        if(Validator.isNotNull(customFields)) {
            expandoBridge.setAttribute("Employee ID", customFields.getEmployeeId());
            expandoBridge.setAttribute("Relationship", customFields.getRelationship());
            expandoBridge.setAttribute("Employee Department", customFields.getEmployeeDepartment());
            expandoBridge.setAttribute("Employee Class", customFields.getEmployeeClass());
            expandoBridge.setAttribute("Hire Date", customFields.getHireDate());
            expandoBridge.setAttribute("Scheduled Hours", customFields.getScheduledHours());
            expandoBridge.setAttribute("Pharmacy Benefits", customFields.getPharmacyBenefits());
            expandoBridge.setAttribute("Plan", customFields.getPlan());
            expandoBridge.setAttribute("Benefits Effective Date", customFields.getBenefitsEffectiveDate());
            expandoBridge.setAttribute("Medical Coverage", customFields.getMedicalCoverage());
            expandoBridge.setAttribute("coverageLevel", customFields.getCoverageLevel());
        }


    }

    public void assignUsersToSite(long userId, String email, long groupId, String siteName) throws PortalException {
        try {
            // Add the user to the site
            UserLocalServiceUtil.addGroupUsers(groupId, new long[]{userId});
            _log.info("User :" + userId + "  email : " + email + " has been successfully assigned to site " + siteName);

        } catch (PortalException e) {
            _log.error("User :" + userId + "  email : " + email + " has been successfully assigned to site " + siteName);
            _log.error("User :" + userId + "  email : " + email + " Error assigning user to site: " + e.getMessage());
            throw e;
        }
    }

    public void deactivateUser(User lrUser) throws PortalException {
        try {
            // Retrieve the user
            User user = UserLocalServiceUtil.getUser(lrUser.getUserId());

            // Update the user status to inactive
            UserLocalServiceUtil.updateStatus(
                    user.getUserId(),
                    WorkflowConstants.STATUS_INACTIVE,   // Set status to inactive
                    new ServiceContext()                 // Optional, customize as needed
            );

            _log.info("User " + lrUser.getEmailAddress() + " has been successfully deactivated.");

        } catch (PortalException e) {
            _log.error("Error deactivating user: " + lrUser.getEmailAddress());
            throw e;
        }
    }

    @Reference
    UserLocalService userLocalService;

    @Reference
    AddressLocalService addressLocalService;

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
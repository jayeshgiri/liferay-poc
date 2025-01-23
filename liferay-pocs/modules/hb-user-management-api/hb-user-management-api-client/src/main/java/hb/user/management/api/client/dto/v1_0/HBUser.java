package hb.user.management.api.client.dto.v1_0;

import hb.user.management.api.client.dto.v1_0.CustomAddress;
import hb.user.management.api.client.dto.v1_0.CustomFields;
import hb.user.management.api.client.function.UnsafeSupplier;
import hb.user.management.api.client.serdes.v1_0.HBUserSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class HBUser implements Cloneable, Serializable {

	public static HBUser toDTO(String json) {
		return HBUserSerDes.toDTO(json);
	}

	public CustomAddress getAddress() {
		return address;
	}

	public void setAddress(CustomAddress address) {
		this.address = address;
	}

	public void setAddress(
		UnsafeSupplier<CustomAddress, Exception> addressUnsafeSupplier) {

		try {
			address = addressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected CustomAddress address;

	public CustomFields getCustomFields() {
		return customFields;
	}

	public void setCustomFields(CustomFields customFields) {
		this.customFields = customFields;
	}

	public void setCustomFields(
		UnsafeSupplier<CustomFields, Exception> customFieldsUnsafeSupplier) {

		try {
			customFields = customFieldsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected CustomFields customFields;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setEmailAddress(
		UnsafeSupplier<String, Exception> emailAddressUnsafeSupplier) {

		try {
			emailAddress = emailAddressUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String emailAddress;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFirstName(
		UnsafeSupplier<String, Exception> firstNameUnsafeSupplier) {

		try {
			firstName = firstNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String firstName;

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setIsActive(
		UnsafeSupplier<Boolean, Exception> isActiveUnsafeSupplier) {

		try {
			isActive = isActiveUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isActive;

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setJobTitle(
		UnsafeSupplier<String, Exception> jobTitleUnsafeSupplier) {

		try {
			jobTitle = jobTitleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String jobTitle;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLastName(
		UnsafeSupplier<String, Exception> lastNameUnsafeSupplier) {

		try {
			lastName = lastNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String lastName;

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setMiddleName(
		UnsafeSupplier<String, Exception> middleNameUnsafeSupplier) {

		try {
			middleName = middleNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String middleName;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public void setOrganizationId(
		UnsafeSupplier<Integer, Exception> organizationIdUnsafeSupplier) {

		try {
			organizationId = organizationIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer organizationId;

	public Integer[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}

	public void setRoleIds(
		UnsafeSupplier<Integer[], Exception> roleIdsUnsafeSupplier) {

		try {
			roleIds = roleIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer[] roleIds;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setSex(UnsafeSupplier<String, Exception> sexUnsafeSupplier) {
		try {
			sex = sexUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String sex;

	@Override
	public HBUser clone() throws CloneNotSupportedException {
		return (HBUser)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HBUser)) {
			return false;
		}

		HBUser hbUser = (HBUser)object;

		return Objects.equals(toString(), hbUser.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return HBUserSerDes.toJSON(this);
	}

}
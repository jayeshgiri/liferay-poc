package hb.user.management.api.client.dto.v1_0;

import hb.user.management.api.client.function.UnsafeSupplier;
import hb.user.management.api.client.serdes.v1_0.HBOrganizationOnboardedRequestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class HBOrganizationOnboardedRequest implements Cloneable, Serializable {

	public static HBOrganizationOnboardedRequest toDTO(String json) {
		return HBOrganizationOnboardedRequestSerDes.toDTO(json);
	}

	public Boolean getIsOnboarded() {
		return isOnboarded;
	}

	public void setIsOnboarded(Boolean isOnboarded) {
		this.isOnboarded = isOnboarded;
	}

	public void setIsOnboarded(
		UnsafeSupplier<Boolean, Exception> isOnboardedUnsafeSupplier) {

		try {
			isOnboarded = isOnboardedUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isOnboarded;

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

	@Override
	public HBOrganizationOnboardedRequest clone()
		throws CloneNotSupportedException {

		return (HBOrganizationOnboardedRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HBOrganizationOnboardedRequest)) {
			return false;
		}

		HBOrganizationOnboardedRequest hbOrganizationOnboardedRequest =
			(HBOrganizationOnboardedRequest)object;

		return Objects.equals(
			toString(), hbOrganizationOnboardedRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return HBOrganizationOnboardedRequestSerDes.toJSON(this);
	}

}
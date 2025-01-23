package hb.user.management.api.client.dto.v1_0;

import hb.user.management.api.client.function.UnsafeSupplier;
import hb.user.management.api.client.serdes.v1_0.HBOrganizationOnboardedResponseSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class HBOrganizationOnboardedResponse
	implements Cloneable, Serializable {

	public static HBOrganizationOnboardedResponse toDTO(String json) {
		return HBOrganizationOnboardedResponseSerDes.toDTO(json);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(
		UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String message;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<String, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String status;

	@Override
	public HBOrganizationOnboardedResponse clone()
		throws CloneNotSupportedException {

		return (HBOrganizationOnboardedResponse)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HBOrganizationOnboardedResponse)) {
			return false;
		}

		HBOrganizationOnboardedResponse hbOrganizationOnboardedResponse =
			(HBOrganizationOnboardedResponse)object;

		return Objects.equals(
			toString(), hbOrganizationOnboardedResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return HBOrganizationOnboardedResponseSerDes.toJSON(this);
	}

}
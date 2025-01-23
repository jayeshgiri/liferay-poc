package hb.user.management.api.client.dto.v1_0;

import hb.user.management.api.client.function.UnsafeSupplier;
import hb.user.management.api.client.serdes.v1_0.CustomAddressSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class CustomAddress implements Cloneable, Serializable {

	public static CustomAddress toDTO(String json) {
		return CustomAddressSerDes.toDTO(json);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCity(UnsafeSupplier<String, Exception> cityUnsafeSupplier) {
		try {
			city = cityUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String city;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCountry(
		UnsafeSupplier<String, Exception> countryUnsafeSupplier) {

		try {
			country = countryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String country;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setPostalCode(
		UnsafeSupplier<String, Exception> postalCodeUnsafeSupplier) {

		try {
			postalCode = postalCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String postalCode;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setState(
		UnsafeSupplier<String, Exception> stateUnsafeSupplier) {

		try {
			state = stateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String state;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setStreet(
		UnsafeSupplier<String, Exception> streetUnsafeSupplier) {

		try {
			street = streetUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String street;

	@Override
	public CustomAddress clone() throws CloneNotSupportedException {
		return (CustomAddress)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustomAddress)) {
			return false;
		}

		CustomAddress customAddress = (CustomAddress)object;

		return Objects.equals(toString(), customAddress.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CustomAddressSerDes.toJSON(this);
	}

}
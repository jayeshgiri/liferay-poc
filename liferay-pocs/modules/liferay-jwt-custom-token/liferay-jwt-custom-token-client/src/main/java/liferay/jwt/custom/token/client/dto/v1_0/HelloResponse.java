package liferay.jwt.custom.token.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import liferay.jwt.custom.token.client.function.UnsafeSupplier;
import liferay.jwt.custom.token.client.serdes.v1_0.HelloResponseSerDes;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class HelloResponse implements Cloneable, Serializable {

	public static HelloResponse toDTO(String json) {
		return HelloResponseSerDes.toDTO(json);
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

	@Override
	public HelloResponse clone() throws CloneNotSupportedException {
		return (HelloResponse)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HelloResponse)) {
			return false;
		}

		HelloResponse helloResponse = (HelloResponse)object;

		return Objects.equals(toString(), helloResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return HelloResponseSerDes.toJSON(this);
	}

}
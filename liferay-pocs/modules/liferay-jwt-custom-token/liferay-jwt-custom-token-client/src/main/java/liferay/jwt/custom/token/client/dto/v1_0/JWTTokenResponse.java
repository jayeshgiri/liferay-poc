package liferay.jwt.custom.token.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import liferay.jwt.custom.token.client.function.UnsafeSupplier;
import liferay.jwt.custom.token.client.serdes.v1_0.JWTTokenResponseSerDes;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class JWTTokenResponse implements Cloneable, Serializable {

	public static JWTTokenResponse toDTO(String json) {
		return JWTTokenResponseSerDes.toDTO(json);
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public void setJwtToken(
		UnsafeSupplier<String, Exception> jwtTokenUnsafeSupplier) {

		try {
			jwtToken = jwtTokenUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String jwtToken;

	@Override
	public JWTTokenResponse clone() throws CloneNotSupportedException {
		return (JWTTokenResponse)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JWTTokenResponse)) {
			return false;
		}

		JWTTokenResponse jwtTokenResponse = (JWTTokenResponse)object;

		return Objects.equals(toString(), jwtTokenResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return JWTTokenResponseSerDes.toJSON(this);
	}

}
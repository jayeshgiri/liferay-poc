package liferay.jwt.custom.token.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import liferay.jwt.custom.token.client.function.UnsafeSupplier;
import liferay.jwt.custom.token.client.serdes.v1_0.JWTTokenRequestSerDes;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class JWTTokenRequest implements Cloneable, Serializable {

	public static JWTTokenRequest toDTO(String json) {
		return JWTTokenRequestSerDes.toDTO(json);
	}

	public String getEncodedToken() {
		return encodedToken;
	}

	public void setEncodedToken(String encodedToken) {
		this.encodedToken = encodedToken;
	}

	public void setEncodedToken(
		UnsafeSupplier<String, Exception> encodedTokenUnsafeSupplier) {

		try {
			encodedToken = encodedTokenUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String encodedToken;

	@Override
	public JWTTokenRequest clone() throws CloneNotSupportedException {
		return (JWTTokenRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof JWTTokenRequest)) {
			return false;
		}

		JWTTokenRequest jwtTokenRequest = (JWTTokenRequest)object;

		return Objects.equals(toString(), jwtTokenRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return JWTTokenRequestSerDes.toJSON(this);
	}

}
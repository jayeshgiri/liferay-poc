package liferay.jwt.custom.token.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import liferay.jwt.custom.token.client.dto.v1_0.JWTTokenResponse;
import liferay.jwt.custom.token.client.json.BaseJSONParser;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class JWTTokenResponseSerDes {

	public static JWTTokenResponse toDTO(String json) {
		JWTTokenResponseJSONParser jwtTokenResponseJSONParser =
			new JWTTokenResponseJSONParser();

		return jwtTokenResponseJSONParser.parseToDTO(json);
	}

	public static JWTTokenResponse[] toDTOs(String json) {
		JWTTokenResponseJSONParser jwtTokenResponseJSONParser =
			new JWTTokenResponseJSONParser();

		return jwtTokenResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(JWTTokenResponse jwtTokenResponse) {
		if (jwtTokenResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (jwtTokenResponse.getJwtToken() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"jwtToken\": ");

			sb.append("\"");

			sb.append(_escape(jwtTokenResponse.getJwtToken()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		JWTTokenResponseJSONParser jwtTokenResponseJSONParser =
			new JWTTokenResponseJSONParser();

		return jwtTokenResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(JWTTokenResponse jwtTokenResponse) {
		if (jwtTokenResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (jwtTokenResponse.getJwtToken() == null) {
			map.put("jwtToken", null);
		}
		else {
			map.put("jwtToken", String.valueOf(jwtTokenResponse.getJwtToken()));
		}

		return map;
	}

	public static class JWTTokenResponseJSONParser
		extends BaseJSONParser<JWTTokenResponse> {

		@Override
		protected JWTTokenResponse createDTO() {
			return new JWTTokenResponse();
		}

		@Override
		protected JWTTokenResponse[] createDTOArray(int size) {
			return new JWTTokenResponse[size];
		}

		@Override
		protected void setField(
			JWTTokenResponse jwtTokenResponse, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "jwtToken")) {
				if (jsonParserFieldValue != null) {
					jwtTokenResponse.setJwtToken((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}
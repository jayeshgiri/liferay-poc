package liferay.jwt.custom.token.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import liferay.jwt.custom.token.client.dto.v1_0.JWTTokenRequest;
import liferay.jwt.custom.token.client.json.BaseJSONParser;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class JWTTokenRequestSerDes {

	public static JWTTokenRequest toDTO(String json) {
		JWTTokenRequestJSONParser jwtTokenRequestJSONParser =
			new JWTTokenRequestJSONParser();

		return jwtTokenRequestJSONParser.parseToDTO(json);
	}

	public static JWTTokenRequest[] toDTOs(String json) {
		JWTTokenRequestJSONParser jwtTokenRequestJSONParser =
			new JWTTokenRequestJSONParser();

		return jwtTokenRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(JWTTokenRequest jwtTokenRequest) {
		if (jwtTokenRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (jwtTokenRequest.getEncodedToken() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"encodedToken\": ");

			sb.append("\"");

			sb.append(_escape(jwtTokenRequest.getEncodedToken()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		JWTTokenRequestJSONParser jwtTokenRequestJSONParser =
			new JWTTokenRequestJSONParser();

		return jwtTokenRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(JWTTokenRequest jwtTokenRequest) {
		if (jwtTokenRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (jwtTokenRequest.getEncodedToken() == null) {
			map.put("encodedToken", null);
		}
		else {
			map.put(
				"encodedToken",
				String.valueOf(jwtTokenRequest.getEncodedToken()));
		}

		return map;
	}

	public static class JWTTokenRequestJSONParser
		extends BaseJSONParser<JWTTokenRequest> {

		@Override
		protected JWTTokenRequest createDTO() {
			return new JWTTokenRequest();
		}

		@Override
		protected JWTTokenRequest[] createDTOArray(int size) {
			return new JWTTokenRequest[size];
		}

		@Override
		protected void setField(
			JWTTokenRequest jwtTokenRequest, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "encodedToken")) {
				if (jsonParserFieldValue != null) {
					jwtTokenRequest.setEncodedToken(
						(String)jsonParserFieldValue);
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
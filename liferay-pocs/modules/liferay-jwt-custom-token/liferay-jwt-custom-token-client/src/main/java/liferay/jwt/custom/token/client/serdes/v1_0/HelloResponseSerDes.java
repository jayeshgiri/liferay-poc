package liferay.jwt.custom.token.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import liferay.jwt.custom.token.client.dto.v1_0.HelloResponse;
import liferay.jwt.custom.token.client.json.BaseJSONParser;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public class HelloResponseSerDes {

	public static HelloResponse toDTO(String json) {
		HelloResponseJSONParser helloResponseJSONParser =
			new HelloResponseJSONParser();

		return helloResponseJSONParser.parseToDTO(json);
	}

	public static HelloResponse[] toDTOs(String json) {
		HelloResponseJSONParser helloResponseJSONParser =
			new HelloResponseJSONParser();

		return helloResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(HelloResponse helloResponse) {
		if (helloResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (helloResponse.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(helloResponse.getMessage()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		HelloResponseJSONParser helloResponseJSONParser =
			new HelloResponseJSONParser();

		return helloResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(HelloResponse helloResponse) {
		if (helloResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (helloResponse.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(helloResponse.getMessage()));
		}

		return map;
	}

	public static class HelloResponseJSONParser
		extends BaseJSONParser<HelloResponse> {

		@Override
		protected HelloResponse createDTO() {
			return new HelloResponse();
		}

		@Override
		protected HelloResponse[] createDTOArray(int size) {
			return new HelloResponse[size];
		}

		@Override
		protected void setField(
			HelloResponse helloResponse, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					helloResponse.setMessage((String)jsonParserFieldValue);
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
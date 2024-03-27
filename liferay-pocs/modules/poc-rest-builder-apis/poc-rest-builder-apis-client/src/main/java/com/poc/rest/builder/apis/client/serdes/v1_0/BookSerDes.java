package com.poc.rest.builder.apis.client.serdes.v1_0;

import com.poc.rest.builder.apis.client.dto.v1_0.Book;
import com.poc.rest.builder.apis.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Jayesh Goswami
 * @generated
 */
@Generated("")
public class BookSerDes {

	public static Book toDTO(String json) {
		BookJSONParser bookJSONParser = new BookJSONParser();

		return bookJSONParser.parseToDTO(json);
	}

	public static Book[] toDTOs(String json) {
		BookJSONParser bookJSONParser = new BookJSONParser();

		return bookJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Book book) {
		if (book == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (book.getAuthor() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"author\": ");

			sb.append("\"");

			sb.append(_escape(book.getAuthor()));

			sb.append("\"");
		}

		if (book.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(book.getId());
		}

		if (book.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(book.getTitle()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		BookJSONParser bookJSONParser = new BookJSONParser();

		return bookJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Book book) {
		if (book == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (book.getAuthor() == null) {
			map.put("author", null);
		}
		else {
			map.put("author", String.valueOf(book.getAuthor()));
		}

		if (book.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(book.getId()));
		}

		if (book.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(book.getTitle()));
		}

		return map;
	}

	public static class BookJSONParser extends BaseJSONParser<Book> {

		@Override
		protected Book createDTO() {
			return new Book();
		}

		@Override
		protected Book[] createDTOArray(int size) {
			return new Book[size];
		}

		@Override
		protected void setField(
			Book book, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "author")) {
				if (jsonParserFieldValue != null) {
					book.setAuthor((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					book.setId(Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					book.setTitle((String)jsonParserFieldValue);
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
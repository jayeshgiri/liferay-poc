package hb.user.management.api.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import hb.user.management.api.client.dto.v1_0.UserCreationResponse;
import hb.user.management.api.client.http.HttpInvoker;
import hb.user.management.api.client.pagination.Page;
import hb.user.management.api.client.resource.v1_0.UserCreationResponseResource;
import hb.user.management.api.client.serdes.v1_0.UserCreationResponseSerDes;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author JayeshGoswami
 * @generated
 */
@Generated("")
public abstract class BaseUserCreationResponseResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_userCreationResponseResource.setContextCompany(testCompany);

		UserCreationResponseResource.Builder builder =
			UserCreationResponseResource.builder();

		userCreationResponseResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		UserCreationResponse userCreationResponse1 =
			randomUserCreationResponse();

		String json = objectMapper.writeValueAsString(userCreationResponse1);

		UserCreationResponse userCreationResponse2 =
			UserCreationResponseSerDes.toDTO(json);

		Assert.assertTrue(equals(userCreationResponse1, userCreationResponse2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		UserCreationResponse userCreationResponse =
			randomUserCreationResponse();

		String json1 = objectMapper.writeValueAsString(userCreationResponse);
		String json2 = UserCreationResponseSerDes.toJSON(userCreationResponse);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		UserCreationResponse userCreationResponse =
			randomUserCreationResponse();

		userCreationResponse.setEmailAddress(regex);
		userCreationResponse.setMessage(regex);
		userCreationResponse.setStatus(regex);

		String json = UserCreationResponseSerDes.toJSON(userCreationResponse);

		Assert.assertFalse(json.contains(regex));

		userCreationResponse = UserCreationResponseSerDes.toDTO(json);

		Assert.assertEquals(regex, userCreationResponse.getEmailAddress());
		Assert.assertEquals(regex, userCreationResponse.getMessage());
		Assert.assertEquals(regex, userCreationResponse.getStatus());
	}

	@Test
	public void testCreateUsers() throws Exception {
		Assert.assertTrue(false);
	}

	protected void assertContains(
		UserCreationResponse userCreationResponse,
		List<UserCreationResponse> userCreationResponses) {

		boolean contains = false;

		for (UserCreationResponse item : userCreationResponses) {
			if (equals(userCreationResponse, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			userCreationResponses + " does not contain " + userCreationResponse,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		UserCreationResponse userCreationResponse1,
		UserCreationResponse userCreationResponse2) {

		Assert.assertTrue(
			userCreationResponse1 + " does not equal " + userCreationResponse2,
			equals(userCreationResponse1, userCreationResponse2));
	}

	protected void assertEquals(
		List<UserCreationResponse> userCreationResponses1,
		List<UserCreationResponse> userCreationResponses2) {

		Assert.assertEquals(
			userCreationResponses1.size(), userCreationResponses2.size());

		for (int i = 0; i < userCreationResponses1.size(); i++) {
			UserCreationResponse userCreationResponse1 =
				userCreationResponses1.get(i);
			UserCreationResponse userCreationResponse2 =
				userCreationResponses2.get(i);

			assertEquals(userCreationResponse1, userCreationResponse2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<UserCreationResponse> userCreationResponses1,
		List<UserCreationResponse> userCreationResponses2) {

		Assert.assertEquals(
			userCreationResponses1.size(), userCreationResponses2.size());

		for (UserCreationResponse userCreationResponse1 :
				userCreationResponses1) {

			boolean contains = false;

			for (UserCreationResponse userCreationResponse2 :
					userCreationResponses2) {

				if (equals(userCreationResponse1, userCreationResponse2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				userCreationResponses2 + " does not contain " +
					userCreationResponse1,
				contains);
		}
	}

	protected void assertValid(UserCreationResponse userCreationResponse)
		throws Exception {

		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (userCreationResponse.getEmailAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (userCreationResponse.getMessage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (userCreationResponse.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (userCreationResponse.getUserId() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<UserCreationResponse> page) {
		boolean valid = false;

		java.util.Collection<UserCreationResponse> userCreationResponses =
			page.getItems();

		int size = userCreationResponses.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					hb.user.management.api.dto.v1_0.UserCreationResponse.
						class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		UserCreationResponse userCreationResponse1,
		UserCreationResponse userCreationResponse2) {

		if (userCreationResponse1 == userCreationResponse2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userCreationResponse1.getEmailAddress(),
						userCreationResponse2.getEmailAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userCreationResponse1.getMessage(),
						userCreationResponse2.getMessage())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userCreationResponse1.getStatus(),
						userCreationResponse2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						userCreationResponse1.getUserId(),
						userCreationResponse2.getUserId())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_userCreationResponseResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_userCreationResponseResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		UserCreationResponse userCreationResponse) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("emailAddress")) {
			sb.append("'");
			sb.append(String.valueOf(userCreationResponse.getEmailAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("message")) {
			sb.append("'");
			sb.append(String.valueOf(userCreationResponse.getMessage()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
			sb.append("'");
			sb.append(String.valueOf(userCreationResponse.getStatus()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("userId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected UserCreationResponse randomUserCreationResponse()
		throws Exception {

		return new UserCreationResponse() {
			{
				emailAddress =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				message = StringUtil.toLowerCase(RandomTestUtil.randomString());
				status = StringUtil.toLowerCase(RandomTestUtil.randomString());
				userId = RandomTestUtil.randomInt();
			}
		};
	}

	protected UserCreationResponse randomIrrelevantUserCreationResponse()
		throws Exception {

		UserCreationResponse randomIrrelevantUserCreationResponse =
			randomUserCreationResponse();

		return randomIrrelevantUserCreationResponse;
	}

	protected UserCreationResponse randomPatchUserCreationResponse()
		throws Exception {

		return randomUserCreationResponse();
	}

	protected UserCreationResponseResource userCreationResponseResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseUserCreationResponseResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private hb.user.management.api.resource.v1_0.UserCreationResponseResource
		_userCreationResponseResource;

}
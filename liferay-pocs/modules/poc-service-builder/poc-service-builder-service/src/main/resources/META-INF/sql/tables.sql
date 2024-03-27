create table POC_School (
	uuid_ VARCHAR(75) null,
	schoolId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	address VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	foundationDate DATE null
);
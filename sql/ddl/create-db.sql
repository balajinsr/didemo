CREATE TABLE image (
	tagid varchar(15) NOT NULL,
	vr varchar(50) NOT NULL,
	value varchar(500) NOT NULL,
	CONSTRAINT tagid_unique UNIQUE (tagid)
);


CREATE TABLE series (
	tagid varchar(15) NOT NULL,
	vr varchar(50) NOT NULL,
	value varchar(500) NOT NULL,
	CONSTRAINT tagid_ser_unique UNIQUE (tagid)
);

CREATE TABLE study (
	tagid varchar(15) NOT NULL,
	vr varchar(50) NOT NULL,
	value varchar(500) NOT NULL,
	CONSTRAINT tagid_study_unique UNIQUE (tagid)
);
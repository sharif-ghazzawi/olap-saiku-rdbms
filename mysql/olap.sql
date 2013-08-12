drop table if exists word;
drop table if exists person;
drop table if exists extracted_location;
drop table if exists extracted_date;
drop table if exists publication_date;
drop table if exists ingest_date;
drop table if exists collection_date;
drop table if exists classification;
drop table if exists source;
drop table if exists document_length_group;
drop table if exists document_length_percentile;
drop table if exists word_stem_percentile;
drop table if exists organization;
drop table if exists wordfact;
drop table if exists personfact;
drop table if exists organizationfact;
drop table if exists document;

create table word(
  wordId binary(16) not null,
  word varchar(40),
  stem varchar(40),
  fine varchar(40),
  medium varchar(40),
  coarse varchar(40),
  primary key (wordId));

create table person(
  personId binary(16) not null,
  person varchar(40),
  fine varchar(40),
  medium varchar(40),
  coarse varchar(40),
  primary key (personId));

create table document(
  documentId binary(16) not null,
  documentTitle varchar(40),
  docfulltext text,
  primary key (documentId));

create table extracted_location(
  locationId binary(16) not null,
  locationName varchar(100),
  countryId binary(16),
  countryName varchar(100),
  commandId binary(16),
  commandName varchar(20),
  latitude float,
  longitude float,
  primary key (locationId)); 

create table extracted_date(
  dateId binary(16) not null,
  exDateMonth tinyint unsigned,
  exDateYear smallint unsigned,
  primary key(dateId));

create table publication_date(
  pubDateId binary(16) not null,
  pubDateMonth tinyint unsigned,
  pubDateYear smallint unsigned,
  primary key(pubDateId));

create table ingest_date(
  ingDateId binary(16) not null,
  ingDateMonth tinyint unsigned,
  ingDateYear smallint unsigned,
  primary key(ingDateId));

create table collection_date(
  colDateId binary(16) not null,
  colDateMonth tinyint unsigned,
  colDateYear smallint unsigned,
  primary key(colDateId));

create table classification(
  classificationId binary(16) not null,
  classification varchar(50),
  primary key(classificationId));

create table source(
  sourceId binary(16) not null,
  source varchar(60),
  sourceType varchar(60),
  primary key(sourceId));

create table document_length_group(
  groupId tinyint unsigned not null,
  docLengthLower tinyint unsigned,
  docLengthUpper tinyint unsigned,
  docLengthGroupCoarsId binary(16),
  docLengthCoarseLower tinyint unsigned,
  docLengthCoarseUpper tinyint unsigned,
  primary key (groupId));

create table document_length_percentile(
  percentileId tinyint unsigned not null,
  docLengthPercentileLower tinyint unsigned,
  docLengthPercentileUpper tinyint unsigned,
  docLengthPercentileCoarseId binary(16),
  docLengthPercentileCoarseLower tinyint unsigned,
  docLengthPercentileCoarseUpper tinyint unsigned,
  primary key (percentileId));

create table word_stem_percentile(
  percentileId tinyint unsigned not null,
  wordStemPercentileLower tinyint unsigned,
  wordStemPercentileUpper tinyint unsigned,
  wordStemPercentileCoarseId binary(16),
  wordStemPercentileCoarseLower tinyint unsigned,
  wordStemPercentileCoarseUpper tinyint unsigned,
  primary key (percentileId));

create table organization(
  organizationId binary(16) not null,
  organization varchar(40),
  fine varchar(40),
  medium varchar(40),
  coarse varchar(40),
  primary key (organizationId));

create table wordfact(
  factId binary(16) not null,
  wordId binary(16),
  foreign key(wordId) references word(wordId),
  documentId binary(16),
  foreign key (documentId) references document(documentId),
  exLocationId binary(16),
  foreign key (exLocationId) references extracted_location(locationId),
  exDateId binary(16),
  foreign key (exDateId) references extracted_date(dateId),
  pubDateId binary(16),
  foreign key (pubDateId) references publication_date(pubDateId),
  ingDateId binary(16),
  foreign key (ingDateId) references ingest_date(ingDateId),
  colDateId binary(16),
  foreign key (colDateId) references collection_date(colDateId),
  classificationId binary(16),
  foreign key (classificationId) references classification(classificationId),
  sourceId binary(16),
  foreign key (sourceId) references source(sourceId),
  docLengthGroup tinyint unsigned,
  foreign key(docLengthGroup) references document_length_group(groupId),
  docLengthPercentile tinyint unsigned,
  foreign key(docLengthPercentile) references document_length_percentile(percentileId),
  wordStemPercentile tinyint unsigned,
  foreign key(wordStemPercentile) references word_stem_percentile(percentileId),
  wordDocCount tinyint unsigned,
  wordDocCountShare tinyint unsigned,
  postion tinyint unsigned,
  position_percentile tinyint unsigned,
  primary key(factId));

create table personfact(
  factId binary(16) not null,
  personId binary(16),
  foreign key(personId) references person(personId),
  documentId binary(16),
  foreign key (documentId) references document(documentId),
  exLocationId binary(16),
  foreign key (exLocationId) references extracted_location(locationId),
  exDateId binary(16),
  foreign key (exDateId) references extracted_date(dateId),
  pubDateId binary(16),
  foreign key (pubDateId) references publication_date(pubDateId),
  ingDateId binary(16),
  foreign key (ingDateId) references ingest_date(ingDateId),
  colDateId binary(16),
  foreign key (colDateId) references collection_date(colDateId),
  classificationId binary(16),
  foreign key (classificationId) references classification(classificationId),
  sourceId binary(16),
  foreign key (sourceId) references source(sourceId),
  docLengthGroup tinyint unsigned,
  foreign key(docLengthGroup) references document_length_group(groupId),
  docLengthPercentile tinyint unsigned,
  foreign key(docLengthPercentile) references document_length_percentile(percentileId),
  wordStemPercentile tinyint unsigned,
  foreign key(wordStemPercentile) references word_stem_percentile(percentileId),
  wordDocCount tinyint unsigned,
  wordDocCountShare tinyint unsigned,
  postion tinyint unsigned,
  position_percentile tinyint unsigned,
  primary key(factId));

create table organizationfact(
  factId binary(16) not null,
  organizationId binary(16),
  foreign key(organizationId) references organization(organizationId),
  documentId binary(16),
  foreign key (documentId) references document(documentId),
  exLocationId binary(16),
  foreign key (exLocationId) references extracted_location(locationId),
  exDateId binary(16),
  foreign key (exDateId) references extracted_date(dateId),
  pubDateId binary(16),
  foreign key (pubDateId) references publication_date(pubDateId),
  ingDateId binary(16),
  foreign key (ingDateId) references ingest_date(ingDateId),
  colDateId binary(16),
  foreign key (colDateId) references collection_date(colDateId),
  classificationId binary(16),
  foreign key (classificationId) references classification(classificationId),
  sourceId binary(16),
  foreign key (sourceId) references source(sourceId),
  docLengthGroup tinyint unsigned,
  foreign key(docLengthGroup) references document_length_group(groupId),
  docLengthPercentile tinyint unsigned,
  foreign key(docLengthPercentile) references document_length_percentile(percentileId),
  wordStemPercentile tinyint unsigned,
  foreign key(wordStemPercentile) references word_stem_percentile(percentileId),
  wordDocCount tinyint unsigned,
  wordDocCountShare tinyint unsigned,
  postion tinyint unsigned,
  position_percentile tinyint unsigned,
  primary key(factId));

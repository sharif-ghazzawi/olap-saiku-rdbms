USE OLAP;

DROP TABLE IF EXISTS `classification`;
DROP TABLE IF EXISTS `document`;
DROP TABLE IF EXISTS `document_fact`;
DROP TABLE IF EXISTS `document_length_group`;
DROP TABLE IF EXISTS `extracted_location`;
DROP TABLE IF EXISTS `full_date`;
DROP TABLE IF EXISTS `organization`;
DROP TABLE IF EXISTS `organization_fact`;
DROP TABLE IF EXISTS `percentile`;
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `person_fact`;
DROP TABLE IF EXISTS `source`;
DROP TABLE IF EXISTS `word`;
DROP TABLE IF EXISTS `word_fact`;

CREATE TABLE `classification` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `document` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `drsi_doc_id` varchar(40) DEFAULT NULL,
  `title` varchar(120) DEFAULT NULL,
  `body` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `document_fact` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `document_id` int(10) unsigned DEFAULT NULL,
  `extracted_location_id` int(10) unsigned DEFAULT NULL,
  `extracted_date_id` int(10) unsigned DEFAULT NULL,
  `publication_date_id` int(10) unsigned DEFAULT NULL,
  `ingest_date_id` int(10) unsigned DEFAULT NULL,
  `collection_date_id` int(10) unsigned DEFAULT NULL,
  `classification_id` int(10) unsigned DEFAULT NULL,
  `source_id` int(10) unsigned DEFAULT NULL,
  `document_length_group_id` int(10) unsigned DEFAULT NULL,
  `document_length_percentile_id` int(10) unsigned DEFAULT NULL,
  `document_length_words` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Document_DocumentFact` FOREIGN KEY (document_id) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_DocumentFact` FOREIGN KEY (extracted_location_id) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_DocumentFact` FOREIGN KEY (extracted_date_id) REFERENCES date(id),
  CONSTRAINT `FK_PublicationDate_DocumentFact` FOREIGN KEY (publication_date_id) REFERENCES date(id),
  CONSTRAINT `FK_IngestDate_DocumentFact` FOREIGN KEY (ingest_date_id) REFERENCES date(id),
  CONSTRAINT `FK_CollectionDate_DocumentFact` FOREIGN KEY (collection_date_id) REFERENCES date(id),
  CONSTRAINT `FK_Classification_DocumentFact` FOREIGN KEY (classification_id) REFERENCES classification(id),
  CONSTRAINT `FK_Source_DocumentFact` FOREIGN KEY (source_id) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_DocumentFact` FOREIGN KEY (document_length_group_id) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_DocumentFact` FOREIGN KEY (document_length_percentile_id) REFERENCES percentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `document_length_group` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `fine_name` varchar(20) DEFAULT NULL,
  `fine_lower` int(10) unsigned DEFAULT NULL,
  `fine_upper` int(10) unsigned DEFAULT NULL,
  `coarse_name` varchar(20) DEFAULT NULL,
  `coarse_lower` int(10) unsigned DEFAULT NULL,
  `coarse_upper` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `extracted_location` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `clavin_id` int(10) DEFAULT NULL,
  `location_name` varchar(100) DEFAULT NULL,
  `country_clavin_id` int(10) DEFAULT NULL,
  `country_iso` varchar(4) DEFAULT NULL,
  `country_name` varchar(100) DEFAULT NULL,
  `command` varchar(8) DEFAULT NULL,
  `subnational_clavin_id` int(10) DEFAULT NULL,
  `subnational_name` varchar(100) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `full_date` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `year` smallint(4) unsigned DEFAULT NULL,
  `month` tinyint(2) unsigned DEFAULT NULL,
  `month_name` varchar(3) DEFAULT NULL,
  `day_of_month` tinyint(2) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `organization` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `concept` varchar(120) DEFAULT NULL,
  `fine_id` int(10) unsigned DEFAULT NULL,
  `fine_name` varchar(200) DEFAULT NULL,
  `entity_key` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `organization_fact` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `organization_id` int(10) unsigned DEFAULT NULL,
  `document_id` int(10) unsigned DEFAULT NULL,
  `extracted_location_id` int(10) unsigned DEFAULT NULL,
  `extracted_date_id` int(10) unsigned DEFAULT NULL,
  `publication_date_id` int(10) unsigned DEFAULT NULL,
  `ingest_date_id` int(10) unsigned DEFAULT NULL,
  `collection_date_id` int(10) unsigned DEFAULT NULL,
  `classification_id` int(10) unsigned DEFAULT NULL,
  `source_id` int(10) unsigned DEFAULT NULL,
  `document_length_group_id` int(10) unsigned DEFAULT NULL,
  `document_length_percentile_id` int(10) unsigned DEFAULT NULL,
  `document_length_words` int(10) unsigned DEFAULT NULL,
  `org_percentile_id` int(10) unsigned DEFAULT NULL,
  `org_frequency` int(10) unsigned DEFAULT NULL,
  `org_frequency_share` float DEFAULT NULL,
  `position` int(10) unsigned DEFAULT NULL,
  `position_percentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Organization_OrganizationFact` FOREIGN KEY (organization_id) REFERENCES organization(id),
  CONSTRAINT `FK_Document_OrganizationFact` FOREIGN KEY (document_id) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_OrganizationFact` FOREIGN KEY (extracted_location_id) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_OrganizationFact` FOREIGN KEY (extracted_date_id) REFERENCES date(id),
  CONSTRAINT `FK_PublicationDate_OrganizationFact` FOREIGN KEY (publication_date_id) REFERENCES date(id),
  CONSTRAINT `FK_IngestDate_OrganizationFact` FOREIGN KEY (ingest_date_id) REFERENCES date(id),
  CONSTRAINT `FK_CollectionDate_OrganizationFact` FOREIGN KEY (collection_date_id) REFERENCES date(id),
  CONSTRAINT `FK_Classification_OrganizationFact` FOREIGN KEY (classification_id) REFERENCES classification(id),
  CONSTRAINT `FK_Source_OrganizationFact` FOREIGN KEY (source_id) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_OrganizationFact` FOREIGN KEY (document_length_group_id) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_OrganizationFact` FOREIGN KEY (document_length_percentile_id) REFERENCES percentile(id),
  CONSTRAINT `FK_OrganizationPercentile_OrganizationFact` FOREIGN KEY (org_percentile_id) REFERENCES percentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `percentile` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `percentile` tinyint(3) unsigned NOT NULL,
  `coarse_name_length` varchar(24) DEFAULT NULL,
  `coarse_name_position` varchar(24) DEFAULT NULL,
  `coarse_name_commonness` varchar(24) DEFAULT NULL,
  `coarse_lower` tinyint(3) unsigned DEFAULT NULL,
  `coarse_upper` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `person` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `name` varchar(160) DEFAULT NULL,
  `concept` varchar(160) DEFAULT NULL,
  `fine_id` int(10) unsigned DEFAULT NULL,
  `fine_name` varchar(160) DEFAULT NULL,
  `entity_key` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `person_fact` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `person_id` int(10) unsigned DEFAULT NULL,
  `document_id` int(10) unsigned DEFAULT NULL,
  `extracted_location_id` int(10) unsigned DEFAULT NULL,
  `extracted_date_id` int(10) unsigned DEFAULT NULL,
  `publication_date_id` int(10) unsigned DEFAULT NULL,
  `ingest_date_id` int(10) unsigned DEFAULT NULL,
  `collection_date_id` int(10) unsigned DEFAULT NULL,
  `classification_id` int(10) unsigned DEFAULT NULL,
  `source_id` int(10) unsigned DEFAULT NULL,
  `document_length_group_id` int(10) unsigned DEFAULT NULL,
  `document_length_percentile_id` int(10) unsigned DEFAULT NULL,
  `document_length_words` int(10) unsigned DEFAULT NULL,
  `person_percentile_id` int(10) unsigned DEFAULT NULL,
  `person_frequency` int(10) unsigned DEFAULT NULL,
  `person_frequency_share` float DEFAULT NULL,
  `position` int(10) unsigned DEFAULT NULL,
  `position_percentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Person_PersonFact` FOREIGN KEY (person_id) REFERENCES person(id),
  CONSTRAINT `FK_Document_PersonFact` FOREIGN KEY (document_id) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_PersonFact` FOREIGN KEY (extracted_location_id) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_PersonFact` FOREIGN KEY (extracted_date_id) REFERENCES date(id),
  CONSTRAINT `FK_PublicationDate_PersonFact` FOREIGN KEY (publication_date_id) REFERENCES date(id),
  CONSTRAINT `FK_IngestDate_PersonFact` FOREIGN KEY (ingest_date_id) REFERENCES date(id),
  CONSTRAINT `FK_CollectionDate_PersonFact` FOREIGN KEY (collection_date_id) REFERENCES date(id),
  CONSTRAINT `FK_Classification_PersonFact` FOREIGN KEY (classification_id) REFERENCES classification(id),
  CONSTRAINT `FK_Source_PersonFact` FOREIGN KEY (source_id) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_PersonFact` FOREIGN KEY (document_length_group_id) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_PersonFact` FOREIGN KEY (document_length_percentile_id) REFERENCES percentile(id),
  CONSTRAINT `FK_PersonPercentile_PersonFact` FOREIGN KEY (person_percentile_id) REFERENCES percentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `source` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `word` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `word` varchar(40) DEFAULT NULL,
  `stem` varchar(40) DEFAULT NULL,
  `fine_id` int(10) unsigned DEFAULT NULL,
  `fine_name` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `word_fact` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `word_id` int(10) unsigned DEFAULT NULL,
  `document_id` int(10) unsigned DEFAULT NULL,
  `extracted_location_id` int(10) unsigned DEFAULT NULL,
  `extracted_date_id` int(10) unsigned DEFAULT NULL,
  `publication_date_id` int(10) unsigned DEFAULT NULL,
  `ingest_date_id` int(10) unsigned DEFAULT NULL,
  `collection_date_id` int(10) unsigned DEFAULT NULL,
  `classification_id` int(10) unsigned DEFAULT NULL,
  `source_id` int(10) unsigned DEFAULT NULL,
  `document_length_group_id` int(10) unsigned DEFAULT NULL,
  `document_length_percentile_id` int(10) unsigned DEFAULT NULL,
  `document_length_words` int(10) unsigned DEFAULT NULL,
  `word_stem_percentile_id` int(10) unsigned DEFAULT NULL,
  `word_frequency` int(10) unsigned DEFAULT NULL,
  `word_frequency_share` float DEFAULT NULL,
  `position` int(10) unsigned DEFAULT NULL,
  `position_percentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Word_WordFact` FOREIGN KEY (word_id) REFERENCES word(id),
  CONSTRAINT `FK_Document_WordFact` FOREIGN KEY (document_id) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_WordFact` FOREIGN KEY (extracted_location_id) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_WordFact` FOREIGN KEY (extracted_date_id) REFERENCES date(id),
  CONSTRAINT `FK_PublicationDate_WordFact` FOREIGN KEY (publication_date_id) REFERENCES date(id),
  CONSTRAINT `FK_IngestDate_WordFact` FOREIGN KEY (ingest_date_id) REFERENCES date(id),
  CONSTRAINT `FK_CollectionDate_WordFact` FOREIGN KEY (collection_date_id) REFERENCES date(id),
  CONSTRAINT `FK_Classification_WordFact` FOREIGN KEY (classification_id) REFERENCES classification(id),
  CONSTRAINT `FK_Source_WordFact` FOREIGN KEY (source_id) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_WordFact` FOREIGN KEY (document_length_group_id) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_WordFact` FOREIGN KEY (document_length_percentile_id) REFERENCES percentile(id),
  CONSTRAINT `FK_WordStemPercentile_WordFact` FOREIGN KEY (word_stem_percentile_id) REFERENCES percentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
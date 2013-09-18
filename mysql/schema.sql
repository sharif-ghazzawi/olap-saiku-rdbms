USE OLAP;

DROP TABLE IF EXISTS `classification`;
DROP TABLE IF EXISTS `date`;
DROP TABLE IF EXISTS `document`;
DROP TABLE IF EXISTS `documentLengthGroup`;
DROP TABLE IF EXISTS `extractedLocation`;
DROP TABLE IF EXISTS `organization`;
DROP TABLE IF EXISTS `organizationFact`;
DROP TABLE IF EXISTS `percentile`;
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `personFact`;
DROP TABLE IF EXISTS `source`;
DROP TABLE IF EXISTS `word`;
DROP TABLE IF EXISTS `wordFact`;

CREATE TABLE `classification` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `date` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `year` smallint(4) unsigned DEFAULT NULL,
  `month` tinyint(2) unsigned DEFAULT NULL,
  `monthName` varchar(3) DEFAULT NULL,
  `dayOfMonth` tinyint(2) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `document` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `drsiDocId` varchar(40) DEFAULT NULL,
  `title` varchar(120) DEFAULT NULL,
  `body` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `documentFact` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `documentId` int(10) unsigned DEFAULT NULL,
  `extractedLocationId` int(10) unsigned DEFAULT NULL,
  `extractedDateId` int(10) unsigned DEFAULT NULL,
  `publicationDateId` int(10) unsigned DEFAULT NULL,
  `ingestDateId` int(10) unsigned DEFAULT NULL,
  `collectionDateId` int(10) unsigned DEFAULT NULL,
  `classificationId` int(10) unsigned DEFAULT NULL,
  `sourceId` int(10) unsigned DEFAULT NULL,
  `documentLengthGroupId` int(10) unsigned DEFAULT NULL,
  `documentLengthPercentileId` int(10) unsigned DEFAULT NULL,
  `documentLengthWords` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Document_DocumentFact` FOREIGN KEY (documentId) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_DocumentFact` FOREIGN KEY (extractedLocationId) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_DocumentFact` FOREIGN KEY (extractedDateId) REFERENCES date(id),
  CONSTRAINT `FK_PublicationDate_DocumentFact` FOREIGN KEY (publicationDateId) REFERENCES date(id),
  CONSTRAINT `FK_IngestDate_DocumentFact` FOREIGN KEY (ingestDateId) REFERENCES date(id),
  CONSTRAINT `FK_CollectionDate_DocumentFact` FOREIGN KEY (collectionDateId) REFERENCES date(id),
  CONSTRAINT `FK_Classification_DocumentFact` FOREIGN KEY (classificationId) REFERENCES classification(id),
  CONSTRAINT `FK_Source_DocumentFact` FOREIGN KEY (sourceId) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_DocumentFact` FOREIGN KEY (documentLengthGroupId) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_DocumentFact` FOREIGN KEY (documentLengthPercentileId) REFERENCES percentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `documentLengthGroup` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `fineName` varchar(20) DEFAULT NULL,
  `fineLower` int(10) unsigned DEFAULT NULL,
  `fineUpper` int(10) unsigned DEFAULT NULL,
  `coarseName` varchar(20) DEFAULT NULL,
  `coarseLower` int(10) unsigned DEFAULT NULL,
  `coarseUpper` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `extractedDate` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `year` smallint(4) unsigned DEFAULT NULL,
  `month` tinyint(2) unsigned DEFAULT NULL,
  `monthName` varchar(3) DEFAULT NULL,
  `dayOfMonth` tinyint(2) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `extractedLocation` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `clavinId` int(10) DEFAULT NULL,
  `locationName` varchar(100) DEFAULT NULL,
  `countryClavinId` int(10) DEFAULT NULL,
  `countryIso` varchar(4) DEFAULT NULL,
  `countryName` varchar(100) DEFAULT NULL,
  `command` varchar(8) DEFAULT NULL,
  `subnationalClavinId` int(10) DEFAULT NULL,
  `subnationalName` varchar(100) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `organization` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `name` varchar(120) DEFAULT NULL,
  `concept` varchar(120) DEFAULT NULL,
  `fineId` int(10) unsigned DEFAULT NULL,
  `fineName` varchar(200) DEFAULT NULL,
  `entityKey` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `organizationFact` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `organizationId` int(10) unsigned DEFAULT NULL,
  `documentId` int(10) unsigned DEFAULT NULL,
  `extractedLocationId` int(10) unsigned DEFAULT NULL,
  `extractedDateId` int(10) unsigned DEFAULT NULL,
  `publicationDateId` int(10) unsigned DEFAULT NULL,
  `ingestDateId` int(10) unsigned DEFAULT NULL,
  `collectionDateId` int(10) unsigned DEFAULT NULL,
  `classificationId` int(10) unsigned DEFAULT NULL,
  `sourceId` int(10) unsigned DEFAULT NULL,
  `documentLengthGroupId` int(10) unsigned DEFAULT NULL,
  `documentLengthPercentileId` int(10) unsigned DEFAULT NULL,
  `documentLengthWords` int(10) unsigned DEFAULT NULL,
  `orgPercentileId` int(10) unsigned DEFAULT NULL,
  `orgFrequency` int(10) unsigned DEFAULT NULL,
  `orgFrequencyShare` float DEFAULT NULL,
  `position` int(10) unsigned DEFAULT NULL,
  `positionPercentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Organization_OrganizationFact` FOREIGN KEY (organizationId) REFERENCES organization(id),
  CONSTRAINT `FK_Document_OrganizationFact` FOREIGN KEY (documentId) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_OrganizationFact` FOREIGN KEY (extractedLocationId) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_OrganizationFact` FOREIGN KEY (extractedDateId) REFERENCES date(id),
  CONSTRAINT `FK_PublicationDate_OrganizationFact` FOREIGN KEY (publicationDateId) REFERENCES date(id),
  CONSTRAINT `FK_IngestDate_OrganizationFact` FOREIGN KEY (ingestDateId) REFERENCES date(id),
  CONSTRAINT `FK_CollectionDate_OrganizationFact` FOREIGN KEY (collectionDateId) REFERENCES date(id),
  CONSTRAINT `FK_Classification_OrganizationFact` FOREIGN KEY (classificationId) REFERENCES classification(id),
  CONSTRAINT `FK_Source_OrganizationFact` FOREIGN KEY (sourceId) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_OrganizationFact` FOREIGN KEY (documentLengthGroupId) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_OrganizationFact` FOREIGN KEY (documentLengthPercentileId) REFERENCES percentile(id),
  CONSTRAINT `FK_OrganizationPercentile_OrganizationFact` FOREIGN KEY (orgPercentileId) REFERENCES percentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `percentile` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `percentile` tinyint(3) unsigned NOT NULL,
  `coarseNameLength` varchar(24) DEFAULT NULL,
  `coarseNamePosition` varchar(24) DEFAULT NULL,
  `coarseNameCommonness` varchar(24) DEFAULT NULL,
  `coarseLower` tinyint(3) unsigned DEFAULT NULL,
  `coarseUpper` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `person` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `name` varchar(160) DEFAULT NULL,
  `concept` varchar(160) DEFAULT NULL,
  `fineId` int(10) unsigned DEFAULT NULL,
  `fineName` varchar(160) DEFAULT NULL,
  `entityKey` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `personFact` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `personId` int(10) unsigned DEFAULT NULL,
  `documentId` int(10) unsigned DEFAULT NULL,
  `extractedLocationId` int(10) unsigned DEFAULT NULL,
  `extractedDateId` int(10) unsigned DEFAULT NULL,
  `publicationDateId` int(10) unsigned DEFAULT NULL,
  `ingestDateId` int(10) unsigned DEFAULT NULL,
  `collectionDateId` int(10) unsigned DEFAULT NULL,
  `classificationId` int(10) unsigned DEFAULT NULL,
  `sourceId` int(10) unsigned DEFAULT NULL,
  `documentLengthGroupId` int(10) unsigned DEFAULT NULL,
  `documentLengthPercentileId` int(10) unsigned DEFAULT NULL,
  `documentLengthWords` int(10) unsigned DEFAULT NULL,
  `personPercentileId` int(10) unsigned DEFAULT NULL,
  `personFrequency` int(10) unsigned DEFAULT NULL,
  `personFrequencyShare` float DEFAULT NULL,
  `position` int(10) unsigned DEFAULT NULL,
  `positionPercentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Person_PersonFact` FOREIGN KEY (personId) REFERENCES person(id),
  CONSTRAINT `FK_Document_PersonFact` FOREIGN KEY (documentId) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_PersonFact` FOREIGN KEY (extractedLocationId) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_PersonFact` FOREIGN KEY (extractedDateId) REFERENCES date(id),
  CONSTRAINT `FK_PublicationDate_PersonFact` FOREIGN KEY (publicationDateId) REFERENCES date(id),
  CONSTRAINT `FK_IngestDate_PersonFact` FOREIGN KEY (ingestDateId) REFERENCES date(id),
  CONSTRAINT `FK_CollectionDate_PersonFact` FOREIGN KEY (collectionDateId) REFERENCES date(id),
  CONSTRAINT `FK_Classification_PersonFact` FOREIGN KEY (classificationId) REFERENCES classification(id),
  CONSTRAINT `FK_Source_PersonFact` FOREIGN KEY (sourceId) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_PersonFact` FOREIGN KEY (documentLengthGroupId) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_PersonFact` FOREIGN KEY (documentLengthPercentileId) REFERENCES percentile(id),
  CONSTRAINT `FK_PersonPercentile_PersonFact` FOREIGN KEY (personPercentileId) REFERENCES percentile(id)
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
  `fineId` int(10) unsigned DEFAULT NULL,
  `fineName` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

CREATE TABLE `wordFact` (
  `id` int(10) unsigned AUTO_INCREMENT UNIQUE NOT NULL,
  `wordId` int(10) unsigned DEFAULT NULL,
  `documentId` int(10) unsigned DEFAULT NULL,
  `extractedLocationId` int(10) unsigned DEFAULT NULL,
  `extractedDateId` int(10) unsigned DEFAULT NULL,
  `publicationDateId` int(10) unsigned DEFAULT NULL,
  `ingestDateId` int(10) unsigned DEFAULT NULL,
  `collectionDateId` int(10) unsigned DEFAULT NULL,
  `classificationId` int(10) unsigned DEFAULT NULL,
  `sourceId` int(10) unsigned DEFAULT NULL,
  `documentLengthGroupId` int(10) unsigned DEFAULT NULL,
  `documentLengthPercentileId` int(10) unsigned DEFAULT NULL,
  `documentLengthWords` int(10) unsigned DEFAULT NULL,
  `wordStemPercentileId` int(10) unsigned DEFAULT NULL,
  `wordFrequency` int(10) unsigned DEFAULT NULL,
  `wordFrequencyShare` float DEFAULT NULL,
  `position` int(10) unsigned DEFAULT NULL,
  `positionPercentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Word_WordFact` FOREIGN KEY (wordId) REFERENCES word(id),
  CONSTRAINT `FK_Document_WordFact` FOREIGN KEY (documentId) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_WordFact` FOREIGN KEY (extractedLocationId) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_WordFact` FOREIGN KEY (extractedDateId) REFERENCES date(id),
  CONSTRAINT `FK_PublicationDate_WordFact` FOREIGN KEY (publicationDateId) REFERENCES date(id),
  CONSTRAINT `FK_IngestDate_WordFact` FOREIGN KEY (ingestDateId) REFERENCES date(id),
  CONSTRAINT `FK_CollectionDate_WordFact` FOREIGN KEY (collectionDateId) REFERENCES date(id),
  CONSTRAINT `FK_Classification_WordFact` FOREIGN KEY (classificationId) REFERENCES classification(id),
  CONSTRAINT `FK_Source_WordFact` FOREIGN KEY (sourceId) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_WordFact` FOREIGN KEY (documentLengthGroupId) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_WordFact` FOREIGN KEY (documentLengthPercentileId) REFERENCES percentile(id),
  CONSTRAINT `FK_WordStemPercentile_WordFact` FOREIGN KEY (wordStemPercentileId) REFERENCES percentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
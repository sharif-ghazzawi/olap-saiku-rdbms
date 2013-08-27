USE OLAP;

DROP TABLE IF EXISTS `classification`;
DROP TABLE IF EXISTS `collectionDate`;
DROP TABLE IF EXISTS `command`;
DROP TABLE IF EXISTS `document`;
DROP TABLE IF EXISTS `documentLengthGroup`;
DROP TABLE IF EXISTS `documentLengthPercentile`;
DROP TABLE IF EXISTS `extractedDate`;
DROP TABLE IF EXISTS `extractedLocation`;
DROP TABLE IF EXISTS `ingestDate`;
DROP TABLE IF EXISTS `organization`;
DROP TABLE IF EXISTS `organizationFact`;
DROP TABLE IF EXISTS `organizationPercentile`;
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `personFact`;
DROP TABLE IF EXISTS `publicationDate`;
DROP TABLE IF EXISTS `source`;
DROP TABLE IF EXISTS `word`;
DROP TABLE IF EXISTS `wordFact`;
DROP TABLE IF EXISTS `wordStemPercentile`;

CREATE TABLE `classification` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `collectionDate` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `command` (
  `id` int(10) unsigned UNIQUE NOT NULL,
  `name` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO command (id, name) VALUES (1, 'NORTHCOM');
INSERT INTO command (id, name) VALUES (2, 'SOUTHCOM');
INSERT INTO command (id, name) VALUES (3, 'EUCOM');
INSERT INTO command (id, name) VALUES (4, 'CENTCOM');
INSERT INTO command (id, name) VALUES (5, 'AFRICOM');
INSERT INTO command (id, name) VALUES (6, 'PACOM');
INSERT INTO command (id, name) VALUES (7, 'N/A');

CREATE TABLE `document` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `title` varchar(40) DEFAULT NULL,
  `fullText` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `documentLengthGroup` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `fineName` varchar(20) DEFAULT NULL,
  `fineLower` int(10) unsigned DEFAULT NULL,
  `fineUpper` int(10) unsigned DEFAULT NULL,
  `coarseName` varchar(20) DEFAULT NULL,
  `coarseLower` int(10) unsigned DEFAULT NULL,
  `coarseUpper` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `documentLengthPercentile` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `percentile` tinyint(3) unsigned NOT NULL,
  `coarseName` varchar(20) DEFAULT NULL,
  `coarseLower` tinyint(3) unsigned DEFAULT NULL,
  `coarseUpper` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `extractedDate` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `extractedLocation` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `clavinId` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `countryClavinId` int(10) DEFAULT NULL,
  `countryIso` varchar(4) DEFAULT NULL,
  `countryName` varchar(100) DEFAULT NULL,
  `commandId` int(10) unsigned DEFAULT NULL,
  `subnationalClavinId` int(10) DEFAULT NULL,
  `subnationalName` varchar(100) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Command_ExtractedLocation` FOREIGN KEY (commandId) REFERENCES command(id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `ingestDate` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `organization` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `concept` varchar(40) DEFAULT NULL,
  `fineId` int(10) unsigned DEFAULT NULL,
  `fineName` varchar(40) DEFAULT NULL,
  `mediumId` int(10) unsigned DEFAULT NULL,
  `mediumName` varchar(40) DEFAULT NULL,
  `coarseId` int(10) unsigned DEFAULT NULL,
  `coarseName` varchar(40) DEFAULT NULL,
  `evImportance` float unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `organizationFact` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
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
  `orgFrequency` tinyint(3) unsigned DEFAULT NULL,
  `orgFrequencyShare` tinyint(3) unsigned DEFAULT NULL,
  `position` tinyint(3) unsigned DEFAULT NULL,
  `positionPercentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Organization_OrganizationFact` FOREIGN KEY (organizationId) REFERENCES organization(id),
  CONSTRAINT `FK_Document_OrganizationFact` FOREIGN KEY (documentId) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_OrganizationFact` FOREIGN KEY (extractedLocationId) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_OrganizationFact` FOREIGN KEY (extractedDateId) REFERENCES extractedDate(id),
  CONSTRAINT `FK_PublicationDate_OrganizationFact` FOREIGN KEY (publicationDateId) REFERENCES publicationDate(id),
  CONSTRAINT `FK_IngestDate_OrganizationFact` FOREIGN KEY (ingestDateId) REFERENCES ingestDate(id),
  CONSTRAINT `FK_CollectionDate_OrganizationFact` FOREIGN KEY (collectionDateId) REFERENCES collectionDate(id),
  CONSTRAINT `FK_Classification_OrganizationFact` FOREIGN KEY (classificationId) REFERENCES classification(id),
  CONSTRAINT `FK_Source_OrganizationFact` FOREIGN KEY (sourceId) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_OrganizationFact` FOREIGN KEY (documentLengthGroupId) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_OrganizationFact` FOREIGN KEY (documentLengthPercentileId) REFERENCES documentLengthPercentile(id),
  CONSTRAINT `FK_OrganizationPercentile_OrganizationFact` FOREIGN KEY (orgPercentileId) REFERENCES organizationPercentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `organizationPercentile` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `percentile` tinyint(3) unsigned NOT NULL,
  `coarseName` varchar(20) DEFAULT NULL,
  `coarseLower` tinyint(3) unsigned DEFAULT NULL,
  `coarseUpper` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `person` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `concept` varchar(40) DEFAULT NULL,
  `fineId` int(10) unsigned DEFAULT NULL,
  `fineName` varchar(40) DEFAULT NULL,
  `mediumId` int(10) unsigned DEFAULT NULL,
  `mediumName` varchar(40) DEFAULT NULL,
  `coarseId` int(10) unsigned DEFAULT NULL,
  `coarseName` varchar(40) DEFAULT NULL,
  `evImportance` float unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `personFact` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
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
  `wordFrequency` tinyint(3) unsigned DEFAULT NULL,
  `wordFrequencyShare` tinyint(3) unsigned DEFAULT NULL,
  `position` tinyint(3) unsigned DEFAULT NULL,
  `positionPercentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Person_PersonFact` FOREIGN KEY (personId) REFERENCES person(id),
  CONSTRAINT `FK_Document_PersonFact` FOREIGN KEY (documentId) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_PersonFact` FOREIGN KEY (extractedLocationId) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_PersonFact` FOREIGN KEY (extractedDateId) REFERENCES extractedDate(id),
  CONSTRAINT `FK_PublicationDate_PersonFact` FOREIGN KEY (publicationDateId) REFERENCES publicationDate(id),
  CONSTRAINT `FK_IngestDate_PersonFact` FOREIGN KEY (ingestDateId) REFERENCES ingestDate(id),
  CONSTRAINT `FK_CollectionDate_PersonFact` FOREIGN KEY (collectionDateId) REFERENCES collectionDate(id),
  CONSTRAINT `FK_Classification_PersonFact` FOREIGN KEY (classificationId) REFERENCES classification(id),
  CONSTRAINT `FK_Source_PersonFact` FOREIGN KEY (sourceId) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_PersonFact` FOREIGN KEY (documentLengthGroupId) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_PersonFact` FOREIGN KEY (documentLengthPercentileId) REFERENCES documentLengthPercentile(id),
  CONSTRAINT `FK_PersonPercentile_PersonFact` FOREIGN KEY (personPercentileId) REFERENCES personPercentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `personPercentile` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `percentile` tinyint(3) unsigned NOT NULL,
  `coarseName` varchar(20) DEFAULT NULL,
  `coarseLower` tinyint(3) unsigned DEFAULT NULL,
  `coarseUpper` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `publicationDate` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `source` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `word` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `concept` varchar(40) DEFAULT NULL,
  `fineId` int(10) unsigned DEFAULT NULL,
  `fineName` varchar(40) DEFAULT NULL,
  `mediumId` int(10) unsigned DEFAULT NULL,
  `mediumName` varchar(40) DEFAULT NULL,
  `coarseId` int(10) unsigned DEFAULT NULL,
  `coarseName` varchar(40) DEFAULT NULL,
  `evImportance` float unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `wordFact` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
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
  `wordFrequency` tinyint(3) unsigned DEFAULT NULL,
  `wordFrequencyShare` tinyint(3) unsigned DEFAULT NULL,
  `position` tinyint(3) unsigned DEFAULT NULL,
  `positionPercentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Word_WordFact` FOREIGN KEY (wordId) REFERENCES word(id),
  CONSTRAINT `FK_Document_WordFact` FOREIGN KEY (documentId) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_WordFact` FOREIGN KEY (extractedLocationId) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_WordFact` FOREIGN KEY (extractedDateId) REFERENCES extractedDate(id),
  CONSTRAINT `FK_PublicationDate_WordFact` FOREIGN KEY (publicationDateId) REFERENCES publicationDate(id),
  CONSTRAINT `FK_IngestDate_WordFact` FOREIGN KEY (ingestDateId) REFERENCES ingestDate(id),
  CONSTRAINT `FK_CollectionDate_WordFact` FOREIGN KEY (collectionDateId) REFERENCES collectionDate(id),
  CONSTRAINT `FK_Classification_WordFact` FOREIGN KEY (classificationId) REFERENCES classification(id),
  CONSTRAINT `FK_Source_WordFact` FOREIGN KEY (sourceId) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_WordFact` FOREIGN KEY (documentLengthGroupId) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_WordFact` FOREIGN KEY (documentLengthPercentileId) REFERENCES documentLengthPercentile(id),
  CONSTRAINT `FK_WordStemPercentile_WordFact` FOREIGN KEY (wordStemPercentileId) REFERENCES wordStemPercentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `wordStemPercentile` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `percentile` tinyint(3) unsigned NOT NULL,
  `coarseName` varchar(20) DEFAULT NULL,
  `coarseLower` tinyint(3) unsigned DEFAULT NULL,
  `coarseUpper` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
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
DROP TABLE IF EXISTS `person`;
DROP TABLE IF EXISTS `personFact`;
DROP TABLE IF EXISTS `publicationDate`;
DROP TABLE IF EXISTS `source`;
DROP TABLE IF EXISTS `word`;
DROP TABLE IF EXISTS `wordFact`;
DROP TABLE IF EXISTS `wordStemPercentile`;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classification` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collectionDate` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `month` tinyint(3) unsigned DEFAULT NULL,
  `year` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `command` (
  `id` int(10) unsigned UNIQUE NOT NULL,
  `name` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO command (id, name) VALUES (1, 'NORTHCOM');
INSERT INTO command (id, name) VALUES (2, 'SOUTHCOM');
INSERT INTO command (id, name) VALUES (3, 'EUCOM');
INSERT INTO command (id, name) VALUES (4, 'CENTCOM');
INSERT INTO command (id, name) VALUES (5, 'AFRICOM');
INSERT INTO command (id, name) VALUES (6, 'PACOM');
INSERT INTO command (id, name) VALUES (7, 'N/A');

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `title` varchar(40) DEFAULT NULL,
  `fullText` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentLengthGroup` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `lower` tinyint(3) unsigned DEFAULT NULL,
  `upper` tinyint(3) unsigned DEFAULT NULL,
  `coarseId` int(10) unsigned DEFAULT NULL,
  `coarseLower` tinyint(3) unsigned DEFAULT NULL,
  `coarseUpper` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentLengthPercentile` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `lower` tinyint(3) unsigned DEFAULT NULL,
  `upper` tinyint(3) unsigned DEFAULT NULL,
  `coarseId` int(10) unsigned DEFAULT NULL,
  `coarseLower` tinyint(3) unsigned DEFAULT NULL,
  `coarseUpper` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extractedDate` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `month` tinyint(3) unsigned DEFAULT NULL,
  `year` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `extractedLocation` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `clavinId` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `countryClavinId` int(10) DEFAULT NULL,
  `countryIso` varchar(4) DEFAULT NULL,
  `countryName` varchar(100) DEFAULT NULL,
  `command` int(10) unsigned DEFAULT NULL,
  `subnationalClavinId` int(10) DEFAULT NULL,
  `subnationalName` varchar(100) DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Command_ExtractedLocation` FOREIGN KEY (command) REFERENCES command(id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingestDate` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `month` tinyint(3) unsigned DEFAULT NULL,
  `year` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `fine` varchar(40) DEFAULT NULL,
  `medium` varchar(40) DEFAULT NULL,
  `coarse` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizationFact` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `organization` int(10) unsigned DEFAULT NULL,
  `document` int(10) unsigned DEFAULT NULL,
  `extractedLocation` int(10) unsigned DEFAULT NULL,
  `extractedDate` int(10) unsigned DEFAULT NULL,
  `publicationDate` int(10) unsigned DEFAULT NULL,
  `ingestDate` int(10) unsigned DEFAULT NULL,
  `collectionDate` int(10) unsigned DEFAULT NULL,
  `classification` int(10) unsigned DEFAULT NULL,
  `source` int(10) unsigned DEFAULT NULL,
  `documentLengthGroup` int(10) unsigned DEFAULT NULL,
  `documentLengthPercentile` int(10) unsigned DEFAULT NULL,
  `wordStemPercentile` int(10) unsigned DEFAULT NULL,
  `wordCount` tinyint(3) unsigned DEFAULT NULL,
  `wordCountShare` tinyint(3) unsigned DEFAULT NULL,
  `position` tinyint(3) unsigned DEFAULT NULL,
  `positionPercentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Organization_OrganizationFact` FOREIGN KEY (organization) REFERENCES organization(id),
  CONSTRAINT `FK_Document_OrganizationFact` FOREIGN KEY (document) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_OrganizationFact` FOREIGN KEY (extractedLocation) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_OrganizationFact` FOREIGN KEY (extractedDate) REFERENCES extractedDate(id),
  CONSTRAINT `FK_PublicationDate_OrganizationFact` FOREIGN KEY (publicationDate) REFERENCES publicationDate(id),
  CONSTRAINT `FK_IngestDate_OrganizationFact` FOREIGN KEY (ingestDate) REFERENCES ingestDate(id),
  CONSTRAINT `FK_CollectionDate_OrganizationFact` FOREIGN KEY (collectionDate) REFERENCES collectionDate(id),
  CONSTRAINT `FK_Classification_OrganizationFact` FOREIGN KEY (classification) REFERENCES classification(id),
  CONSTRAINT `FK_Source_OrganizationFact` FOREIGN KEY (source) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_OrganizationFact` FOREIGN KEY (documentLengthGroup) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_OrganizationFact` FOREIGN KEY (documentLengthPercentile) REFERENCES documentLengthPercentile(id),
  CONSTRAINT `FK_WordStemPercentile_OrganizationFact` FOREIGN KEY (wordStemPercentile) REFERENCES wordStemPercentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `fine` varchar(40) DEFAULT NULL,
  `medium` varchar(40) DEFAULT NULL,
  `coarse` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personFact` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `person` int(10) unsigned DEFAULT NULL,
  `document` int(10) unsigned DEFAULT NULL,
  `extractedLocation` int(10) unsigned DEFAULT NULL,
  `extractedDate` int(10) unsigned DEFAULT NULL,
  `publicationDate` int(10) unsigned DEFAULT NULL,
  `ingestDate` int(10) unsigned DEFAULT NULL,
  `collectionDate` int(10) unsigned DEFAULT NULL,
  `classification` int(10) unsigned DEFAULT NULL,
  `source` int(10) unsigned DEFAULT NULL,
  `documentLengthGroup` int(10) unsigned DEFAULT NULL,
  `documentLengthPercentile` int(10) unsigned DEFAULT NULL,
  `wordStemPercentile` int(10) unsigned DEFAULT NULL,
  `wordCount` tinyint(3) unsigned DEFAULT NULL,
  `wordCountShare` tinyint(3) unsigned DEFAULT NULL,
  `position` tinyint(3) unsigned DEFAULT NULL,
  `positionPercentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Person_PersonFact` FOREIGN KEY (person) REFERENCES person(id),
  CONSTRAINT `FK_Document_PersonFact` FOREIGN KEY (document) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_PersonFact` FOREIGN KEY (extractedLocation) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_PersonFact` FOREIGN KEY (extractedDate) REFERENCES extractedDate(id),
  CONSTRAINT `FK_PublicationDate_PersonFact` FOREIGN KEY (publicationDate) REFERENCES publicationDate(id),
  CONSTRAINT `FK_IngestDate_PersonFact` FOREIGN KEY (ingestDate) REFERENCES ingestDate(id),
  CONSTRAINT `FK_CollectionDate_PersonFact` FOREIGN KEY (collectionDate) REFERENCES collectionDate(id),
  CONSTRAINT `FK_Classification_PersonFact` FOREIGN KEY (classification) REFERENCES classification(id),
  CONSTRAINT `FK_Source_PersonFact` FOREIGN KEY (source) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_PersonFact` FOREIGN KEY (documentLengthGroup) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_PersonFact` FOREIGN KEY (documentLengthPercentile) REFERENCES documentLengthPercentile(id),
  CONSTRAINT `FK_WordStemPercentile_PersonFact` FOREIGN KEY (wordStemPercentile) REFERENCES wordStemPercentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publicationDate` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `month` tinyint(3) unsigned DEFAULT NULL,
  `year` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `source` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `type` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `word` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `word` varchar(40) DEFAULT NULL,
  `stem` varchar(40) DEFAULT NULL,
  `fine` varchar(40) DEFAULT NULL,
  `medium` varchar(40) DEFAULT NULL,
  `coarse` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wordFact` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `word` int(10) unsigned DEFAULT NULL,
  `document` int(10) unsigned DEFAULT NULL,
  `extractedLocation` int(10) unsigned DEFAULT NULL,
  `extractedDate` int(10) unsigned DEFAULT NULL,
  `publicationDate` int(10) unsigned DEFAULT NULL,
  `ingestDate` int(10) unsigned DEFAULT NULL,
  `collectionDate` int(10) unsigned DEFAULT NULL,
  `classification` int(10) unsigned DEFAULT NULL,
  `source` int(10) unsigned DEFAULT NULL,
  `documentLengthGroup` int(10) unsigned DEFAULT NULL,
  `documentLengthPercentile` int(10) unsigned DEFAULT NULL,
  `wordStemPercentile` int(10) unsigned DEFAULT NULL,
  `wordCount` tinyint(3) unsigned DEFAULT NULL,
  `wordCountShare` tinyint(3) unsigned DEFAULT NULL,
  `position` tinyint(3) unsigned DEFAULT NULL,
  `positionPercentile` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_Word_WordFact` FOREIGN KEY (word) REFERENCES word(id),
  CONSTRAINT `FK_Document_WordFact` FOREIGN KEY (document) REFERENCES document(id),
  CONSTRAINT `FK_ExtractedLocation_WordFact` FOREIGN KEY (extractedLocation) REFERENCES extractedLocation(id),
  CONSTRAINT `FK_ExtractedDate_WordFact` FOREIGN KEY (extractedDate) REFERENCES extractedDate(id),
  CONSTRAINT `FK_PublicationDate_WordFact` FOREIGN KEY (publicationDate) REFERENCES publicationDate(id),
  CONSTRAINT `FK_IngestDate_WordFact` FOREIGN KEY (ingestDate) REFERENCES ingestDate(id),
  CONSTRAINT `FK_CollectionDate_WordFact` FOREIGN KEY (collectionDate) REFERENCES collectionDate(id),
  CONSTRAINT `FK_Classification_WordFact` FOREIGN KEY (classification) REFERENCES classification(id),
  CONSTRAINT `FK_Source_WordFact` FOREIGN KEY (source) REFERENCES source(id),
  CONSTRAINT `FK_DocumentLengthGroup_WordFact` FOREIGN KEY (documentLengthGroup) REFERENCES documentLengthGroup(id),
  CONSTRAINT `FK_DocumentLengthPercentile_WordFact` FOREIGN KEY (documentLengthPercentile) REFERENCES documentLengthPercentile(id),
  CONSTRAINT `FK_WordStemPercentile_WordFact` FOREIGN KEY (wordStemPercentile) REFERENCES wordStemPercentile(id)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wordStemPercentile` (
  `id` int(10) unsigned AUTO_INCREMENT NOT NULL,
  `lower` tinyint(3) unsigned DEFAULT NULL,
  `upper` tinyint(3) unsigned DEFAULT NULL,
  `coarseId` int(10) unsigned DEFAULT NULL,
  `coarseLower` tinyint(3) unsigned DEFAULT NULL,
  `coarseUpper` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

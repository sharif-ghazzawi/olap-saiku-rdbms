package com.berico.olap.util;

public class Constants {
    public static final String WORD = "word";
    public static final String PERSON = "person";
    public static final String ORGANIZATION = "organization";

    public static final String DOCUMENT = "document";
    public static final String EXTRACTED_LOCATION = "extractedLocation";
    public static final String EXTRACTED_DATE = "extractedDate";
    public static final String PUBLICATION_DATE = "publicationDate";
    public static final String INGESTION_DATE = "ingestionDate";
    public static final String COLLECTION_DATE = "collectionDate";
    public static final String CLASSIFICATION = "classification";
    public static final String SOURCE = "source";
    public static final String DOCUMENT_LENGTH_GROUP = "documentLengthGroup";
    public static final String DOCUMENT_LENGTH_PERCENTILE = "documentLengthPercentile";
    public static final String WORD_STEM_PERCENTILE = "wordStemPercentile";
    public static final String ORGANIZATION_PERCENTILE = "organizationPercentile";
    public static final String PERSON_PERCENTILE = "personPercentile";

    public static final String NORTHCOM = "NORTHCOM";
    public static final String SOUTHCOM = "SOUTHCOM";
    public static final String EUCOM = "EUCOM";
    public static final String CENTCOM = "CENTCOM";
    public static final String AFRICOM = "AFRICOM";
    public static final String PACOM = "PACOM";
    public static final String NULL_COMMAND = "N/A";

    public static final String FK_COMMAND_EXTRACTEDLOCATION = "FK_Command_ExtractedLocation";

    public static final String FK_WORD_WORDFACT = "FK_Word_WordFact";
    public static final String FK_DOCUMENT_WORDFACT = "FK_Document_WordFact";
    public static final String FK_EXLOCATION_WORDFACT = "FK_ExtractedLocation_WordFact";
    public static final String FK_EXDATE_WORDFACT = "FK_ExtractedDate_WordFact";
    public static final String FK_PUBDATE_WORDFACT = "FK_PublicationDate_WordFact";
    public static final String FK_INGDATE_WORDFACT = "FK_IngestDate_WordFact";
    public static final String FK_COLDATE_WORDFACT = "FK_CollectionDate_WordFact";
    public static final String FK_CLASSIFICATION_WORDFACT = "FK_Classification_WordFact";
    public static final String FK_SOURCE_WORDFACT = "FK_Source_WordFact";
    public static final String FK_DOCLENGTHGROUP_WORDFACT = "FK_DocumentLengthGroup_WordFact";
    public static final String FK_DOCLENGTHPERCENTILE_WORDFACT = "FK_DocumentLengthPercentile_WordFact";
    public static final String FK_WORDSTEMPERCENTILE_WORDFACT = "FK_WordStemPercentile_WordFact";

    public static final String FK_PERSON_PERSONFACT = "FK_Word_PersonFact";
    public static final String FK_DOCUMENT_PERSONFACT = "FK_Document_PersonFact";
    public static final String FK_EXLOCATION_PERSONFACT = "FK_ExtractedLocation_PersonFact";
    public static final String FK_EXDATE_PERSONFACT = "FK_ExtractedDate_PersonFact";
    public static final String FK_PUBDATE_PERSONFACT = "FK_PublicationDate_PersonFact";
    public static final String FK_INGDATE_PERSONFACT = "FK_IngestDate_PersonFact";
    public static final String FK_COLDATE_PERSONFACT = "FK_CollectionDate_PersonFact";
    public static final String FK_CLASSIFICATION_PERSONFACT = "FK_Classification_PersonFact";
    public static final String FK_SOURCE_PERSONFACT = "FK_Source_PersonFact";
    public static final String FK_DOCLENGTHGROUP_PERSONFACT = "FK_DocumentLengthGroup_PersonFact";
    public static final String FK_DOCLENGTHPERCENTILE_PERSONFACT = "FK_DocumentLengthPercentile_PersonFact";
    public static final String FK_PERSONPERCENTILE_PERSONFACT = "FK_PersonPercentile_PersonFact";

    public static final String FK_ORG_ORGANIZATIONFACT = "FK_Organization_OrganizationFact";
    public static final String FK_DOCUMENT_ORGANIZATIONFACT = "FK_Document_OrganizationFact";
    public static final String FK_EXLOCATION_ORGANIZATIONFACT = "FK_ExtractedLocation_OrganizationFact";
    public static final String FK_EXDATE_ORGANIZATIONFACT = "FK_ExtractedDate_OrganizationFact";
    public static final String FK_PUBDATE_ORGANIZATIONFACT = "FK_PublicationDate_OrganizationFact";
    public static final String FK_INGDATE_ORGANIZATIONFACT = "FK_IngestDate_OrganizationFact";
    public static final String FK_COLDATE_ORGANIZATIONFACT = "FK_CollectionDate_OrganizationFact";
    public static final String FK_CLASSIFICATION_ORGANIZATIONFACT = "FK_Classification_OrganizationFact";
    public static final String FK_SOURCE_ORGANIZATIONFACT = "FK_Source_OrganizationFact";
    public static final String FK_DOCLENGTHGROUP_ORGANIZATIONFACT = "FK_DocumentLengthGroup_OrganizationFact";
    public static final String FK_DOCLENGTHPERCENTILE_ORGANIZATIONFACT = "FK_DocumentLengthPercentile_OrganizationFact";
    public static final String FK_ORGANIZATIONPERCENTILE_ORGANIZATIONFACT = "FK_OrganizationPercentile_OrganizationFact";
}

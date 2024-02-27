# Smart Document Analyzer

The Smart Document Analyzer is designed to securely upload and analyze documents, providing insights through natural language processing (NLP). It supports various document types, including PDFs, images, CSV files, and DOC files, offering functionalities like keyword extraction, sentiment analysis, and content summarization.

## Modules

The application is divided into two main modules:

1. **Secure File Uploader/Ingester**
2. **Text NLP Analysis**

## Secure File Uploader/Ingester

This module handles user authentication, secure file uploading, and the initial processing of files to extract text.

### API Endpoints and Functions

- **POST /api/auth/login**
  - Authenticates users and issues a session token.
  - **Parameters**: `username`, `password`
  - **Returns**: Session token if authentication is successful.

- **POST /api/files/upload**
  - Allows secure uploading of a document. Supports PDF, images, CSV, DOC, etc.
  - **Parameters**: `file` (multipart/form-data), `sessionToken`
  - **Returns**: File ID and confirmation of upload.

- **GET /api/files/{fileId}/text**
  - Retrieves text extracted from the uploaded document.
  - **Parameters**: `fileId`, `sessionToken`
  - **Returns**: Extracted text content.

## Text NLP Analysis

Performs deep text analysis, including keyword tagging, sentiment analysis, topic detection, and summarization.

### API Endpoints and Functions

- **POST /api/analysis/keywords**
  - Extracts keywords and topics from provided text or document ID.
  - **Parameters**: `text` or `documentId`, `sessionToken`
  - **Returns**: List of keywords and topics.

- **POST /api/analysis/sentiments**
  - Determines the sentiment (positive, neutral, negative) of sentences or paragraphs.
  - **Parameters**: `text` or `documentId`, `sessionToken`
  - **Returns**: Sentiment analysis results.

- **GET /api/analysis/search**
  - Searches documents or paragraphs based on keywords, with optional sentiment or topic filters.
  - **Parameters**: `keyword`, `sentiment`, `topic`, `sessionToken`
  - **Returns**: List of matching documents or text segments.

- **POST /api/analysis/summaries**
  - Generates a summary for a given document.
  - **Parameters**: `documentId`, `sessionToken`
  - **Returns**: Document summary.

- **POST /api/analysis/enrichment**
  - Discovers additional web content related to document's keywords.
  - **Parameters**: `keywords`, `sessionToken`
  - **Returns**: Links to related content.

- **POST /api/analysis/entities**
  - Identifies and extracts names, locations, institutions, and addresses.
  - **Parameters**: `text` or `documentId`, `sessionToken`
  - **Returns**: List of identified entities.

## Implementation Notes

- **Security**: Use JWT for authentication and secure API access.
- **Framework**: The project utilizes Spring Boot for streamlined RESTful service development.
- **Data Storage**: A combination of SQL and NoSQL databases is recommended for efficient data management and querying.
- **NLP Tools**: Integration with NLP libraries or services like Apache OpenNLP, Stanford NLP, or OpenAI is essential for text analysis.
- **File Conversion**: Apache PDFBox and Tesseract OCR are suggested for handling PDFs and image-based text extraction.


This project aims to provide a comprehensive solution for document analysis, leveraging the latest in secure file handling and NLP technologies.

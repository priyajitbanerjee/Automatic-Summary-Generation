package edu.ju.asg.dto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.ju.asg.exception.ASGException;

public class SentenceDetailsDTO extends ASGBaseDTO {
	/**
	 * The SentenceDetails Pk
	 */
	private long sentenceDetailsPk = -1;
	/**
	 * The Sentence Id
	 */
	private String sentenceId = null;
	/**
	 * The document Id of the sentence
	 */
	private String documentId = null;
	/**
	 * The file Id of the sentence
	 */
	private String fileId = null;
	/**
	 * The position of the sentence in the corresponding document
	 */
	private int position = -1;
	/**
	 * The content of the sentence
	 */
	private String content = null;
	/**
	 * The words of the sentence content
	 */
	private String[] contentWords = null;
	/**
	 * The Sentence content word count
	 */
	private int contentWordCount = -1;
	/**
	 * The INSERT SQL
	 */
	private static final String INSERT_SQL = "insert into sentence_details "
			+ "(sentence_id, document_id, file_id, "
			+ "position, content, content_words, "
			+ "content_word_count) values ( ?, ?, ?, ?, ?, ?, ? )";

	/**
	 * @return the sentenceDetailsPk
	 */
	public long getSentenceDetailsPk() {
		return sentenceDetailsPk;
	}

	/**
	 * @param sentenceDetailsPk
	 *            the sentenceDetailsPk to set
	 */
	public void setSentenceDetailsPk(long sentenceDetailsPk) {
		this.sentenceDetailsPk = sentenceDetailsPk;
	}

	/**
	 * @return the sentenceId
	 */
	public String getSentenceId() {
		return sentenceId;
	}

	/**
	 * @param sentenceId
	 *            the sentenceId to set
	 */
	public void setSentenceId(String sentenceId) {
		this.sentenceId = sentenceId;
	}

	/**
	 * @return the documentId
	 */
	public String getDocumentId() {
		return documentId;
	}

	/**
	 * @param documentId
	 *            the documentId to set
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	/**
	 * @return the fileId
	 */
	public String getFileId() {
		return fileId;
	}

	/**
	 * @param fileId
	 *            the fileId to set
	 */
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the contentWords
	 */
	public String[] getContentWords() {
		return contentWords;
	}

	/**
	 * @param contentWords
	 *            the contentWords to set
	 */
	public void setContentWords(String[] contentWords) {
		this.contentWords = contentWords;
	}

	/**
	 * @return the contentWordCount
	 */
	public int getContentWordCount() {
		return contentWordCount;
	}

	/**
	 * @param contentWordCount
	 *            the contentWordCount to set
	 */
	public void setContentWordCount(int contentWordCount) {
		this.contentWordCount = contentWordCount;
	}

	@Override
	protected void writeImpl(PreparedStatement ps) throws SQLException,
			ASGException {
		int i = 1;
		ps.setString(i++, this.getSentenceId());
		ps.setString(i++, this.getDocumentId());
		ps.setString(i++, this.getFileId());
		ps.setInt(i++, this.getPosition());
		ps.setString(i++, this.getContent());
		ps.setObject(i++, this.getContentWords());
		ps.setInt(i++, this.getContentWordCount());
	}

	@Override
	protected String getSQL() {
		return INSERT_SQL;
	}

}

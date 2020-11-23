/**
 * 
 */
package com.wilkef.ecrack.setup.dto;

/**
 * @author Satya Oct 3, 2020
 */

public class BoardDataDto {

	private Integer boardId;
	private String boardName;

	public Integer getBoardId() {
		return boardId;
	}

	public void setBoardId(Integer boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Override
	public String toString() {
		return "BoardDataDto [boardId=" + boardId + ", boardName=" + boardName + "]";
	}
}

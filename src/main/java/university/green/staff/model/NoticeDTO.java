package university.green.staff.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//학사정보DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class NoticeDTO {
	private int id;
	private String category;
	private String title;
	private String content;
	private Timestamp creatㄷdTime;
	private int views;
}

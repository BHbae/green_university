package university.green.staff.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//학사정보 - 공지사항

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Notice {
	private int id;
	private String category;
	private String title;
	private String content;
	private Timestamp creatdTime;
	private int views;
}

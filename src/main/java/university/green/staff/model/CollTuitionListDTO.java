package university.green.staff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
// 등록 - 단대별 등록금 리스트
public class CollTuitionListDTO {
	private int id;
	private String name;
	private int amount;

}
